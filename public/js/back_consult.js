
//查看详情
var previewConsultBtn=$$(".previewConsultBtn")
if($isArr(previewConsultBtn)){
	previewConsultBtn.addEvent('click',function(){
		var ele=this;
		Ibox.open({
			url:'<div id="previewBox"></div>',
			title: '求购详情',
			width: 420,
			onShow: function(){
				Ibox.reposition();
				new AjaxPost(ele, {
					url : '/AdminController/jsonConsultPreview',
					data: {consultId: ele.attr('data')},
					callback: function(json){
						if(json.succ){
							$("previewBox").html(json.html);
								Ibox.reposition();
							}
						}
				}).send();
			}
		});
	});
}

//删除商品
var removeData = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			new AjaxPost(this, {
				url: '/AdminController/removeConsults',
				data: { consultIds : $$(".jsForCheck:checked").attr('data')},
				callback: function(json){
					var ids = $$(".jsForCheck:checked").attr('data');
					ids.each(function(item){
						$("consultChk_"+item).dispose();
						$("consult_"+item).dispose();
					})
					$("dataCount").txt(new Number($("dataCount").txt())-ids.length);
					if(json.succ){
						Ibox.alert("删除成功");
					}else{
						Ibox.alert("删除成功，但是编号为："+json.msg+"的求购未能被删除");
					}
				}
			}).send();
		})
	}
}

removeData($("removeBtn"));