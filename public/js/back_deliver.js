//搜索商品
var searchOrder = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var searchInput = $("searchInput");
			if($isEmpty(searchInput)){
				$testRemind(searchInput, "请输入取货密码", 1);
				setTimeout('$testRemind.hide()',3000);
			}else{
				new AjaxPost(this, {
					url: '/AdminController/jsonDeliver',
					data: {
						pass: searchInput.val().trim(),
					},
					callback: function(json){
						if(json.succ){
							$("table").html(json.html);
						}else{
							alert("密码不正确，无法查询到相应的订单！")
						}
					}
				}).send();
			}
			
		})
	}
}

searchOrder($("searchBtn"));