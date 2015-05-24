//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import models.order.OrderSum;
import org.apache.commons.lang.StringUtils;
import utils.PictureUtil.Effect;
import models.enums.OrderStatus;
import models.order.OrderItem;
import static cn.bran.play.JapidPlayAdapter.*;
import static play.data.validation.Validation.*;
import static play.templates.JavaExtensions.*;
import play.data.validation.Error;
import play.i18n.Messages;
import play.mvc.Scope.*;
import play.data.validation.Validation;
import play.i18n.Lang;
import controllers.*;
import models.*;
import play.mvc.Http.*;
//
// NOTE: This file was generated from: japidviews/AdminController/jsonDeliver.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class jsonDeliver extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/AdminController/jsonDeliver.html";
	 private void initHeaders() {
		putHeader("Content-Type", "application/json; charset=utf-8");
		setContentType("application/json; charset=utf-8");
	}
	{
	}

// - add implicit fields with Play

	final play.mvc.Http.Request request = play.mvc.Http.Request.current(); 
	final play.mvc.Http.Response response = play.mvc.Http.Response.current(); 
	final play.mvc.Scope.Session session = play.mvc.Scope.Session.current();
	final play.mvc.Scope.RenderArgs renderArgs = play.mvc.Scope.RenderArgs.current();
	final play.mvc.Scope.Params params = play.mvc.Scope.Params.current();
	final play.data.validation.Validation validation = play.data.validation.Validation.current();
	final cn.bran.play.FieldErrors errors = new cn.bran.play.FieldErrors(validation);
	final play.Play _play = new play.Play(); 

// - end of implicit fields with Play 


	public jsonDeliver() {
	super((StringBuilder)null);
	initHeaders();
	}
	public jsonDeliver(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public jsonDeliver(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"sum", "itemList",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"OrderSum", "List<OrderItem>",  };
	public static final Object[] argDefaults= new Object[] {null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.jsonDeliver.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private OrderSum sum; // line 9, japidviews/AdminController/jsonDeliver.html
	private List<OrderItem> itemList; // line 9, japidviews/AdminController/jsonDeliver.html
	public cn.bran.japid.template.RenderResult render(OrderSum sum,List<OrderItem> itemList) {
		this.sum = sum;
		this.itemList = itemList;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 9, japidviews/AdminController/jsonDeliver.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(OrderSum sum,List<OrderItem> itemList) {
		return new jsonDeliver().render(sum, itemList);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\jsonDeliver.html

p("\n" + 
"{succ:\"true\",html:\"");// line 9, japidviews\AdminController\jsonDeliver.html
		p(escapeJavaScript(html()));// line 11, japidviews\AdminController\jsonDeliver.html
		p("\"}\n" + 
"\n");// line 11, japidviews\AdminController\jsonDeliver.html
		// line 13, japidviews\AdminController\jsonDeliver.html
		
		endDoLayout(sourceTemplate);
	}

public String html() {
StringBuilder sb = new StringBuilder();
StringBuilder ori = getOut();
this.setOut(sb);
TreeMap<Integer, cn.bran.japid.template.ActionRunner> parentActionRunners = actionRunners;
actionRunners = new TreeMap<Integer, cn.bran.japid.template.ActionRunner>();
// line 13, japidviews\AdminController\jsonDeliver.html
OrderStatus status = sum.getStatus();// line 14, japidviews\AdminController\jsonDeliver.html
		p("<div class=\" bdc\">\n" + 
"	<div class=\"p5 bgf9\">\n" + 
"    	<span class=\"inline_six\"><a href=\"");// line 14, japidviews\AdminController\jsonDeliver.html
		p(lookup("AdminController.orderSumDetail", sum.id));// line 17, japidviews\AdminController\jsonDeliver.html
		p("\">");// line 17, japidviews\AdminController\jsonDeliver.html
		p(StringUtils.defaultIfBlank(sum.orderSerial, sum.id+""));// line 17, japidviews\AdminController\jsonDeliver.html
		p("</a></span>\n" + 
"        <span class=\"inline_six\">");// line 17, japidviews\AdminController\jsonDeliver.html
		p(formatDate(sum.createTime, "yyyy-MM-dd HH:mm"));// line 18, japidviews\AdminController\jsonDeliver.html
		p("</span>\n" + 
"        <span class=\"inline_six\">");// line 18, japidviews\AdminController\jsonDeliver.html
		p(sum.owner!=null?sum.owner.nickName():"");// line 19, japidviews\AdminController\jsonDeliver.html
		p("</span>\n" + 
"        <span class=\"inline_six ");// line 19, japidviews\AdminController\jsonDeliver.html
		p(status.fontColor());// line 20, japidviews\AdminController\jsonDeliver.html
		p("\">");// line 20, japidviews\AdminController\jsonDeliver.html
		p(status.cnName());// line 20, japidviews\AdminController\jsonDeliver.html
		p("</span>\n" + 
"        <span class=\"inline_six\">");// line 20, japidviews\AdminController\jsonDeliver.html
		p(sum.payMode);// line 21, japidviews\AdminController\jsonDeliver.html
		p("</span>	\n" + 
"        <span class=\"inline_six\">");// line 21, japidviews\AdminController\jsonDeliver.html
		p(formatNumber(sum.points/100.0, "0.00"));// line 22, japidviews\AdminController\jsonDeliver.html
		p("</span> \n" + 
"        <span class=\"inline_six\">");// line 22, japidviews\AdminController\jsonDeliver.html
		p(formatNumber(sum.getCost()/100.0, "0.00"));// line 23, japidviews\AdminController\jsonDeliver.html
		p("</span> \n" + 
"    </div>\n" + 
"    ");// line 23, japidviews\AdminController\jsonDeliver.html
		for(OrderItem item : itemList){// line 25, japidviews\AdminController\jsonDeliver.html
		p("    	<div class=\"p5 fix\">\n" + 
"	    	<img class=\"mr10 vm\" width=\"30\" height=\"30\" src=\"");// line 25, japidviews\AdminController\jsonDeliver.html
		p(getPictureFromPicServer(60, 60, Effect.FILL, item.good.previewURL));// line 27, japidviews\AdminController\jsonDeliver.html
		p("\"/>\n" + 
"	        <span>");// line 27, japidviews\AdminController\jsonDeliver.html
		p(item.good.name);// line 28, japidviews\AdminController\jsonDeliver.html
		p("</span>\n" + 
"	    </div> \n" + 
"  	");// line 28, japidviews\AdminController\jsonDeliver.html
		}            // line 30, japidviews\AdminController\jsonDeliver.html
		p("</div>\n" + 
"\n" + 
"                    \n");// line 30, japidviews\AdminController\jsonDeliver.html
		
this.setOut(ori);
if (actionRunners.size() > 0) {
	StringBuilder _sb2 = new StringBuilder();
	int segStart = 0;
	for (Map.Entry<Integer, cn.bran.japid.template.ActionRunner> _arEntry : actionRunners.entrySet()) {
		int pos = _arEntry.getKey();
		_sb2.append(sb.substring(segStart, pos));
		segStart = pos;
		cn.bran.japid.template.ActionRunner _a_ = _arEntry.getValue();
		_sb2.append(_a_.run().getContent().toString());
	}
	_sb2.append(sb.substring(segStart));
	actionRunners = parentActionRunners;
	return _sb2.toString();
} else {
	actionRunners = parentActionRunners;
	return sb.toString();
}
}
}