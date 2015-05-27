//分类下拉框
$(document).bind("click",function(e){ 
    var target  = $(e.target),ele=$("#sortSelectBtn"),selectBox=$('.sort_select_box'); 
    if(target.closest($("#sortSelectBtn")).length == 0){ 
    	selectBox.addClass('dn');
    } 
    else 
    { 
    	selectBox.toggleClass('dn');
    } 
}); 




$('addShoppingCart').on('click',addCartContShow);
$('closeCartBtn').on('click',addCartContClose);








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
var w=$(window).width();
$('.slide_area').width(w);
$('#slideImg li').width(w);
slideSwitch(); 
function slideSwitch(){
  var slideImglist=document.querySelectorAll('#slideImg li');
  var slideImg=$("#slideImg").children("li"), slideMod=$("#slideMod").children("li");
  var num=slideImg.length;
  var Index=0;
  var slideInter
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
    $("#slideImg").stop(true,false).animate({left:-w*Index},400);
    slideMod.removeClass("current").eq(Index).addClass("current");
  }
  for(var i=0; i<slideImglist.length;i++){
      slideImglist[i]._index=i;
      slideImglist[i].addEventListener('touchstart', function (event) {
        clearInterval(slideInter);
        startX = event.touches[0].pageX;
        startY = event.touches[0].pageY;
      }, false);
      slideImglist[i].addEventListener('touchend', function (event) {
        var endX = event.changedTouches[0].pageX;
        var endY = event.changedTouches[0].pageY;
        var direction = GetSlideDirection(startX,startY,endX,endY);
        var index=this._index;
        switch (direction) {
            case 3:  
              if(index==(num-1)){
                 $("#slideImg").stop(true,false).animate({left:0},50); 
                 slideMod.removeClass("current").eq(0).addClass("current");  
              }else{
                 $("#slideImg").stop(true,false).animate({left:'-='+w},50);
                 slideMod.removeClass("current").eq(index+1).addClass("current");  
              }
              break;
            case 4: 
              if(index==0){
                 $("#slideImg").stop(true,false).animate({left:-w*(num-1)},50);
                  slideMod.removeClass("current").eq(num-1).addClass("current");  
              }else{
                $("#slideImg").stop(true,false).animate({left:'+='+w},50); 
                slideMod.removeClass("current").eq(index-1).addClass("current");
              } 
              break;
            default:           
        } 
        autoSlide();  
      }, false);
  }
 autoSlide();   
}