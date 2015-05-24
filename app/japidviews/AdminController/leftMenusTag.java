//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import models.person.Admin;
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
// NOTE: This file was generated from: japidviews/AdminController/leftMenusTag.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class leftMenusTag extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/AdminController/leftMenusTag.html";
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


	public leftMenusTag() {
	super((StringBuilder)null);
	initHeaders();
	}
	public leftMenusTag(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public leftMenusTag(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"currMenu",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"AdminMenu",  };
	public static final Object[] argDefaults= new Object[] {null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.leftMenusTag.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private AdminMenu currMenu; // line 3, japidviews/AdminController/leftMenusTag.html
	public cn.bran.japid.template.RenderResult render(AdminMenu currMenu) {
		this.currMenu = currMenu;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 3, japidviews/AdminController/leftMenusTag.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(AdminMenu currMenu) {
		return new leftMenusTag().render(currMenu);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\leftMenusTag.html
Admin currPerson = (Admin)getCurrentPerson();// line 4, japidviews\AdminController\leftMenusTag.html
boolean isService =currPerson==null?false: currPerson.isService();// line 5, japidviews\AdminController\leftMenusTag.html
		p("\n" + 
"\n" + 
"\n" + 
"<section class=\"mr20 l\">\n" + 
"	<nav class=\"nav_list_box\">\n" + 
"	");// line 5, japidviews\AdminController\leftMenusTag.html
		AdminMenu[] menus=isService?leftServiceMenu():leftMenus();// line 11, japidviews\AdminController\leftMenusTag.html
	for(AdminMenu menu : menus){// line 12, japidviews\AdminController\leftMenusTag.html
		boolean isSelected = currMenu == menu;// line 13, japidviews\AdminController\leftMenusTag.html
		p("		<div class=\"nav_");// line 13, japidviews\AdminController\leftMenusTag.html
		p(isSelected ? "on" : "off");// line 14, japidviews\AdminController\leftMenusTag.html
		p("\">\n" + 
"			<a href=\"");// line 14, japidviews\AdminController\leftMenusTag.html
		p(menu.getRenderUrl());// line 15, japidviews\AdminController\leftMenusTag.html
		p("\" class=\"");// line 15, japidviews\AdminController\leftMenusTag.html
		p(isSelected ? "wh" : "g5");// line 15, japidviews\AdminController\leftMenusTag.html
		p("\">");// line 15, japidviews\AdminController\leftMenusTag.html
		p(menu.name());// line 15, japidviews\AdminController\leftMenusTag.html
		p("</a>\n" + 
"		</div>\n" + 
"	");// line 15, japidviews\AdminController\leftMenusTag.html
		}// line 17, japidviews\AdminController\leftMenusTag.html
		p("	</nav>\n" + 
"</section>");// line 17, japidviews\AdminController\leftMenusTag.html
		
		endDoLayout(sourceTemplate);
	}

}