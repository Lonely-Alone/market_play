var paySuccess=false;
function auto_remove(img){
    div=img.parentNode.parentNode;div.parentNode.removeChild(div);
    img.onerror="";
    return true;
}
function changefont(fontsize){
    if(fontsize < 1 || fontsize > 4)return;
    $('#content').removeClass().addClass('fontSize' + fontsize);
}


	// 公众号支付
$("#getBrandWCPayRequest").click(function(e){
	alert("支付测试");
		WeixinJSBridge.invoke('getBrandWCPayRequest', {
			"appId": getAppId(), //公众号名称，由商户传入
		    "timeStamp": getTimeStamp(), //时间戳
		    "nonceStr": getNonceStr(), //随机串
		    "package": getPackage(),//扩展包
		    "signType": getSignType(), //微信签名方式:1.sha1
		    "paySign": getSign() //微信签名
	   },
	   function(res){     
		 alert(res.err_msg);
		 if(res.err_msg == "get_brand_wcpay_request:ok" ) {
			 paySuccess=true;
			 checkPayResult();
		 }     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
	   }
	); 
});



// 轮询处理支付结果
setInterval("checkPayResult();", 3000);
function checkPayResult(){
	$.ajax({
		url: "/APIController/checkPayResult",
		dataType: "json",
		data: {orderSumId: $("#sumIdInput").val()},
		async: true,
		success: function(data){
			var result = eval(data);
			if(data.succ){
				window.location.href=data.msg;
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			alert("服务器异常");
		}
	});
};

if(jQuery){
    jQuery(function(){
       var width = jQuery('body').width() * 0.87;
       jQuery('img').error(function(){
           var self = jQuery(this);
           var org = self.attr('data-original1');
           self.attr("src", org);
           self.error(function(){
              auto_remove(this);
           });
       });
       jQuery('img').each(function(){
    	   var self = jQuery(this);
           var w = self.css('width');
           var h = self.css('height');
           w = w.replace('px', '');
           h = h.replace('px', '');
           if(w <= width){
         	  return;
           }
           var new_w = width;
           var new_h = Math.round(h * width / w);
           self.css({'width' : new_w + 'px', 'height' : new_h + 'px'});
           self.parents('div.pic').css({'width' : new_w + 'px', 'height' : new_h + 'px'});
       });
   });
}