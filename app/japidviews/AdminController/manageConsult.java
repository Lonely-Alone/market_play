//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import org.apache.commons.lang.StringUtils;
import models.enums.AdminMenu;
import models.sever.Consult;
import models.sever.Consult.ConsultType;
import utils.PictureUtil.Effect;
import cn.bran.play.JapidPlayAdapter;
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
// NOTE: This file was generated from: japidviews/AdminController/manageConsult.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class manageConsult extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/manageConsult.html";
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


	public manageConsult() {
	super((StringBuilder)null);
	initHeaders();
	}
	public manageConsult(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public manageConsult(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"consultList", "consultCount", "pageCount", "page",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"List<Consult>", "int", "int", "int",  };
	public static final Object[] argDefaults= new Object[] {null,null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.manageConsult.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private List<Consult> consultList; // line 11, japidviews/AdminController/manageConsult.html
	private int consultCount; // line 11, japidviews/AdminController/manageConsult.html
	private int pageCount; // line 11, japidviews/AdminController/manageConsult.html
	private int page; // line 11, japidviews/AdminController/manageConsult.html
	public cn.bran.japid.template.RenderResult render(List<Consult> consultList,int consultCount,int pageCount,int page) {
		this.consultList = consultList;
		this.consultCount = consultCount;
		this.pageCount = pageCount;
		this.page = page;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 11, japidviews/AdminController/manageConsult.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(List<Consult> consultList,int consultCount,int pageCount,int page) {
		return new manageConsult().render(consultList, consultCount, pageCount, page);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\manageConsult.html

p("\n" + 
"\n");// line 8, japidviews\AdminController\manageConsult.html
		p("\n" + 
"\n" + 
"\n" + 
"<div class=\"content_page\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		");// line 11, japidviews\AdminController\manageConsult.html
		new leftMenusTag(manageConsult.this).render(AdminMenu.求购管理); // line 17, japidviews\AdminController\manageConsult.html// line 17, japidviews\AdminController\manageConsult.html
		p("        <section class=\"cell\">\n" + 
"			<nav class=\"nav_content_box fix\">\n" + 
"				<span class=\"l\">所有求购</span>\n" + 
"				<span class=\"r\">\n" + 
"	                显示：\n" + 
"	                <select id=\"consultType\" value=\"全部\">\n" + 
"	                		<option value=\"\" >询价</option>\n" + 
"	                		<option value=\"\" >求购</option>\n" + 
"	                		<option value=\"\" >全部</option>\n" + 
"	                </select>\n" + 
"                </span>\n" + 
"			</nav>\n" + 
"            <article class=\"mt10\">\n" + 
"            	<div class=\"p10 bgf9 bdc\">\n" + 
"					<div>\n" + 
"				    	名字：\n" + 
"				        <input id=\"searchNameInput\" class=\"mr20 input pct20\" type=\"text\" value=\"\"/>\n" + 
"				        \n" + 
"				        <a id=\"searchGoodBtn\" class=\"bluebtn btn_s bdrad3 ml10\" href=\"javascript:;\">搜索</a>\n" + 
"				    </div>\n" + 
"				</div>\n" + 
"                <div class=\"mt10 p5 bgef tc bdc\">\n" + 
"                	<span class=\"dib pct20\">名字</span>\n" + 
"                	<span class=\"dib pct20\">描述</span>\n" + 
"                	<span class=\"dib pct5\">数量</span>\n" + 
"                    <span class=\"dib pct15\">单价范围（元）</span>\n" + 
"                    <span class=\"dib pct10\">联系人</span>\n" + 
"                    <span class=\"dib pct15\">联系电话</span>\n" + 
"                    <span class=\"dib pct10 tr\">创建时间</span>        \n" + 
"                </div>\n" + 
"                <div class=\"p5 fix\">\n" + 
"                	<span class=\"l\">\n" + 
"                    	<input id=\"checkAllChk\" class=\"vn\" type=\"checkbox\" />\n" + 
"                        <a id=\"checkAllBtn\" href=\"javascript:;\">全选</a>\n" + 
"                        <a id=\"removeBtn\" class=\"ml10\" href=\"javascript:;\">删除</a>\n" + 
"                    </span>\n" + 
"                    <span class=\"r\">\n" + 
"                        求购总数：<span id=\"dataCount\" class=\"co\">");// line 17, japidviews\AdminController\manageConsult.html
		p(consultCount);// line 55, japidviews\AdminController\manageConsult.html
		p("</span>\n" + 
"                        个\n" + 
"                    </span>\n" + 
"                </div>\n" + 
"                <table width=\"100%\" class=\"bdc tc\" cellpadding=\"5\" cellspacing=\"0\">\n" + 
"                    <tbody>\n" + 
"                    	");// line 55, japidviews\AdminController\manageConsult.html
		for(Consult consult : consultList){// line 61, japidviews\AdminController\manageConsult.html
                    	boolean b = "inquiry".equals(consult.type.toString());// line 62, japidviews\AdminController\manageConsult.html
		p("                    	<tr id=\"consultChk_");// line 62, japidviews\AdminController\manageConsult.html
		p(consult.id);// line 63, japidviews\AdminController\manageConsult.html
		p("\" class=\"bgef tl\">\n" + 
"                            <td colspan=\"8\"><input class=\"jsForCheck\" type=\"checkbox\" data=\"");// line 63, japidviews\AdminController\manageConsult.html
		p(consult.id);// line 64, japidviews\AdminController\manageConsult.html
		p("\"/></td>\n" + 
"                        </tr>\n" + 
"                        <tr id=\"consult_");// line 64, japidviews\AdminController\manageConsult.html
		p(consult.id);// line 66, japidviews\AdminController\manageConsult.html
		p("\">\n" + 
"                            <td class=\"pct20 tl fix\">\n" + 
"                            	<span class=\" pct90 l\">\n" + 
"									<i class=\"");// line 66, japidviews\AdminController\manageConsult.html
		p(b?" i_c6":" i_c7");// line 69, japidviews\AdminController\manageConsult.html
		p(" i_25 vm\"></i>	\n" + 
"									<a class=\"previewConsultBtn\" href=\"javascript:;\" data=\"");// line 69, japidviews\AdminController\manageConsult.html
		p(consult.id);// line 70, japidviews\AdminController\manageConsult.html
		p("\">");// line 70, japidviews\AdminController\manageConsult.html
		p(consult.name);// line 70, japidviews\AdminController\manageConsult.html
		p("</a>\n" + 
"								</span>\n" + 
"								\n" + 
"                            </td>\n" + 
"                            <td class=\"pct20 tl\">");// line 70, japidviews\AdminController\manageConsult.html
		p(consult.description);// line 74, japidviews\AdminController\manageConsult.html
		p("</td>\n" + 
"                            <td class=\"pct10 tl\">");// line 74, japidviews\AdminController\manageConsult.html
		p(consult.num);// line 75, japidviews\AdminController\manageConsult.html
		p("</td>\n" + 
"                            <td class=\"pct10\">");// line 75, japidviews\AdminController\manageConsult.html
		p(consult.priceRange);// line 76, japidviews\AdminController\manageConsult.html
		p("</td>\n" + 
"                            <td class=\"pct10 tl\">");// line 76, japidviews\AdminController\manageConsult.html
		p(consult.contactPerson);// line 77, japidviews\AdminController\manageConsult.html
		p("</td>\n" + 
"                            <td class=\"pct10\">");// line 77, japidviews\AdminController\manageConsult.html
		p(consult.contactNum);// line 78, japidviews\AdminController\manageConsult.html
		p("</td>\n" + 
"                            <td class=\"pct10\">");// line 78, japidviews\AdminController\manageConsult.html
		p(formatDate(consult.createTime, "yyyy-MM-dd HH:mm:ss"));// line 79, japidviews\AdminController\manageConsult.html
		p("</td>\n" + 
"                        </tr>\n" + 
"                    	");// line 79, japidviews\AdminController\manageConsult.html
		}// line 81, japidviews\AdminController\manageConsult.html
		p("                        <tr class=\"bgef tr\">\n" + 
"                        	<td class=\"p10\" colspan=\"8\">\n" + 
"                        		");// line 81, japidviews\AdminController\manageConsult.html
		new pagesTag(manageConsult.this).render(JapidPlayAdapter.lookup("AdminController.manageConsult"),"page",page,pageCount); // line 84, japidviews\AdminController\manageConsult.html// line 84, japidviews\AdminController\manageConsult.html
		p("                            </td>\n" + 
"                        </tr>\n" + 
"                     </tbody>\n" + 
"            	</table>\n" + 
"            </article>\n" + 
"        </section>\n" + 
"	</div>\n" + 
"</div>\n");// line 84, japidviews\AdminController\manageConsult.html
		new baseJSLinkTag(manageConsult.this).render(); // line 93, japidviews\AdminController\manageConsult.html// line 93, japidviews\AdminController\manageConsult.html
new iboxJSLinkTag(manageConsult.this).render(); // line 94, japidviews\AdminController\manageConsult.html// line 94, japidviews\AdminController\manageConsult.html
		p("<script src=\"");// line 94, japidviews\AdminController\manageConsult.html
		p(lookupStatic("/public/js/min/powerFloat.js"));// line 95, japidviews\AdminController\manageConsult.html
		p("\"></script>\n" + 
"<script src=\"");// line 95, japidviews\AdminController\manageConsult.html
		p(lookupStatic("/public/js/min/testRemind.js"));// line 96, japidviews\AdminController\manageConsult.html
		p("\"></script>\n" + 
"<script src=\"");// line 96, japidviews\AdminController\manageConsult.html
		p(lookupStatic("/public/js/min/ajax.js"));// line 97, japidviews\AdminController\manageConsult.html
		p("\"></script>\n" + 
"<script src=\"");// line 97, japidviews\AdminController\manageConsult.html
		p(lookupStatic("/public/js/min/calendar.js"));// line 98, japidviews\AdminController\manageConsult.html
		p("\"></script>\n" + 
"<script src=\"");// line 98, japidviews\AdminController\manageConsult.html
		p(lookupStatic("/public/js/crud.js"));// line 99, japidviews\AdminController\manageConsult.html
		p("\"></script>\n" + 
"<script src=\"");// line 99, japidviews\AdminController\manageConsult.html
		p(lookupStatic("/public/js/paging.js"));// line 100, japidviews\AdminController\manageConsult.html
		p("\"></script>\n" + 
"<script src=\"");// line 100, japidviews\AdminController\manageConsult.html
		p(lookupStatic("/public/js/checkinput.js"));// line 101, japidviews\AdminController\manageConsult.html
		p("\"></script>\n" + 
"<script src=\"");// line 101, japidviews\AdminController\manageConsult.html
		p(lookupStatic("/public/js/back_consult.js"));// line 102, japidviews\AdminController\manageConsult.html
		p("\"></script>");// line 102, japidviews\AdminController\manageConsult.html
		
		endDoLayout(sourceTemplate);
	}

}