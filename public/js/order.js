

//保存地址
var saveAddress = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var nameInput=$("name"),cellInut=$("cell"),postCodeInput=$("postCode"),addressInput=$("address"),
				locationInput=$("location");
			if($isEmpty(nameInput)){
				$testRemind(nameInput, "请输入姓名", 1);
				setTimeout('$testRemind.hide()',3000);
			}else if($isEmpty(cellInut)){
				$testRemind(cellInut, "请输入手机号", 1);
				setTimeout('$testRemind.hide()',3000);
			}else if($isEmpty(postCodeInput)){
				$testRemind(postCodeInput, "请输入邮编", 1);
				setTimeout('$testRemind.hide()',3000);
			}else if($isEmpty(addressInput)){
				$testRemind(addressInput, "请输入地区", 1);
				setTimeout('$testRemind.hide()',3000);
			} else if($isEmpty(locationInput)){
				$testRemind(locationInput, "请输入详细地址", 1);
				setTimeout('$testRemind.hide()',3000);
			}else {
				new AjaxPost(this, {
					url: '/ExclusiveController/saveAddress',
					data: {
						orderSumId:ele.attr("data"),
						memberId:ele.attr("memberId"),
						name:nameInput.val().trim(),
						cell:cellInut.val().trim(),
						post:postCodeInput.val().trim(),
						address:addressInput.val().trim(),
						location:locationInput.val().trim()
					},
					callback: function(json){
						if(json.succ){
							window.location.href=json.html;
						}
					}
				}).send();
			}
		})
	}
	
}
saveAddress($("savAddress"));


//支付方式
var payMode = function(eles){
	if(eles){
		eles.addEvent('click',function(){
			var ele=this;
			ele.getSiblings().removeClass("select_on");
			ele.addClass("select_on");
		})
	}
}
payMode($$(".payMode"));

//配送方式
var deliverMode = function(eles){
	if(eles){
		eles.addEvent('click',function(){
			var ele=this,location=$("location"),deliver = ele.txt().trim();
			if(deliver=="送货上门"){
				location.hide();
			}else{
				location.show();
			}
			ele.getSiblings().removeClass("select_on");
			ele.addClass("select_on");
		})
	}
}
deliverMode($$(".deliver"));

//自提地点
var selectLocation = function(eles){
	if(eles){
		eles.addEvent('click',function(){
			var ele=this;
			$$(".locations").getElements("i").each(function(item,index){
				item.removeClass("i_sel_on").addClass("i_sel")
			});
			ele.getElement("i").removeClass("i_sel").addClass("i_sel_on");
		})
	}
}
selectLocation($$(".locations"));

var dateOper = function(ele){
	if(ele){
		new Datepicker(ele, $("dateInput"));
	}
	
}
dateOper($("dateInput"));

//保存配送方式
var saveDeliverMode = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var payMode="",deliverMode="",time=$("dateInput").val().trim(),locationId="",time="";
			$$(".payMode").each(function(item,index){
				if(item.hasClass("select_on")){
					payMode=item.get('text');
					return;
				}
			});
			$$(".deliver").each(function(item,index){
				if(item.hasClass("select_on")){
					deliverMode=item.get('text');
					return;
				}
			});
			if(deliverMode=="到点自提"){
				time= $("dateInput").val().trim();
				$$(".getLocation").each(function(item,index){
					if(item.hasClass("i_sel_on")){
						locationId=item.attr("data");
						return;
					}
				});
			}
			
			new AjaxPost(this, {
				url: '/ExclusiveController/saveDeliverMode',
				data: {
					orderSumId:ele.attr("data"),
					payMode:payMode,
					deliverMode:deliverMode,
					time:time,
					locationId:locationId,
				},
				callback: function(json){
					if(json.succ){
						window.location.href=json.html;
					}
				}
			}).send();
			
		})
	}
	
}
saveDeliverMode($("saveDeliverMode"));


//保存发票内容
var   invoiceContent = function(eles){
	if(eles){
		eles.addEvent('click',function(){
			var ele=this;
			eles.each(function(item,index){
				item.removeClass("i_sel_on").addClass("i_sel");
			});
			ele.removeClass("i_sel").addClass("i_sel_on");
			if(ele.attr("data")=="不开发票"){
				$("Title").addClass("dn");
			}else{
				$("Title").removeClass("dn");
			}
		})
	}
}
invoiceContent($$(".invoice"));

