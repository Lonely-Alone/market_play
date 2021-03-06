//样式切换
var $classToggle = function(elements, options) {
	var def = {
		addClass: "",
		removeClass: "",
		eventType: "hover",
		inCall: $empty,
		outCall: $empty
	};
	var s = $extend(def, options || {});
	var funShow = function(ele){
		ele.swapClass(s.removeClass, s.addClass);
		if ($isFun(s.inCall)) {
			s.inCall.call(ele);	
		}
	}, funHide = function(ele){
		ele.swapClass(s.addClass, s.removeClass);
		if ($isFun(s.outCall)) {
			s.outCall.call(ele);	
		}
	};
	if ($isStr(s.removeClass) && $isStr(s.addClass)) {
		if ($isEle(elements)) {
			elements = [elements];	
		}
		if ($isArr(elements)) {
			elements.each(function(items) {
				if ($isEle(items)) {
					if (s.eventType === "hover") {
						items.addEvents({
							mouseenter: function() {
								funShow(this)
							},
							mouseleave: function() {
								funHide(this)
							}
						});
					} else if (s.eventType === "click") {
						items.addEvents({
							mousedown: function() {
								funShow(this)
							},
							mouseup: function() {
								funHide(this)
							}
						});
					} else if (s.eventType === "focus") {
						items.addEvents({
							focus: function() {
								funShow(this)
							},
							blur: function() {
								funHide(this)
							}
						});	
					}
				}
			});	
		}
	}
};