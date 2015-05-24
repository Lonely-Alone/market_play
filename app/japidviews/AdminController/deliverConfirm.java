//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import models.enums.AdminMenu;
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
// NOTE: This file was generated from: japidviews/AdminController/deliverConfirm.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class deliverConfirm extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/deliverConfirm.html";
	 private void initHeaders() {
		putHeader("Content-Type", "text/html; charset=utf-8");
		setContentType("text/html; charset=utf-8");
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


	public deliverConfirm() {
	super((StringBuilder)null);
	initHeaders();
	}
	public deliverConfirm(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public deliverConfirm(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/ };
	public static final String[] argTypes = new String[] {/* arg types of the template*/ };
	public static final Object[] argDefaults= new Object[] { };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.deliverConfirm.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	public cn.bran.japid.template.RenderResult render() {
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 0, japidviews/AdminController/deliverConfirm.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply() {
		return new deliverConfirm().render();
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\deliverConfirm.html
		p("\n" + 
"\n" + 
"\n");// line 1, japidviews\AdminController\deliverConfirm.html
		p("<div class=\"content_page\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		");// line 5, japidviews\AdminController\deliverConfirm.html
		new leftMenusTag(deliverConfirm.this).render(AdminMenu.提货验证); // line 8, japidviews\AdminController\deliverConfirm.html// line 8, japidviews\AdminController\deliverConfirm.html
		p("        <section class=\"cell\">\n" + 
"			<nav class=\"nav_content_box fix\">\n" + 
"			</nav>\n" + 
"            <article class=\"mt10\">\n" + 
"            	<div class=\"p10 bgf9 bdc\">\n" + 
"					<div>\n" + 
"				    	密码：\n" + 
"				        <input id=\"searchInput\" class=\"mr20 input pct20\" type=\"text\" value=\"\"/>\n" + 
"				        <a id=\"searchBtn\" class=\"bluebtn btn_s bdrad3 ml10\" href=\"javascript:;\">验证</a>\n" + 
"				    </div>\n" + 
"				</div> \n" + 
"                <div class=\"p5 fix\">\n" + 
"                	<span class=\"l\">\n" + 
"                    	<input id=\"checkAllChk\" class=\"vn\" type=\"checkbox\" />\n" + 
"                        <a id=\"checkAllBtn\" href=\"javascript:;\">全选</a>\n" + 
"                        <a id=\"removeBtn\" class=\"ml10\" href=\"javascript:;\">删除</a>\n" + 
"                    </span>\n" + 
"                </div>\n" + 
"                <div class=\"mt10 mb5 p5 bgef bdc\">\n" + 
"                	<span class=\"inline_six\">订单号</span>\n" + 
"                    <span class=\"inline_six\">成交时间</span>\n" + 
"                    <span class=\"inline_six\">买家</span>\n" + 
"                    <span class=\"inline_six\">交易状态</span>\n" + 
"                    <span class=\"inline_six\">付款方式</span>\n" + 
"                    <span class=\"inline_six\">积分抵款（元）</span> \n" + 
"                    <span class=\"inline_six\">实收款（元）</span>  \n" + 
"                	<span class=\"dib\">&nbsp;</span>\n" + 
"                </div>\n" + 
"                <table width=\"100%\" class=\"bdc\" cellpadding=\"5\" cellspacing=\"0\" id=\"table\">\n" + 
"                    \n" + 
"            	</table>\n" + 
"            </article>\n" + 
"        </section>\n" + 
"	</div>\n" + 
"</div>\n");// line 8, japidviews\AdminController\deliverConfirm.html
		new baseJSLinkTag(deliverConfirm.this).render(); // line 44, japidviews\AdminController\deliverConfirm.html// line 44, japidviews\AdminController\deliverConfirm.html
new iboxJSLinkTag(deliverConfirm.this).render(); // line 45, japidviews\AdminController\deliverConfirm.html// line 45, japidviews\AdminController\deliverConfirm.html
		p("<script src=\"");// line 45, japidviews\AdminController\deliverConfirm.html
		p(lookupStatic("/public/js/min/powerFloat.js"));// line 46, japidviews\AdminController\deliverConfirm.html
		p("\"></script>\n" + 
"<script src=\"");// line 46, japidviews\AdminController\deliverConfirm.html
		p(lookupStatic("/public/js/min/testRemind.js"));// line 47, japidviews\AdminController\deliverConfirm.html
		p("\"></script>\n" + 
"<script src=\"");// line 47, japidviews\AdminController\deliverConfirm.html
		p(lookupStatic("/public/js/min/ajax.js"));// line 48, japidviews\AdminController\deliverConfirm.html
		p("\"></script>\n" + 
"<script src=\"");// line 48, japidviews\AdminController\deliverConfirm.html
		p(lookupStatic("/public/js/min/calendar.js"));// line 49, japidviews\AdminController\deliverConfirm.html
		p("\"></script>\n" + 
"<script src=\"");// line 49, japidviews\AdminController\deliverConfirm.html
		p(lookupStatic("/public/js/crud.js"));// line 50, japidviews\AdminController\deliverConfirm.html
		p("\"></script>\n" + 
"<script src=\"");// line 50, japidviews\AdminController\deliverConfirm.html
		p(lookupStatic("/public/js/paging.js"));// line 51, japidviews\AdminController\deliverConfirm.html
		p("\"></script>\n" + 
"<script src=\"");// line 51, japidviews\AdminController\deliverConfirm.html
		p(lookupStatic("/public/js/checkinput.js"));// line 52, japidviews\AdminController\deliverConfirm.html
		p("\"></script>\n" + 
"<script src=\"");// line 52, japidviews\AdminController\deliverConfirm.html
		p(lookupStatic("/public/js/back_deliver.js"));// line 53, japidviews\AdminController\deliverConfirm.html
		p("\"></script>\n");// line 53, japidviews\AdminController\deliverConfirm.html
		
		endDoLayout(sourceTemplate);
	}

}