var $customScroll=function(e,t,n){window.scrollParams={barTop:0,conTop:0,currentY:0,flag:!1};var r={wheel:4},i=$extend(r,n||{});if(e&&t){var s=e.getSize().y,o=t.getSize().y,u=s/o,a=u*s;if(u<1){var f=new Element("div",{id:"scrollbarBg",styles:{width:6,height:s,position:"absolute",right:1}}),l=(new Element("span",{"class":"scrollbar bdrad10",styles:{width:6,height:a,position:"absolute",left:-2,cursor:"pointer"}})).store("data",{maxTop:s-a,height:a,overTop:o-s,target:t}).inject(f),c=$("scrollbarBg");$isEle(c)&&c.dispose(),e.adopt(f).store("targetBar",l),f.addEvents({mouseover:function(){l.fade("0.6")},mouseout:function(){scrollParams.flag!=1?l.fade("out"):""}}),l.addEvent("mousedown",function(e){return scrollParams.flag=!0,scrollParams.barTop=this.getStyle("top").toInt()||0,scrollParams.conTop=this.retrieve("data").target.getStyle("top").toInt()||0,scrollParams.currentY=e?e.page.y:0,scrollParams.scrollTarget=this,!1}).onselectstart=function(){return!1},e.addEvent("mousewheel",function(e){e=new Event(e);var t=this.retrieve("targetBar");t.fireEvent("mousedown"),scrollParams.flag=!1,e.wheel>0?h(i.wheel):e.wheel<0&&h(-1*i.wheel)});var h=function(e){var t=scrollParams.barTop+e,n=scrollParams.scrollTarget,r=n.getStyle("top").toInt()||0,i=n.retrieve("data");t<0?t=0:t>i.maxTop&&(t=i.maxTop),n.setStyle("top",t),i.target.setStyle("top",i.overTop*t/i.maxTop*-1)},p=$$("body")[0];p.retrieve("documentEvent")||(document.addEvents({mouseup:function(){scrollParams.flag=!1,l.fade("out")},mousemove:function(e){if(scrollParams.flag){var t=e.page.y,n=t-scrollParams.currentY;h(n)}}}),p.store("documentEvent",!0))}else{var c=$("scrollbarBg");$isEle(c)&&(t.setStyle("top",0),c.dispose())}}}