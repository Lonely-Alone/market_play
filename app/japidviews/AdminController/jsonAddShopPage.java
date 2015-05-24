//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
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
// NOTE: This file was generated from: japidviews/AdminController/jsonAddShopPage.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class jsonAddShopPage extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/AdminController/jsonAddShopPage.html";
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


	public jsonAddShopPage() {
	super((StringBuilder)null);
	initHeaders();
	}
	public jsonAddShopPage(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public jsonAddShopPage(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/ };
	public static final String[] argTypes = new String[] {/* arg types of the template*/ };
	public static final Object[] argDefaults= new Object[] { };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.jsonAddShopPage.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	public cn.bran.japid.template.RenderResult render() {
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 0, japidviews/AdminController/jsonAddShopPage.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply() {
		return new jsonAddShopPage().render();
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\jsonAddShopPage.html
		p("\n" + 
"{succ: true, html: \"");// line 1, japidviews\AdminController\jsonAddShopPage.html
		p(escapeJavaScript(getHtml()));// line 3, japidviews\AdminController\jsonAddShopPage.html
		p("\"}\n" + 
"\n");// line 3, japidviews\AdminController\jsonAddShopPage.html
		// line 5, japidviews\AdminController\jsonAddShopPage.html
		
		endDoLayout(sourceTemplate);
	}

public String getHtml() {
StringBuilder sb = new StringBuilder();
StringBuilder ori = getOut();
this.setOut(sb);
TreeMap<Integer, cn.bran.japid.template.ActionRunner> parentActionRunners = actionRunners;
actionRunners = new TreeMap<Integer, cn.bran.japid.template.ActionRunner>();
// line 5, japidviews\AdminController\jsonAddShopPage.html
		p("<div class=\"tc\">\n" + 
"	<article class=\"pl10 mt20 mb20\">\n" + 
"		<ul>\n" + 
"			<li class=\"mb15\">\n" + 
"            	<span class=\"dib w70 tr\">\n" + 
"                	<span class=\"cr\">*</span>\n" + 
"					店名：\n" + 
"                </span>\n" + 
"				<input id=\"shopNameInput\" class=\"text_input\" type=\"text\" />\n" + 
"			</li>\n" + 
"            <li class=\"mb15\">\n" + 
"            	<span class=\"dib w70 tr\">\n" + 
"                	<span class=\"cr\">*</span>\n" + 
"					登录名：\n" + 
"                </span>\n" + 
"				<input id=\"loginNameInput\" class=\"text_input\" type=\"text\" />\n" + 
"			</li>\n" + 
"			<li class=\"mb15\">\n" + 
"            	<span class=\"dib w70 tr\">\n" + 
"                	<span class=\"cr\">*</span>\n" + 
"					备注：\n" + 
"                </span>\n" + 
"				<input id=\"memoInput\" class=\"text_input\" type=\"text\" />\n" + 
"			</li>\n" + 
"			<li class=\"mb15\">\n" + 
"            	<span class=\"dib w70 tr\">\n" + 
"					地址：\n" + 
"                </span>\n" + 
"				<input id=\"addressInput\" class=\"text_input\" type=\"text\" />\n" + 
"			</li>\n" + 
"			<li class=\"mb15\">\n" + 
"            	<span class=\"dib w70 tr\">\n" + 
"					电话：\n" + 
"                </span>\n" + 
"				<input id=\"phoneInput\" class=\"text_input\" type=\"text\" />\n" + 
"			</li>\n" + 
"		</ul>\n" + 
"		<div class=\"pt10 ml20\">\n" + 
"			<a id=\"saveShopBtn\" class=\"bluebtn btn_m bdrad3\" href=\"javascript:;\">保存</a>\n" + 
"		</div>\n" + 
"		<div id=\"result\"></div>\n" + 
"	</article>\n" + 
"</div>\n");// line 5, japidviews\AdminController\jsonAddShopPage.html
		
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