//保存发票内容
var saveInvoice = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var invoiceTitle = $("invoiceTitle"),invoiceContent="",eles=$$(".invoice"),orderSumId=this.attr("data");
			eles.each(function(item,index){
				if(item.hasClass("i_sel_on")){
					invoiceContent=item.attr("data");
				}
			});
			new AjaxPost(this, {
				url: '/ExclusiveController/saveInvoice',
				data: {
					orderSumId:orderSumId,
					title:invoiceTitle.val().trim(),
					content:invoiceContent
				},
				callback: function(json){
					if(json.succ){
						window.location.href=json.html;
					}
				}
			}).send();
		})
	}
}
saveInvoice($$(".saveInvoice"));



//返回角度
function GetSlideAngle(dx, dy) {
    return Math.atan2(dy, dx) * 180 / Math.PI;
}
//根据起点和终点返回方向 1：向上，2：向下，3：向左，4：向右,0：未滑动
function GetSlideDirection(startX, startY, endX, endY) {
    var dy = startY - endY;
    var dx = endX - startX;
    var result = 0; 
    //如果滑动距离太短
    if (Math.abs(dx) < 2 && Math.abs(dy) < 2) {
        return result;
    } 
    var angle = GetSlideAngle(dx, dy);
    if (angle >= -45 && angle < 45) {
        result = 4;
    } else if (angle >= 45 && angle < 135) {
        result = 1;
    } else if (angle >= -135 && angle < -45) {
        result = 2;
    }
    else if ((angle >= 135 && angle <= 180) || (angle >= -180 && angle < -135)) {
        result = 3;
    }
    return result;
}
//滑动处理
var startX, startY;
if(	$('slideBtn')){
	$('slideBtn').addEvent('touchstart', function (ev) {
	    startX = ev.touches[0].pageX;
	    startY = ev.touches[0].pageY;  
	}, false);
}

if(	$('slideBtn')){
	$('slideBtn').addEvent('touchend', function (ev) {
	    var endX, endY;
	    endX = ev.changedTouches[0].pageX;
	    endY = ev.changedTouches[0].pageY;
	    var direction = GetSlideDirection(startX, startY, endX, endY);
	    switch (direction) {
	        case 3:
	            event.target.style.left=0;	
	             $$('.slidebar').addClass('dn');
	             increasePrice();
	            break;
	        case 4:
	        	var usePoints = $("usePoints");
				if(Number(usePoints.val().trim())<10){
					$testRemind(usePoints,"使用的积分不能少于10个积分！",1);
					setTimeout('$testRemind.hide()',3000);
					break;
				}
	            event.target.style.left="25px";	
	            $$('.slidebar').removeClass('dn');
	            decreasePrice();
	            break;
	        default:           
	    }  
	}, false);
}
//积分多少
var useIntegral = function(ele){
	if(ele){
		ele.addEvent('keyup',function(){
			var total=new Number(this.attr("data")),useNum = new Number(this.val().trim()),deduction=$("deduction"),integral=$("integral");
			if(useNum > total){
				$testRemind(this,"使用的积分不能多于您的积分数！",1);
				setTimeout('$testRemind.hide()',3000);
				return;
			}
			deduction.txt((useNum/100).toFixed(2));
		})
	}
}
useIntegral($$(".point_input"));
//积分抵钱
var decreasePrice = function(){
	var decr = new Number( $("deduction").txt().trim()),integral=$("integral"),realPriceInput=$("realPrice"),realPrice=new Number(realPriceInput.txt().trim());
	integral.txt(decr.toFixed(2));
	realPriceInput.txt((realPrice-decr).toFixed(2));
}
var increasePrice = function(){
	var decr = new Number( $("deduction").txt().trim()),integral=$("integral"),realPriceInput=$("realPrice"),realPrice=new Number(realPriceInput.txt().trim());
	integral.txt(0.00);
	realPriceInput.txt((realPrice+decr).toFixed(2));
}


