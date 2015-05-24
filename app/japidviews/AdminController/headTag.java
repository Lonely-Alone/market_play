//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
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
// NOTE: This file was generated from: japidviews/AdminController/headTag.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class headTag extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/AdminController/headTag.html";
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


	public headTag() {
	super((StringBuilder)null);
	initHeaders();
	}
	public headTag(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public headTag(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/ };
	public static final String[] argTypes = new String[] {/* arg types of the template*/ };
	public static final Object[] argDefaults= new Object[] { };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.headTag.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	public cn.bran.japid.template.RenderResult render() {
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 0, japidviews/AdminController/headTag.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply() {
		return new headTag().render();
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\headTag.html
Person currPerson = getCurrentPerson();// line 2, japidviews\AdminController\headTag.html
if(null != currPerson){// line 3, japidviews\AdminController\headTag.html
		p("<header class=\"head\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		<h1 class=\"mt5 wh l\"><a href=\"");// line 3, japidviews\AdminController\headTag.html
		p(lookup("AdminController.personCenter", new Object[]{}));// line 6, japidviews\AdminController\headTag.html
		p("\" class=\"wh tdn\">微店</a></h1>\n" + 
"    	<div class=\"mt10 r\">\n" + 
"        	<a class=\"ml10 wh\" href=\"");// line 6, japidviews\AdminController\headTag.html
		p(lookup("AdminController.personCenter", new Object[]{}));// line 8, japidviews\AdminController\headTag.html
		p("\">");// line 8, japidviews\AdminController\headTag.html
		p(currPerson.loginName);// line 8, japidviews\AdminController\headTag.html
		p("</a>\n" + 
"        	<a class=\"ml10 wh\" href=\"");// line 8, japidviews\AdminController\headTag.html
		p(lookup("Application.logout", new Object[]{}));// line 9, japidviews\AdminController\headTag.html
		p("\">退出</a>\n" + 
"    	</div>\n" + 
"	</div>   \n" + 
"</header>\n");// line 9, japidviews\AdminController\headTag.html
		}// line 13, japidviews\AdminController\headTag.html
		
		endDoLayout(sourceTemplate);
	}

}