

//搜索问题

var searchQuestion = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var searchInput = $("searchInput");
			if($isEmpty(searchInput)){
				$testRemind(searchInput, "请输入要搜索的问题", 1);
				setTimeout('$testRemind.hide()',3000);
			}else{
				new AjaxPost(this, {
					url: '/ServiceController/searchQuestion',
					data: {
						question: searchInput.val().trim()
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

searchQuestion($("searchBtn"));