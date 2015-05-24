//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import models.wechat.AutoReply;
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
// NOTE: This file was generated from: japidviews/AdminController/modAutoReplyPage.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class modAutoReplyPage extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/modAutoReplyPage.html";
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


	public modAutoReplyPage() {
	super((StringBuilder)null);
	initHeaders();
	}
	public modAutoReplyPage(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public modAutoReplyPage(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"autoReply",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"AutoReply",  };
	public static final Object[] argDefaults= new Object[] {null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.modAutoReplyPage.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private AutoReply autoReply; // line 3, japidviews/AdminController/modAutoReplyPage.html
	public cn.bran.japid.template.RenderResult render(AutoReply autoReply) {
		this.autoReply = autoReply;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 3, japidviews/AdminController/modAutoReplyPage.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(AutoReply autoReply) {
		return new modAutoReplyPage().render(autoReply);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\modAutoReplyPage.html
// line 5, japidviews\AdminController\modAutoReplyPage.html
		p("<div class=\"content_page\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		");// line 5, japidviews\AdminController\modAutoReplyPage.html
		//t leftMenusTag(AdminMenu.回复管理);// line 8, japidviews\AdminController\modAutoReplyPage.html
		p("		<section class=\"cell\">\n" + 
"			<nav id=\"addGoodNav\" class=\"nav_content_box fix\">\n" + 
"				<h4 class=\"l\">");// line 8, japidviews\AdminController\modAutoReplyPage.html
		p(autoReply==null?"创建":"修改");// line 11, japidviews\AdminController\modAutoReplyPage.html
		p("自动回复</h4>\n" + 
"			</nav>\n" + 
"            <article class=\"mt20\">\n" + 
"            <form action=\"");// line 11, japidviews\AdminController\modAutoReplyPage.html
		p(lookup("AdminController.modAutoReply", new Object[]{}));// line 14, japidviews\AdminController\modAutoReplyPage.html
		p("\" method=\"post\">\n" + 
"        		<input type=\"hidden\" name=\"autoReplyId\" value=\"");// line 14, japidviews\AdminController\modAutoReplyPage.html
		p(autoReply==null?"":autoReply.id);// line 15, japidviews\AdminController\modAutoReplyPage.html
		p("\"/>\n" + 
"                <div class=\"ml20 mt10\">\n" + 
"                    <div class=\"mb10\">\n" + 
"                    	查询 key：\n" + 
"                        <input type=\"text\" class=\"pct60 input vn\" name=\"key\" value=\"");// line 15, japidviews\AdminController\modAutoReplyPage.html
		p(autoReply==null?"":autoReply.regexKey);// line 19, japidviews\AdminController\modAutoReplyPage.html
		p("\"/>\n" + 
"                    </div>\n" + 
"                    <div class=\"mb10\">\n" + 
"                    	<span class=\"dib w60 tr\">回复内容：</span>\n" + 
"                        <textarea class=\"textarea pct85\" rows=\"8\" name=\"content\">");// line 19, japidviews\AdminController\modAutoReplyPage.html
		p(autoReply==null?"":autoReply.content);// line 23, japidviews\AdminController\modAutoReplyPage.html
		p("</textarea>\n" + 
"                    </div>\n" + 
"                </div>\n" + 
"                <div class=\"mt10 tc\">\n" + 
"                	<input type=\"submit\" class=\"bluebtn btn_m\" value=\"确定\"/>\n" + 
"                </div>\n" + 
"            </form>\n" + 
"            </article>\n" + 
"        </section>\n" + 
"	</div>\n" + 
"</div>\n");// line 23, japidviews\AdminController\modAutoReplyPage.html
		new baseJSLinkTag(modAutoReplyPage.this).render(); // line 34, japidviews\AdminController\modAutoReplyPage.html// line 34, japidviews\AdminController\modAutoReplyPage.html
new iboxJSLinkTag(modAutoReplyPage.this).render(); // line 35, japidviews\AdminController\modAutoReplyPage.html// line 35, japidviews\AdminController\modAutoReplyPage.html
		
		endDoLayout(sourceTemplate);
	}

	@Override protected void title() {
		// line 5, japidviews\AdminController\modAutoReplyPage.html
		p("后台管理-");// line 5, japidviews\AdminController\modAutoReplyPage.html
		p(autoReply==null?"创建":"修改");// line 5, japidviews\AdminController\modAutoReplyPage.html
		p("自动回复");// line 5, japidviews\AdminController\modAutoReplyPage.html
		;
	}
}