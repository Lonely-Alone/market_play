

//添加商品类型
var addLocation = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var searchNameInput = $("searchNameInput");
			if($isEmpty(searchNameInput)){
				$testRemind(searchNameInput,"商品类型名称不能为空！");
				setTimeout('$testRemind.hide()',3000,1);
				return;
			}
			new AjaxPost(this, {
				url: '/AdminController/addLocation',
				data: { address : searchNameInput.val().trim()},
				callback: function(json){
					window.location.href=json.html;
				}
			}).send();
		})
	}
}

addLocation($("addLocationBtn"));

//搜索商品类型

var searchLocation = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var searchNameInput = $("searchNameInput");
			new AjaxPost(this, {
				url: '/AdminController/filterLocation',
				data: { address : searchNameInput.val().trim()},
				callback: function(json){
					window.location.href=json.html;
				}
			}).send();
		})
	}
}
searchLocation($("searchLocationBtn"));



//删除商品类型
var removeData = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			new AjaxPost(this, {
				url: '/AdminController/removeLocations',
				data: { locationIds : $$(".jsForCheck:checked").attr('data')},
				callback: function(json){
					var ids = $$(".jsForCheck:checked").attr('data');
					ids.each(function(item){
						$("locationChk_"+item).dispose();
						$("location_"+item).dispose();
					})
					$("dataCount").txt(new Number($("dataCount").txt())-ids.length);
					if(json.succ){
						Ibox.alert("删除成功");
					}else{
						Ibox.alert("删除成功，但是编号为："+json.msg+"的商品类型未能被删除");
					}
				}
			}).send();
		})
	}
}

removeData($("removeBtn"));