
//商品选中与取消
var selectGood = function(eles){
	if(eles){
		eles.addEvent('click',function(){
			var ele=this.getElement("i");
			if(ele.hasClass("i_sel_on")){
				ele.removeClass("i_sel_on").addClass("i_sel");
			}else{
				ele.removeClass("i_sel").addClass("i_sel_on");
			}
			var sum=gettotalPrice(),total =gettotalNum();
			$("sumPrice").txt(sum);
			$("taotalNum").txt(total);
		})
		
	}
}
selectGood($$(".selected"));

//全选
var selectAll = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var ele =this,others=$$(".selected").getElements("i");
			if(ele.hasClass("i_sel_on")){
				ele.removeClass("i_sel_on").addClass("i_sel");
				others.each(function(ele,index){
					ele.removeClass("i_sel_on").addClass("i_sel");
				})
			}else{
				ele.removeClass("i_sel").addClass("i_sel_on");
				others.each(function(ele,index){
					ele.removeClass("i_sel").addClass("i_sel_on");
				})
			}
			var sum=gettotalPrice(),total =gettotalNum();
			$("sumPrice").txt(sum);
			$("taotalNum").txt(total);
		})
	}
}
selectAll($("selectallBtn"));

//编辑商品
var edit = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var ele=this,target=ele.attr("data");
			ele.addClass("dn");
			ele.getNext().removeClass("dn");
			$$(".editDiv_"+target).addClass("dn");
			$$(".finishDiv_"+target).removeClass("dn");
		})
	}

}
edit($$(".edit"));
//结束编辑商品
var finishEdit = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var ele=this,target=ele.attr("data"),goodId=ele.attr("goodId"),num=$("amountInput_"+target).txt().trim();
			ele.addClass("dn");
			ele.getPrevious().removeClass("dn");
			$$(".editDiv_"+target).removeClass("dn");
			$$(".finishDiv_"+target).addClass("dn");
			editGoodNum(ele,num);
		})
	}
}
finishEdit($$(".finish"));

//修改购物车中商品的数量
var editGoodNum = function(ele,num){
	new AjaxPost(ele,{
		url:'/LockController/editGoodNum',
		data:{
			goodId:ele.attr("goodId"),
			num:num
		},
		callback:function(json){
			
		}
	}).send();
	
}
var increaseNum = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var ele = this,target=ele.attr("data"),amountInput = $("amountInput_"+target),leftCountInput=$("leftCount_"+target),
			num=new Number(amountInput.txt()),toBuy=$("num_"+target),leftCount=Number(leftCountInput.txt().trim()),limitCount=Number(amountInput.attr("limitCount"));
			if(num>leftCount){
				$testRemind(ele,"库存不足！",1);
				setTimeout('$testRemind.hide()',3000);
				return;
			}
			if(limitCount>0 && num >=limitCount){
				$testRemind(leftCountInput,"超过限购数量！",1);
				setTimeout('$testRemind.hide()',3000);
				return;
			}
				amountInput.txt(num+1);
				toBuy.txt(num+1);
				var sum=gettotalPrice();
				$("sumPrice").txt(sum);
		})
		
	}
}
	increaseNum($$(".increaseNum"));
var decresNum = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var ele = this,target=ele.attr("data"),amountInput = $("amountInput_"+target),leftCountInput=$("leftCount_"+target),
			num=new Number(amountInput.txt()),toBuy=$("num_"+target),leftCount=Number(leftCountInput.txt().trim());
			if(num > 1){
				amountInput.txt(num-1);
				toBuy.txt(num-1);
			}
			var sum=gettotalPrice();
			$("sumPrice").txt(sum);
		})
		
	}
}
decresNum($$(".decreaseNum"));

var goodNumBlur= function(eles){
	if(eles){
		eles.addEvent('blur',function(){
			var ele = this,target=ele.attr("data"),leftCountInput=$("leftCount_"+target),num=new Number(ele.val().trim()),
				leftCount=Number(leftCountInput.txt().trim()),toBuy=$("num_"+target);
			if(num>leftCount){
				$testRemind(ele,"库存不足！",1);
				setTimeout('$testRemind.hide()',3000);
				return;
			}
			toBuy.txt(num);
			var sum=gettotalPrice();
			$("sumPrice").txt(sum);
		})
	}
	
}
goodNumBlur($$(".num_input"));


//计算选中商品价钱
var gettotalPrice = function(){
	var selectedArr = $$(".selected"),sumPrice=0;
	selectedArr.each(function(ele,index){
		if(ele.getElement("i").hasClass("i_sel_on")){
			var price =  new Number($("price_"+index).txt().trim()),num= new Number($("num_"+index).txt().trim());
			sumPrice+= price* num;
		}
	});
	return sumPrice.toFixed(2);
}
//计算选中商品
var gettotalNum = function(){
	var selectedArr = $$(".selected"),sumNum=0;
	selectedArr.each(function(ele,index){
		if(ele.getElement("i").hasClass("i_sel_on")){
			sumNum++;
		}
	});
	return sumNum;
}

//结算
var settleAccount = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var Ids = getGoodIds();
			new AjaxPost(this,{
				url:'/LockController/createOrder',
				data:{
					goodIds:Ids
				},
				callback:function(json){
					if(json.succ){
						window.location.href=json.html;
					}else{
						Ibox.open({
							url:'<div class="p1 lh20 bbc f14">不好意思，商品:'+json.msg+'库存不足，请减少购买数量或购买其他商品。</div>'+
								'<div class="p1 tc">'+
									'<a id="closeBtn" class="greenbtn bdrad05" href="javascript:;">确定</a>'+
								'</div>',
							width: 260,
							title: '库存不足',
							onShow: function(){
								$("iboxBtnClose").out();
								$("closeBtn").addEvent('click', function(){
									Ibox.close();
									$pageFresh();
								})
							}
						});
					}
				}
			}).send();
			
			
		})
	}
}
settleAccount($("settleAccount"));

//获取选中的商品
var getGoodIds = function(){
	var selectedArr = $$(".selected"),goodIds="";
	selectedArr.each(function(ele,index){
		if(ele.getElement("i").hasClass("i_sel_on")){
			goodIds+=ele.attr("data")+",";
		}
	});
	return goodIds;
}