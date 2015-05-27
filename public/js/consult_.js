

var myConsults = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var item=this;
			new AjaxPost(this, {
				url: '/ServiceController/jsonConsults',
				data: {
					memberId: item.attr("data"),
					type:"owner"
				},
				callback: function(json){
					if(json.succ){
						$("consultList").html(json.html);
						item.getSiblings().removeClass("iqbtn_on");
						item.addClass("iqbtn_on");
					}
				}
			}).send();
		})
		
		
	}
}
myConsults($("myConsults"));


var otherConsults = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var item=this;
			new AjaxPost(this, {
				url: '/ServiceController/jsonConsults',
				data: {
					type:"other"
				},
				callback: function(json){
					if(json.succ){
						$("consultList").html(json.html);
						item.getSiblings().removeClass("iqbtn_on");
						item.addClass("iqbtn_on");
					}
				}
			}).send();
		})
		
		
	}
}
otherConsults($("otherConsults"));

//分页

var getMoreGoods = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var item=this, pageCount=Number(item.attr("pageCount")),currPage=Number(item.attr("currPage")),type=item.attr("type");
			if(currPage>=pageCount){
				item.addClass("abs_out");
				return;
			}
			new AjaxPost(this,{
				url:'/ServiceController/jsonConsults',
				data:{
					page:currPage+1,
					memberId:item.attr("data"),
					type:type
				},
				callback:function(json){
					if(json.succ){
						$("consultList").appendHTML(json.html);
					}
				}
			}).send();
			
			
		})
	}
}

getMoreGoods($("getMore"));