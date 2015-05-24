//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import models.enums.AdminMenu;
import models.person.Person;
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
// NOTE: This file was generated from: japidviews/AdminController/personCenter.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class personCenter extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/personCenter.html";
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


	public personCenter() {
	super((StringBuilder)null);
	initHeaders();
	}
	public personCenter(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public personCenter(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/ };
	public static final String[] argTypes = new String[] {/* arg types of the template*/ };
	public static final Object[] argDefaults= new Object[] { };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.personCenter.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	public cn.bran.japid.template.RenderResult render() {
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 0, japidviews/AdminController/personCenter.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply() {
		return new personCenter().render();
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\personCenter.html

Person currPerson = getCurrentPerson();// line 4, japidviews\AdminController\personCenter.html
// line 7, japidviews\AdminController\personCenter.html
		p("<div class=\"content_page\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		");// line 7, japidviews\AdminController\personCenter.html
		new leftMenusTag(personCenter.this).render(AdminMenu.账号管理); // line 10, japidviews\AdminController\personCenter.html// line 10, japidviews\AdminController\personCenter.html
		p("		<section class=\"cell\">\n" + 
"			<nav class=\"nav_content_box fix\">\n" + 
"				<h4 class=\"l\">您的基本信息</h4>\n" + 
"	        </nav>\n" + 
"			");// line 10, japidviews\AdminController\personCenter.html
		p("\n" + 
"            <article class=\"mt20 ml20 pl10\">\n" + 
"            	<div class=\"pb20 ");// line 99, japidviews\AdminController\personCenter.html
		p("\">\n" + 
"                    ");// line 101, japidviews\AdminController\personCenter.html
		p("\n" + 
"                    <div class=\"ml20 pl10 pt10\">\n" + 
"                    	<p class=\"ml10 pl5 pb10\">\n" + 
"                        	登录名：\n" + 
"                            <span class=\"inline_five\">");// line 102, japidviews\AdminController\personCenter.html
		p(currPerson.loginName);// line 106, japidviews\AdminController\personCenter.html
		p("</span>\n" + 
"                            <a id=\"modifyPwdBtn\" class=\"ml20\" href=\"javascript:;\">修改密码</a>\n" + 
"                        </p>\n" + 
"                        ");// line 106, japidviews\AdminController\personCenter.html
		p("\n" + 
"                        <p>\n" + 
"                        	上次登录：\n" + 
"                             <span class=\"inline_five\">");// line 124, japidviews\AdminController\personCenter.html
		p(formatDate(null == currPerson.lastLoginTime ? currPerson.createTime : currPerson.lastLoginTime, "yyyy年MM月dd日 HH:mm:ss"));// line 127, japidviews\AdminController\personCenter.html
		p("</span>\n" + 
"                        </p>\n" + 
"                    </div>\n" + 
"                </div>\n" + 
"                ");// line 127, japidviews\AdminController\personCenter.html
		p("\n" + 
"            </article> \n" + 
"		</section>\n" + 
"	</div>\n" + 
"</div>\n");// line 152, japidviews\AdminController\personCenter.html
		new baseJSLinkTag(personCenter.this).render(); // line 157, japidviews\AdminController\personCenter.html// line 157, japidviews\AdminController\personCenter.html
new iboxJSLinkTag(personCenter.this).render(); // line 158, japidviews\AdminController\personCenter.html// line 158, japidviews\AdminController\personCenter.html
		p("<script src=\"");// line 158, japidviews\AdminController\personCenter.html
		p(lookupStatic("/public/js/min/powerFloat.js"));// line 159, japidviews\AdminController\personCenter.html
		p("\"></script>\n" + 
"<script src=\"");// line 159, japidviews\AdminController\personCenter.html
		p(lookupStatic("/public/js/min/testRemind.js"));// line 160, japidviews\AdminController\personCenter.html
		p("\"></script>\n" + 
"<script src=\"");// line 160, japidviews\AdminController\personCenter.html
		p(lookupStatic("/public/js/min/ajax.js"));// line 161, japidviews\AdminController\personCenter.html
		p("\"></script>\n" + 
"<script src=\"");// line 161, japidviews\AdminController\personCenter.html
		p(lookupStatic("/public/js/back.js"));// line 162, japidviews\AdminController\personCenter.html
		p("\"></script>");// line 162, japidviews\AdminController\personCenter.html
		
		endDoLayout(sourceTemplate);
	}

	@Override protected void title() {
		// line 7, japidviews\AdminController\personCenter.html
		p("账号管理");// line 7, japidviews\AdminController\personCenter.html
		;
	}
}