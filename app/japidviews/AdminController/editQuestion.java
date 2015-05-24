//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import models.enums.QuestionType;
import models.enums.AdminMenu;
import models.sever.Question;
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
// NOTE: This file was generated from: japidviews/AdminController/editQuestion.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class editQuestion extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/editQuestion.html";
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


	public editQuestion() {
	super((StringBuilder)null);
	initHeaders();
	}
	public editQuestion(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public editQuestion(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"question",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"Question",  };
	public static final Object[] argDefaults= new Object[] {null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.editQuestion.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private Question question; // line 7, japidviews/AdminController/editQuestion.html
	public cn.bran.japid.template.RenderResult render(Question question) {
		this.question = question;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 7, japidviews/AdminController/editQuestion.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(Question question) {
		return new editQuestion().render(question);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\editQuestion.html
boolean isEmpty = question==null;// line 8, japidviews\AdminController\editQuestion.html
		p("<div class=\"content_page\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		");// line 8, japidviews\AdminController\editQuestion.html
		new leftMenusTag(editQuestion.this).render(AdminMenu.发布问答); // line 11, japidviews\AdminController\editQuestion.html// line 11, japidviews\AdminController\editQuestion.html
		p("		<section class=\"cell\">\n" + 
"			<nav id=\"addGoodNav\" class=\"nav_content_box fix\">\n" + 
"				<h4 class=\"l\">填写宝贝基本信息</h4>\n" + 
"                <span class=\"g9 r\">\n" + 
"                	<span class=\"cr\">*</span>\n" + 
"                    表示该项必填\n" + 
"                </span>\n" + 
"			</nav>\n" + 
"            <article class=\"mt20\">\n" + 
"            	<div class=\"p5 ca f14 bbahc\">1.问题基本信息</div>\n" + 
"	              \n" + 
"                <div class=\"ml20 mt10\">\n" + 
"                 	<div class=\"mb10\">\n" + 
"                    	<span class=\"p5 ca f14 bbahc\">\n" + 
"	                	问题类型：\n" + 
"	                	<select id=\"questionType\">\n" + 
"	                		");// line 11, japidviews\AdminController\editQuestion.html
		for(QuestionType questionType : QuestionType.values()){// line 28, japidviews\AdminController\editQuestion.html
		p("	                			<option value=\"");// line 28, japidviews\AdminController\editQuestion.html
		p(questionType.convert2Str());// line 29, japidviews\AdminController\editQuestion.html
		p("\"  ");// line 29, japidviews\AdminController\editQuestion.html
		p(!isEmpty&&questionType == question.questionType ? "selected" : "");// line 29, japidviews\AdminController\editQuestion.html
		p(">");// line 29, japidviews\AdminController\editQuestion.html
		p(questionType.convert2Str());// line 29, japidviews\AdminController\editQuestion.html
		p("</option>\n" + 
"	                			");// line 29, japidviews\AdminController\editQuestion.html
		}// line 30, japidviews\AdminController\editQuestion.html
		p("	                	</select>\n" + 
"	              		</span>\n" + 
"                    </div>\n" + 
"                    <div class=\"mb10\">\n" + 
"                    	问题：\n" + 
"                        <span class=\"cr\">*</span>\n" + 
"                        <input id=\"question\" class=\"jsForCount pct60 input vn\" type=\"text\" value=\"");// line 30, japidviews\AdminController\editQuestion.html
		p(null == question ? "" : question.question);// line 37, japidviews\AdminController\editQuestion.html
		p("\"/>\n" + 
"                        还能输入\n" + 
"                        <span class=\"cg\">");// line 37, japidviews\AdminController\editQuestion.html
		p(null == question ? 30 : 30-question.question.length());// line 39, japidviews\AdminController\editQuestion.html
		p("</span>\n" + 
"                        字\n" + 
"                    </div>\n" + 
"                    <div class=\"mb10\">\n" + 
"                    	答案：\n" + 
"                        <span class=\"cr \">*</span>\n" + 
"                        <div class=\" ml40\" >\n" + 
"                        	<textarea id=\"answerDiv\" class=\"dn\">");// line 39, japidviews\AdminController\editQuestion.html
		p(question==null?"":question.answer);// line 46, japidviews\AdminController\editQuestion.html
		p("</textarea>\n" + 
"	        				<script id=\"msgContent\" type=\"text/plain\" style=\"height:150px; width:490px;\" ></script>\n" + 
"	        			</div>\n" + 
"                    </div>\n" + 
"                  \n" + 
"                  \n" + 
"                </div>\n" + 
"                <div class=\"mt10 tc\">\n" + 
"                	<a id=\"publishQuestionBtn\" class=\"bluebtn btn_m\" href=\"javascript:;\">");// line 46, japidviews\AdminController\editQuestion.html
		p(null == question ? "发布问答" : "保存");// line 54, japidviews\AdminController\editQuestion.html
		p("</a>\n" + 
"                	<input id=\"questionIdInput\" type=\"hidden\" data=\"");// line 54, japidviews\AdminController\editQuestion.html
		p(null == question ? 0 : question.id);// line 55, japidviews\AdminController\editQuestion.html
		p("\"/>\n" + 
"                </div>\n" + 
"            </article>\n" + 
"        </section>\n" + 
"	</div>\n" + 
"</div>\n");// line 55, japidviews\AdminController\editQuestion.html
		new baseJSLinkTag(editQuestion.this).render(); // line 61, japidviews\AdminController\editQuestion.html// line 61, japidviews\AdminController\editQuestion.html
new iboxJSLinkTag(editQuestion.this).render(); // line 62, japidviews\AdminController\editQuestion.html// line 62, japidviews\AdminController\editQuestion.html
		p("<script src=\"");// line 62, japidviews\AdminController\editQuestion.html
		p(lookupStatic("/public/js/min/powerFloat.js"));// line 63, japidviews\AdminController\editQuestion.html
		p("\"></script>\n" + 
"<script src=\"");// line 63, japidviews\AdminController\editQuestion.html
		p(lookupStatic("/public/js/min/testRemind.js"));// line 64, japidviews\AdminController\editQuestion.html
		p("\"></script>\n" + 
"<script src=\"");// line 64, japidviews\AdminController\editQuestion.html
		p(lookupStatic("/public/js/min/ajax.js"));// line 65, japidviews\AdminController\editQuestion.html
		p("\"></script>\n" + 
"<script src=\"");// line 65, japidviews\AdminController\editQuestion.html
		p(lookupStatic("/public/js/checkinput.js"));// line 66, japidviews\AdminController\editQuestion.html
		p("\"></script>\n" + 
"<script type=\"text/javascript\" src=\"");// line 66, japidviews\AdminController\editQuestion.html
		p(lookupStatic("/public/js/ueditor/ueditor.config.js"));// line 67, japidviews\AdminController\editQuestion.html
		p("\"></script>\n" + 
"<script type=\"text/javascript\" src=\"");// line 67, japidviews\AdminController\editQuestion.html
		p(lookupStatic("/public/js/ueditor/ueditor.all.js"));// line 68, japidviews\AdminController\editQuestion.html
		p("\"></script>\n" + 
"<script type=\"text/javascript\" src=\"");// line 68, japidviews\AdminController\editQuestion.html
		p(lookupStatic("/public/js/back_qa.js"));// line 69, japidviews\AdminController\editQuestion.html
		p("\"></script>\n" + 
"<script type=\"text/javascript\">\n" + 
"//初始化ueditor\n" + 
"var ue,msgContentBox=$(\"msgContentBox\"),answer=$(\"answerDiv\").txt();\n" + 
"var initUedit = function(){\n" + 
"//	if(msgContentBox){\n" + 
"		ue= UE.getEditor('msgContent');\n" + 
"		ue.addListener(\"ready\", function () {ue.setContent(answer);});\n" + 
"//	}\n" + 
"}\n" + 
"\n" + 
"initUedit();\n" + 
"</script>\n");// line 69, japidviews\AdminController\editQuestion.html
		
		endDoLayout(sourceTemplate);
	}

}