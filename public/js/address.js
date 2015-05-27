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
						location:locationInput.val().trim(),
						addressId:ele.attr("addressId")
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


var deleteAddress = function(ele){
	if(ele){
		ele.addEvent('click',function(){
				new AjaxPost(this, {
					url: '/ExclusiveController/deleteAddress',
					data: {
						orderSumId:ele.attr("data"),
						memberId:ele.attr("memberId"),
						addressId:ele.attr("addressId")
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
deleteAddress($("deleteAddress"));

var defaultAddress = function(ele){
	if(ele){
		ele.addEvent('click',function(){
				new AjaxPost(this, {
					url: '/ExclusiveController/defaultAddress',
					data: {
						orderSumId:ele.attr("data"),
						memberId:ele.attr("memberId"),
						addressId:ele.attr("addressId")
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
defaultAddress($("defaultAddress"));
