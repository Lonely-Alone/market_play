//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import models.enums.QuestionType;
import models.enums.AdminMenu;
import cn.bran.play.JapidPlayAdapter;
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
// NOTE: This file was generated from: japidviews/AdminController/manageQuestion.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class manageQuestion extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/manageQuestion.html";
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


	public manageQuestion() {
	super((StringBuilder)null);
	initHeaders();
	}
	public manageQuestion(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public manageQuestion(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"questionList", "questionCount", "pageCount", "page", "questionType", "question",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"List<Question>", "int", "int", "int", "QuestionType", "String",  };
	public static final Object[] argDefaults= new Object[] {null,null,null,null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.manageQuestion.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private List<Question> questionList; // line 7, japidviews/AdminController/manageQuestion.html
	private int questionCount; // line 7, japidviews/AdminController/manageQuestion.html
	private int pageCount; // line 7, japidviews/AdminController/manageQuestion.html
	private int page; // line 7, japidviews/AdminController/manageQuestion.html
	private QuestionType questionType; // line 7, japidviews/AdminController/manageQuestion.html
	private String question; // line 7, japidviews/AdminController/manageQuestion.html
	public cn.bran.japid.template.RenderResult render(List<Question> questionList,int questionCount,int pageCount,int page,QuestionType questionType,String question) {
		this.questionList = questionList;
		this.questionCount = questionCount;
		this.pageCount = pageCount;
		this.page = page;
		this.questionType = questionType;
		this.question = question;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 7, japidviews/AdminController/manageQuestion.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(List<Question> questionList,int questionCount,int pageCount,int page,QuestionType questionType,String question) {
		return new manageQuestion().render(questionList, questionCount, pageCount, page, questionType, question);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\manageQuestion.html
p("\n" + 
"\n");// line 4, japidviews\AdminController\manageQuestion.html

p("<div class=\"content_page\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		");// line 9, japidviews\AdminController\manageQuestion.html
		new leftMenusTag(manageQuestion.this).render(AdminMenu.问答管理); // line 12, japidviews\AdminController\manageQuestion.html// line 12, japidviews\AdminController\manageQuestion.html
		p("        <section class=\"cell\">\n" + 
"			<nav class=\"nav_content_box fix\">\n" + 
"				<span class=\"l\">所有问答</span>\n" + 
"				<span class=\"r\">\n" + 
"	                显示：\n" + 
"	                <select id=\"questionFilter\">\n" + 
"	                	");// line 12, japidviews\AdminController\manageQuestion.html
		for(QuestionType type : QuestionType.values()){// line 19, japidviews\AdminController\manageQuestion.html
		p("	                			<option value=\"");// line 19, japidviews\AdminController\manageQuestion.html
		p(type.convert2Str());// line 20, japidviews\AdminController\manageQuestion.html
		p("\"  ");// line 20, japidviews\AdminController\manageQuestion.html
		p(type == questionType ? "selected" : "");// line 20, japidviews\AdminController\manageQuestion.html
		p(">");// line 20, japidviews\AdminController\manageQuestion.html
		p(type.convert2Str());// line 20, japidviews\AdminController\manageQuestion.html
		p("</option>\n" + 
"            			");// line 20, japidviews\AdminController\manageQuestion.html
		}// line 21, japidviews\AdminController\manageQuestion.html
		p("	                </select>\n" + 
"                </span>\n" + 
"			</nav>\n" + 
"            <article class=\"mt10\">\n" + 
"            	<div class=\"p10 bgf9 bdc\">\n" + 
"					<div>\n" + 
"				    	问题：\n" + 
"				        <input id=\"searchQuestionInput\" class=\"mr20 input pct20\" type=\"text\" value=\"");// line 21, japidviews\AdminController\manageQuestion.html
		p(question);// line 29, japidviews\AdminController\manageQuestion.html
		p("\"/>\n" + 
"				        <a id=\"searchQuestionBtn\" class=\"bluebtn btn_s bdrad3 ml10\" href=\"javascript:;\">搜索</a>\n" + 
"				    </div>\n" + 
"				</div> \n" + 
"                <div class=\"p5 fix\">\n" + 
"                	<span class=\"l\">\n" + 
"                    	<input id=\"checkAllChk\" class=\"vn\" type=\"checkbox\" />\n" + 
"                        <a id=\"checkAllBtn\" href=\"javascript:;\">全选</a>\n" + 
"                        <a id=\"removeBtn\" class=\"ml10\" href=\"javascript:;\">删除</a>\n" + 
"                    </span>\n" + 
"                    <span class=\"r\">\n" + 
"                       	问答总数：<span id=\"dataCount\" class=\"co\">");// line 29, japidviews\AdminController\manageQuestion.html
		p(questionCount);// line 40, japidviews\AdminController\manageQuestion.html
		p("</span>\n" + 
"                       	 个\n" + 
"                    </span>\n" + 
"                </div>\n" + 
"                <div class=\"mt10 mb5 p5 bgef bdc\">\n" + 
"                	<span class=\"dib pct15\">问答类型</span>\n" + 
"                	<span class=\"dib pct15\">问题</span>\n" + 
"                	<span class=\"dib pct50\">答案</span>\n" + 
"                	<span class=\"dib pct10\">创建时间</span>\n" + 
"                	<span class=\"dib\">&nbsp;</span>\n" + 
"                </div>\n" + 
"                <table width=\"100%\" class=\"bdc\" cellpadding=\"5\" cellspacing=\"0\">\n" + 
"                    <tbody>\n" + 
"                    	");// line 40, japidviews\AdminController\manageQuestion.html
		for(Question ques : questionList){// line 53, japidviews\AdminController\manageQuestion.html
		p("                    	<tr id=\"questionChk_");// line 53, japidviews\AdminController\manageQuestion.html
		p(ques.id);// line 54, japidviews\AdminController\manageQuestion.html
		p("\" class=\"bgef tl\">\n" + 
"                            <td colspan=\"8\"><input class=\"jsForCheck\" type=\"checkbox\" data=\"");// line 54, japidviews\AdminController\manageQuestion.html
		p(ques.id);// line 55, japidviews\AdminController\manageQuestion.html
		p("\"/></td>\n" + 
"                        </tr>\n" + 
"                        <tr id=\"question_");// line 55, japidviews\AdminController\manageQuestion.html
		p(ques.id);// line 57, japidviews\AdminController\manageQuestion.html
		p("\">\n" + 
"                         	<td class=\"pct10\">");// line 57, japidviews\AdminController\manageQuestion.html
		p(ques.questionType.convert2Str());// line 58, japidviews\AdminController\manageQuestion.html
		p("</td>\n" + 
"                            <td class=\"pct15 fix\">\n" + 
"                            	<div class=\"ml5 co l\">");// line 58, japidviews\AdminController\manageQuestion.html
		p(ques.question);// line 60, japidviews\AdminController\manageQuestion.html
		p("</div>\n" + 
"                            </td>\n" + 
"                            <td class=\"pct45\"><div class=\"text-wrap\">");// line 60, japidviews\AdminController\manageQuestion.html
		p(ques.answer);// line 62, japidviews\AdminController\manageQuestion.html
		p("</div></td>\n" + 
"                            <td class=\"pct10\">");// line 62, japidviews\AdminController\manageQuestion.html
		p(formatDate(ques.createTime, "yyyy-MM-dd HH:mm:ss"));// line 63, japidviews\AdminController\manageQuestion.html
		p("</td>\n" + 
"							<td class=\"pct10\">\n" + 
"                            	<a href=\"");// line 63, japidviews\AdminController\manageQuestion.html
		p(lookup("AdminController.editQuestion", ques.id));// line 65, japidviews\AdminController\manageQuestion.html
		p("\">编辑</a>\n" + 
"                            </td>\n" + 
"                        </tr>\n" + 
"                    	");// line 65, japidviews\AdminController\manageQuestion.html
		}// line 68, japidviews\AdminController\manageQuestion.html
		p("                        <tr class=\"bgef tr\">\n" + 
"                        	<td class=\"p10\" colspan=\"8\">\n" + 
"                        		");// line 68, japidviews\AdminController\manageQuestion.html
		new pagesTag(manageQuestion.this).render(JapidPlayAdapter.lookup("AdminController.manageQuestion", question, questionType),"page",page,pageCount); // line 71, japidviews\AdminController\manageQuestion.html// line 71, japidviews\AdminController\manageQuestion.html
		p("                            </td>\n" + 
"                        </tr>\n" + 
"                     </tbody>\n" + 
"            	</table>\n" + 
"            </article>\n" + 
"        </section>\n" + 
"	</div>\n" + 
"</div>\n");// line 71, japidviews\AdminController\manageQuestion.html
		new baseJSLinkTag(manageQuestion.this).render(); // line 80, japidviews\AdminController\manageQuestion.html// line 80, japidviews\AdminController\manageQuestion.html
new iboxJSLinkTag(manageQuestion.this).render(); // line 81, japidviews\AdminController\manageQuestion.html// line 81, japidviews\AdminController\manageQuestion.html
		p("<script src=\"");// line 81, japidviews\AdminController\manageQuestion.html
		p(lookupStatic("/public/js/min/powerFloat.js"));// line 82, japidviews\AdminController\manageQuestion.html
		p("\"></script>\n" + 
"<script src=\"");// line 82, japidviews\AdminController\manageQuestion.html
		p(lookupStatic("/public/js/min/testRemind.js"));// line 83, japidviews\AdminController\manageQuestion.html
		p("\"></script>\n" + 
"<script src=\"");// line 83, japidviews\AdminController\manageQuestion.html
		p(lookupStatic("/public/js/min/ajax.js"));// line 84, japidviews\AdminController\manageQuestion.html
		p("\"></script>\n" + 
"<script src=\"");// line 84, japidviews\AdminController\manageQuestion.html
		p(lookupStatic("/public/js/min/calendar.js"));// line 85, japidviews\AdminController\manageQuestion.html
		p("\"></script>\n" + 
"<script src=\"");// line 85, japidviews\AdminController\manageQuestion.html
		p(lookupStatic("/public/js/crud.js"));// line 86, japidviews\AdminController\manageQuestion.html
		p("\"></script>\n" + 
"<script src=\"");// line 86, japidviews\AdminController\manageQuestion.html
		p(lookupStatic("/public/js/paging.js"));// line 87, japidviews\AdminController\manageQuestion.html
		p("\"></script>\n" + 
"<script src=\"");// line 87, japidviews\AdminController\manageQuestion.html
		p(lookupStatic("/public/js/checkinput.js"));// line 88, japidviews\AdminController\manageQuestion.html
		p("\"></script>\n" + 
"<script src=\"");// line 88, japidviews\AdminController\manageQuestion.html
		p(lookupStatic("/public/js/back_qa.js"));// line 89, japidviews\AdminController\manageQuestion.html
		p("\"></script>");// line 89, japidviews\AdminController\manageQuestion.html
		
		endDoLayout(sourceTemplate);
	}

}