//提交订单
var subOrder = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var usePoints = new Number($("integral").txt().trim())*100;
			if($("addressNull")){
				$testRemind(this, "请填写地址", 1);
				setTimeout('$testRemind.hide()',3000);
				return;
			}
			new AjaxPost(this, {
				url: '/ExclusiveController/subOrder',
				data: {
					orderSumId:ele.attr("data"),
					usePoints:usePoints
				},
				callback: function(json){
					if(json.succ){
						window.location.href=json.html;
					}
				}
			}).send();
		})
		
	}
}
subOrder($("subOrderBtn"));




//确认收货
var jsForConfirmReceive = $$(".jsForConfirmReceive");
if($isArr(jsForConfirmReceive)){
	jsForConfirmReceive.addEvent('click', function(){
		var ele = this, sumId = this.attr('data');
		Ibox.open({
				url:'<div class="p1 lh20 bbc f14">您确认收货吗？</div>'+
					'<div class="p1 tc">'+
						'<a id="cancelBtn" class="mr15 graybtn2 bdrad05" href="javascript:;">取消</a>'+
						'<a id="confirmBtn" class="greenbtn bdrad05" href="javascript:;">确定</a>'+
					'</div>',
				width: 260,
				title: '确认收货',
				onShow: function(){
					this.closbtn.invisible();
					var ibox = this;
					$("cancelBtn").addEvent('click', function(){
						Ibox.close();
					})
					$("confirmBtn").addEvent('click', function(){
						ibox.loading();
						new AjaxPost(this, {
							url: '/ExclusiveController/confirmReceive',
							data: {
								sumId: sumId,
								memberId:ele.attr("memberId")
								},
							callback: function(json){
								if(json.succ){
									alert("操作成功");
									window.location.href=json.html;
									
								}
							}
						}).send();
					})
				}
			});
	})
}
// 更多订单
var moreOrderSumBtn = $("moreOrderSumBtn");
if($isEle(moreOrderSumBtn) && moreOrderSumBtn.isInto()){
	moreOrderSumBtn.addEvent('click', function(){
		var ownerId = this.attr('data').split('|')[0], page = this.attr('data').split('|')[1];
		new AjaxPost(this, {
			url: '/ShopController/jsonMoreOrderSums',
			data: {
				ownerId: ownerId,
				page: page
			},
			callback: function(json){
				if(json.succ){
					new Element('div').html(json.html).inject(moreOrderSumBtn, 'before');
					if(new Number(json.pageCount) == new Number(page)){
						moreOrderSumBtn.out();
					}
				}
			}
		}).send();
	})
}
// 取消订单
var jsForCancelOrder = $$('.jsForCancelOrder');
if($isArr(jsForCancelOrder)){
	jsForCancelOrder.addEvent('click', function(){
		var ele = this, sumId = this.attr('data');
		Ibox.open({
			url:'<div class="p1 lh20 bbc f14">您确认取消订单吗？</div>'+
				'<div class="p1 tc">'+
					'<a id="cancelBtn" class="mr15 graybtn2 bdrad05" href="javascript:;">取消</a>'+
					'<a id="confirmBtn" class="greenbtn bdrad05" href="javascript:;">确定</a>'+
				'</div>',
			width: 260,
			title: '取消订单',
			onShow: function(){
				$("iboxBtnClose").out();
				$("cancelBtn").addEvent('click', function(){
					Ibox.close();
				})
				$("confirmBtn").addEvent('click', function(){
					new AjaxPost(ele, {
						url: '/ExclusiveController/cancelOrderSum',
						data: {sumId: sumId},
						callback: function(json){
							if(json.succ){
								Ibox.alert("成功取消订单", function(){
									window.location.href=json.html;
								});
							}else{
								alert(json.msg);
							}
						}
					}).send();
				})
			}
		});
	});
}


var getMoreGoods = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var item=this, pageCount=Number(item.attr("pageCount")),currPage=Number(item.attr("currPage"));
			if(currPage>=pageCount){
				item.addClass("abs_out");
				return;
			}
			new AjaxPost(this,{
				url:'/ExclusiveController/moreOrders',
				data:{
					page:currPage+1,
					memberId:item.attr("data")
				},
				callback:function(json){
					if(json.succ){
						$("orderLIst").appendHTML(json.html);
						item.attr("currPage",currPage+1);
					}
				}
			}).send();
			
		})
	}
}

getMoreGoods($("getMoreOrder"));