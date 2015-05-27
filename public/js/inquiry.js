	$("increaseBtn").addEvent('click', function(){
		var amountInput = $("amountInput"), toBuy = new Number(amountInput.txt());
		if(toBuy > 0){
			amountInput.txt(toBuy+1);
		}
	});
	// -
	$("decreaseBtn").addEvent('click', function(){
		var amountInput = $("amountInput");
		if(new Number(amountInput.txt()) > 1){
			amountInput.txt(new Number(amountInput.txt())-1);
		}
	});
	
	// 上传图片、预览
	var iFrameCallBack = function(uploadResult) {
		var target = uploadResult.split('|')[0], p = $("uploadedPic"+target), isLegal = uploadResult.split('|')[3];
		if(isLegal === "false"){
			$testRemind($("uploadTrigger"+target), "图片大小请控制在500k以内", 1);
			setTimeout('$testRemind.hide()',3000);
		}else{
			p.attr("origin", uploadResult.split('|')[1]);
			p.attr("src", uploadResult.split('|')[2]);
			p.into();
			p.removeEvents('click');
			p.addEvent('click', function(){
				$(this.attr('rel')).click();
			})
			$("uploadTrigger"+target).out();
			$('removePicBtn'+target).attr('data', target);
			$('removePicBtn'+target).removeClass('abs_out');
		}
	};
	$$(".jsForUpload").addEvent('change', function(){
		this.getParent('form.uploadForm').submit();
	});
	$$(".uploadBtn").addEvent('click', function(){
		$(this.attr('rel')).click();
	});
	$$('.jsForUploaded').addEvent('click', function(){
		$(this.attr('rel')).click();
	});
	$$('.jsForRmPic').addEvent('click', function(){
		var target = this.attr('data');
		$('uploadedPic'+target).out();
		$('uploadedPic'+target).attr('origin','').attr('src','');
		$$('.uploadBtn'+target).into();
		this.addClass('abs_out');
	});
	
	//发票选择
	$('SelectBillBtn').addEvent('click',function(){
		$('billContBox').toggle();
		invoiceSelected($$(".invoice"));
		
	})
	
	var invoiceSelected = function(eles){
		if(eles){
			eles.addEvent('click',function(){
				var ele=this;
				$$(".invoice").getElements("i").each(function(item,index){
					item.removeClass("i_sel_on").addClass("i_sel");
				});
				ele.getElements("i").removeClass("i_sel").addClass("i_sel_on");
				$("invoiceType").set('text', ele.attr("data"));
			})
		}
	}
	
	//联系方式
	$('SelectContactBtn').addEvent('click',function(){
		$('contactContBox').toggle();
		contactSelected($$(".contact"));
	})
	
	var contactSelected = function(eles){
		if(eles){
			eles.addEvent('click',function(){
				var ele=this;
				$$(".contact").getElements("i").each(function(item,index){
					item.removeClass("i_sel_on").addClass("i_sel");
				});
				ele.getElements("i").removeClass("i_sel").addClass("i_sel_on");
				$("contactType").set('text', ele.attr("data"));
			})
		}
	}
		var inquiryRelease = function(){
		$$(".releaseBtn").addEvent('click',function(){
			var nameInput=$("nameInput"),decripInput=$("decripInput"), amountInput = $("amountInput"),uploadedPic=$("uploadedPic"),
				invoiceType=$("invoiceType"),contactType=$("contactType"),contactPerson=$("contactPerson"),contactNum=$("contactNum"),remark=$("remark"),inquiry_pro_info=$$(".inquiry_pro_info"),picUrl="";
			inquiry_pro_info.getElements('img').each(function(item,index){
				if(item!=undefined ){
					item.attr("src").each(function(url,index){
						picUrl+=url+",";
					})
				}
			})
			if($isEmpty(nameInput)){
				$testRemind(nameInput, "请输入商品名称", 1);
				setTimeout('$testRemind.hide()',3000);
			}else if($isEmpty(decripInput)){
				$testRemind(decripInput, "请输入商品描述", 1);
				setTimeout('$testRemind.hide()',3000);
			}else if(picUrl==""){
				$testRemind(uploadedPic, "请为商品添加图片", 1);
				setTimeout('$testRemind.hide()',3000);
			}else{
				new AjaxPost(this, {
					url: '/ServiceController/createConsult',
					data: {
						name: nameInput.val().trim(),
						descrip: decripInput.val().trim(),
						num: new Number(amountInput.txt().trim()),
						invoiceType: invoiceType.txt().trim(),
						contactType: contactType.txt().trim(),
						contactPerson: contactPerson.val().trim(),
						contactNum: contactNum.val().trim(),
						remarks: remark.val().trim(),
						picUrl:picUrl,
						consultType:"询价",
						memberId:this.attr("data")
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
	inquiryRelease();
	
