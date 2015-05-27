



//保存问题
var saveQuestion = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			var questionType=$("questionType"),questionInput = $("question"),answer = ue.getContent(),questionIdInput=$("questionIdInput");
			if($isEmpty(questionInput)){
				$testRemind(questionInput, "请输入问题", 1);
				setTimeout('$testRemind.hide()',3000);
			}else if(answer.lenght==0){
				$testRemind(questionInput, "请输入答案", 1);
				setTimeout('$testRemind.hide()',3000);
			}else {
				new AjaxPost(this, {
					url: '/AdminController/saveQuestion',
					data: {
						questionId:questionIdInput.attr("data"),
						questionType: questionType.val().trim(),
						question: questionInput.val().trim(),
						answer: answer.trim()
					},
					callback: function(json){
						if(json.succ){
							alert(json.msg);
							$pageFresh();
						}
					}
				}).send();
			}
		})
	}
	
}

saveQuestion($("publishQuestionBtn"));



/* 问答管理 */

// 筛选
var questionFliter = function(ele){
	if(ele){
		ele.addEvent('change', function(){
			var type=this.val();
			new AjaxPost(this,{
				url: '/AdminController/filterQuestions',
				data: {
					questionType: type
					
				}
			}).send();
		});
	}
}

questionFliter($("questionFilter"));

//搜索
var serchQuestion = function(ele){
	if(ele){
		ele.addEvent('click', function(){
			var searchQuestionInput=$("searchQuestionInput");
			new AjaxPost(this, {
				url: '/AdminController/filterQuestions',
				data: {
					question: searchQuestionInput.val().trim(), 
					goodFilter: $("questionFilter").val()
				}
			}).send();
		});
	}
}
serchQuestion($('searchQuestionBtn'));


//删除商品
var removeData = function(ele){
	if(ele){
		ele.addEvent('click',function(){
			new AjaxPost(this, {
				url: '/AdminController/removeQuestions',
				data: { questionIds : $$(".jsForCheck:checked").attr('data')},
				callback: function(json){
					var ids = $$(".jsForCheck:checked").attr('data');
					ids.each(function(item){
						$("questionChk_"+item).dispose();
						$("question_"+item).dispose();
					})
					$("dataCount").txt(new Number($("dataCount").txt())-ids.length);
					if(json.succ){
						Ibox.alert("删除成功");
					}else{
						Ibox.alert("删除成功，但是编号为："+json.msg+"的商品已经被删除");
					}
				}
			}).send();
		})
	}
}

removeData($("removeBtn"));
