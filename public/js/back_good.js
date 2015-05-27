/* 商品管理 */
var goodFilter = $("goodFilter");
// 筛选
goodFilter.addEvent('change', function(){
	new AjaxPost(this,{
		url: '/AdminController/filterGoods',
		data: {inSold: this.val()}
	}).send();
});
// 搜索
$('searchGoodBtn').addEvent('click', function(){
	new AjaxPost(this, {
		url: '/AdminController/filterGoods',
		data: {
			name: searchNameInput.val().trim(), 
			goodFilter: $("goodFilter").val()
		}
	}).send();
});
//预览商品
var previewGoodBtn=$$(".previewGoodBtn")
if($isArr(previewGoodBtn)){
	previewGoodBtn.addEvent('click',function(){
		var ele=this;
		Ibox.open({
			url:'<div id="previewBox"></div>',
			title: '商品预览',
			width: 420,
			onShow: function(){
				Ibox.reposition();
				new AjaxPost(ele, {
					url : '/AdminController/jsonGoodPreview',
					data: {goodId: ele.attr('data')},
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
// 删除商品
removeData(function(){
	new AjaxPost($("iboxConfirmOk"), {
		url: '/AdminController/removeGoods',
		data: { goodIds : $$(".jsForCheck:checked").attr('data')},
		callback: function(json){
			var ids = $$(".jsForCheck:checked").attr('data');
			ids.each(function(item){
				$("goodChk_"+item).dispose();
				$("good_"+item).dispose();
			})
			$("dataCount").txt(new Number($("dataCount").txt())-ids.length);
			if(json.succ){
				Ibox.alert("删除成功");
			}else{
				Ibox.alert("删除成功，但是编号为："+json.msg+"的商品已经被删除");
			}
		}
	}).send();
});