//搜索商品
var searchGoods = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var searchInput = $("searchInput");
			if($isEmpty(searchInput)){
				$testRemind(searchInput, "请输入要搜索的问题", 1);
				setTimeout('$testRemind.hide()',3000);
			}else{
				new AjaxPost(this, {
					url: '/LockController/searchByConditions',
					data: {
						name: searchInput.val(),
						place:searchInput.attr("place"),
						typeId:searchInput.attr("typeId"),
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

searchGoods($("searchBtn"));

//分类下拉框
window.addEvent('click',function(event){
	if($("sortSelectBtn")){
		var ele=$("sortSelectBtn"),selectBox=$$('.sort_select_box'),target=event.target;
		if(target == ele||target == ele.getElement("i")||target == ele.getElement("p")){
			selectBox.toggleClass('dn');
		}else {
			selectBox.addClass('dn');
		}
	}
	
})

//弹出添加到购物车
var jsonAddCart = function(eles){
	if(eles){
		eles.addEvent('click',function(){
			var ele = this,goodId=ele.attr("data");
			new AjaxPost(this, {
				url: '/LockController/jsonAddCart',
				data: {
					goodId:goodId 
				},
				callback: function(json){
					if(json.succ){
						$("container").html(json.html).removeClass('dn');
						var h=window.getHeight();
					    $('proContPage').css({overflow:'hidden',height:h+'px'});
					    $('shade').removeClass('dn');
					    $('shade').setStyle('height',h);
					    if($('ShoppingFooter')){
					    	$('ShoppingFooter').addClass('dn');
					    }
					    $BindFunc();
					}
				}
			}).send();
		})
	}
	
}
jsonAddCart($$(".addShoppingCart"));//商品页面
jsonAddCart($("addShoppingCart"));//商品详情页面

//

var addCartContClose = function (ele){
	if(ele){
		ele.addEvent('click',function(){
			$('proContPage').css({overflow:'hidden',height:'auto'});
		    $('shade').addClass('dn');
		    $('container').addClass('dn');
		    if($('ShoppingFooter')){
		    	$('ShoppingFooter').removeClass('dn');
		    }
		})
	}
   
}

var increaseNum = function (ele){
	if(ele){
		ele.addEvent('click',function(){
			var amountInput = $("amountInput"), toBuy = new Number(amountInput.txt()),leftCountInput=$("leftCount"),
			leftCount=Number(leftCountInput.txt()) ,limitCount=Number(amountInput.attr("limitCount"));
			if(toBuy>=leftCount){
				$testRemind(leftCountInput,"库存不足！",1);
				setTimeout('$testRemind.hide()',3000);
				return;
			}
			if(limitCount>0 && toBuy >=limitCount){
				$testRemind(leftCountInput,"超过限购数量！",1);
				setTimeout('$testRemind.hide()',3000);
				return;
			}
			if(toBuy > 0){
				amountInput.txt(toBuy+1);
//				leftCountInput.txt(leftCount-1);
			}
		})
	}
}

var decreaseNum = function (ele){
	if(ele){
		ele.addEvent('click',function(){
			var amountInput = $("amountInput"),toBuy = new Number(amountInput.txt()),leftCountInput=$("leftCount"),leftCount=Number(leftCountInput.txt());
			if(toBuy > 1){
				amountInput.txt(toBuy-1);
//				leftCountInput.txt(leftCount+1);
			}
		})
	}
}


//添加到购物车
var addGoodToCart = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var ele = this,amountInput =$("amountInput"),disable=ele.attr("disable");
			if(disable=="true"){
				$testRemind(ele,"对不起，你已使用过该优惠了！",1);
				setTimeout('$testRemind.hide()',3000);
				return;
			}
			new AjaxPost(this,{
				url:'/LockController/addToCart',
				data:{
					goodId:ele.attr("data"),
					num:amountInput.txt()
				},
				callback:function(json){
					if(json.succ){
						window.location.href=json.html;
					}else{
						Ibox.open({
							url:'<div class="p1 lh20 bbc f14">不好意思，该商品库存不足，请减少购买数量或购买其他商品。</div>'+
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

//添加到购物车
var goToBuy = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var ele = this,amountInput =$("amountInput"),disable=ele.attr("disable");
			if(disable=="true"){
				$testRemind(ele,"对不起，你已使用过该优惠了！",1);
				setTimeout('$testRemind.hide()',3000);
				return;
			}
			new AjaxPost(this,{
				url:'/LockController/goToBuy',
				data:{
					goodId:ele.attr("data"),
					num:amountInput.txt()
				},
				callback:function(json){
					if(json.succ){
						window.location.href=json.html;
					}else{
						Ibox.open({
							url:'<div class="p1 lh20 bbc f14">不好意思，该商品库存不足，请减少购买数量或购买其他商品。</div>'+
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

//弹出购物车后绑定事件
var $BindFunc = function(){
	addCartContClose($('closeCartBtn'));
	increaseNum($("increaseBtn"));
	decreaseNum($("decreaseBtn"));
	addGoodToCart($("addGoodToCart"));
	goToBuy($("goToBuy"));
}


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
var w=$(window).getWidth();
$$('.slide_area').setStyle('width',w);
$$('#slideImg li').setStyle('width',w);
slideSwitch(); 
function slideSwitch(){
  var slideImglist=document.querySelectorAll('#slideImg li'),slideModlist=document.querySelectorAll('#slideMod li');
  var num=slideImglist.length;
  var Index=0,slideInter;
  var autoSlide=function(){
    slideInter=setInterval(function(){
      slideShow(Index);   
      Index++;      
      if(Index==num){
        Index=0;
      } 
    },1500);
  }
  var slideShow = function(Index){
		if( $('slideImg')){
			  $('slideImg').style.left =-w*Index+'px';
			  $('slideImg').style.webkitTransition ='left 0.4s ease-out';
		}
	
	//  $("slideImg").stop(true,false).animate({left:-w*Index},400);
      $$('#slideMod li').removeClass("current");
      $$(slideModlist[Index]).addClass("current");
  }
  for(var i=0; i<slideImglist.length;i++){
      slideImglist[i]._index=i;
      slideImglist[i].addEventListener('touchstart', function (event) {
        clearInterval(slideInter);
        startX = event.touches[0].pageX;
        startY = event.touches[0].pageY;
      }, false);
      slideImglist[i].addEventListener('touchend', function (event) {
    	clearInterval(slideInter);
        var endX = event.changedTouches[0].pageX;
        var endY = event.changedTouches[0].pageY;
        var direction = GetSlideDirection(startX,startY,endX,endY);
        var index=this._index;
        switch (direction) {
            case 3:  
              if(index==(num-1)){
            	 $('slideImg').style.left=0+'px';
            	 $('slideImg').style.webkitTransition ='left 0.05s ease-out';
             //  $("#slideImg").stop(true,false).animate({left:0},50); 
                $$('#slideMod li').removeClass("current"); 
                $$(slideModlist[0]).addClass("current")
              }else{	  
            	  var currentleft=parseInt($('slideImg').offsetLeft);
            	  $('slideImg').style.left=currentleft-w+'px';
            	  $('slideImg').style.webkitTransition ='left 0.4s ease-out';
              //   $("#slideImg").stop(true,false).animate({left:'-='+w},50);
                 $$('#slideMod li').removeClass("current");
                 $$(slideModlist[index+1]).addClass("current");  
              }
              break;
            case 4: 
              if(index==0){
            	 $('slideImg').style.left=-w*(num-1)+'px';
            	 $('slideImg').style.webkitTransition ='left 0.4s ease-out';
               //  $("#slideImg").stop(true,false).animate({left:-w*(num-1)},50);
               //   slideMod.removeClass("current").eq(num-1).addClass("current");
                 $$('#slideMod li').removeClass("current");
                 $$(slideModlist[num-1]).addClass("current"); 
              }else{
            	  var currentleft=parseInt($('slideImg').offsetLeft);
            	  $('slideImg').style.left=currentleft+w+'px';
            	  $('slideImg').style.webkitTransition ='left 0.4s ease-out';
                //$("#slideImg").stop(true,false).animate({left:'+='+w},50); 
                  $$('#slideMod li').removeClass("current");
                  $$(slideModlist[index-1]).addClass("current"); 
              } 
              break;
            default:           
        } 
        autoSlide();  
      }, false);
  }
 autoSlide();   
}


//分页

var getMoreGoods = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var item=this, data=item.attr("data").split("|"),currPage=new Number(item.attr("currPage"));
			if(currPage>=new Number(data[3])){
				item.addClass("abs_out");
				return;
			}
			new AjaxPost(this,{
				url:'/LockController/jsonMoreGoods',
				data:{
					place:data[0],
					name:data[1],
					typeId:data[2],
					page:new Number(currPage)+1,
				},
				callback:function(json){
					if(json.succ){
						$("goodList").appendHTML(json.html);
						item.attr("currPage",currPage+1);
						jsonAddCart($$(".addShoppingCart"));
					}
				}
			}).send();
			
		})
	}
}

getMoreGoods($("getMore"));