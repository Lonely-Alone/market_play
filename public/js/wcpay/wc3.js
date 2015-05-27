
/** 下面是app进行签名的操作 **/
function getAppId()
{
    return $("#appIdInput").val();
}
function getPacke(){
	return "prepay_id="+$("#prepareIdInput").val();
}

function getTimeStamp()
{
    return $("#timestatm").val().trim();
}
function getNonceStr()
{
    return $("#nocestr").val().trim();
}
function getSignType()
{
    return "MD5";
}
function getSignType1()
{
    return "SHA1";
}
function getSign()
{
    
    return $("#paySign").val().trim();
}


wx.config({
    debug: false,
    appId: getAppId(),
    timestamp: getTimeStamp(),
    nonceStr: getNonceStr(),
    signature: $("#configSign").val().trim(),
    jsApiList: [
      'checkJsApi',
      'scanQRCode',
      'chooseWXPay',
      'openProductSpecificView',
      'addCard',
      'chooseCard',
      'openCard'
    ]
});
wx.ready(function () {
	$('#getBrandWCPayRequest').click( function () {
			wx.chooseWXPay({
				appId: getAppId(),
			    timestamp: getTimeStamp(), // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
			    nonceStr: getNonceStr(), // 支付签名随机串，不长于 32 位
			    package: getPacke(), // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
			    signType: getSignType(), // 使用新版支付需传入'MD5'
			    paySign: getSign(), // 支付签名
			    success: function (res) {
			        // 支付成功后的回调函数
		    	  if(res.err_msg == "chooseWXPay:ok" ){
		    		  setInterval("checkPayResult();", 3000);
		    	  }
			    },
			    fail: function (res) {
		    	  if(res.err_msg == "chooseWXPay:cancel" ){
		    		  alert("你已取消支付！");
		    	  }
		    	  if(res.err_msg == "chooseWXPay:fail" ){
		    		  alert("支付失败！");
		    	  }
			    	
			    },
			});
	})

});

//全局错误信息提示
//wx.error(function (res) {
//  alert(res.errMsg);
//});

setInterval("checkPayResult();", 3000);
//轮询处理支付结果
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
