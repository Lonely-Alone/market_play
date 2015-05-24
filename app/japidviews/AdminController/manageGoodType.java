//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import org.apache.commons.lang.StringUtils;
import models.enums.AdminMenu;
import models.goods.GoodType;
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
// NOTE: This file was generated from: japidviews/AdminController/manageGoodType.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class manageGoodType extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/manageGoodType.html";
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


	public manageGoodType() {
	super((StringBuilder)null);
	initHeaders();
	}
	public manageGoodType(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public manageGoodType(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"typeList", "typeCount", "pageCount", "page",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"List<GoodType>", "int", "int", "int",  };
	public static final Object[] argDefaults= new Object[] {null,null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.manageGoodType.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private List<GoodType> typeList; // line 10, japidviews/AdminController/manageGoodType.html
	private int typeCount; // line 10, japidviews/AdminController/manageGoodType.html
	private int pageCount; // line 10, japidviews/AdminController/manageGoodType.html
	private int page; // line 10, japidviews/AdminController/manageGoodType.html
	public cn.bran.japid.template.RenderResult render(List<GoodType> typeList,int typeCount,int pageCount,int page) {
		this.typeList = typeList;
		this.typeCount = typeCount;
		this.pageCount = pageCount;
		this.page = page;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 10, japidviews/AdminController/manageGoodType.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(List<GoodType> typeList,int typeCount,int pageCount,int page) {
		return new manageGoodType().render(typeList, typeCount, pageCount, page);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\manageGoodType.html

p("\n" + 
"\n");// line 7, japidviews\AdminController\manageGoodType.html
		p("\n" + 
"\n" + 
"\n" + 
"<div class=\"content_page\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		");// line 10, japidviews\AdminController\manageGoodType.html
		new leftMenusTag(manageGoodType.this).render(AdminMenu.商品类型); // line 16, japidviews\AdminController\manageGoodType.html// line 16, japidviews\AdminController\manageGoodType.html
		p("		 <section class=\"cell\">\n" + 
"			<nav class=\"nav_content_box fix\">\n" + 
"				<span class=\"l\">所有商品类型</span>\n" + 
"				<span class=\"r\">\n" + 
"                </span>\n" + 
"			</nav>\n" + 
"            <article class=\"mt10\">\n" + 
"            	<div class=\"p10 bgf9 bdc\">\n" + 
"					<div>\n" + 
"				    	名字：\n" + 
"				        <input id=\"searchNameInput\" class=\"mr20 input pct20\" type=\"text\" value=\"\"/>\n" + 
"				        \n" + 
"				        <a id=\"searchTypeBtn\" class=\"bluebtn btn_s bdrad3 ml10\" href=\"javascript:;\">搜索</a>\n" + 
"				        \n" + 
"				        <a id=\"addTypeBtn\" class=\"bluebtn btn_s bdrad3 ml10\" href=\"javascript:;\">添加</a>\n" + 
"				    </div>\n" + 
"				</div>\n" + 
"                <div class=\"mt10 p5 bgef bdc tc\">\n" + 
"                	<span class=\"dib pct30\">名字</span>\n" + 
"                	<span class=\"dib pct10\">创建时间</span>\n" + 
"          \n" + 
"                        \n" + 
"                </div>\n" + 
"                <div class=\"p5 fix\">\n" + 
"                	<span class=\"l\">\n" + 
"                    	<input id=\"checkAllChk\" class=\"vn\" type=\"checkbox\" />\n" + 
"                        <a id=\"checkAllBtn\" href=\"javascript:;\">全选</a>\n" + 
"                        <a id=\"removeBtn\" class=\"ml10\" href=\"javascript:;\">删除</a>\n" + 
"                    </span>\n" + 
"                    <span class=\"r\">\n" + 
"                       类型总数：<span id=\"dataCount\" class=\"co\">");// line 16, japidviews\AdminController\manageGoodType.html
		p(typeCount);// line 47, japidviews\AdminController\manageGoodType.html
		p("</span>\n" + 
"                        个\n" + 
"                    </span>\n" + 
"                </div>\n" + 
"                <table width=\"100%\" class=\"bdc tc\" cellpadding=\"5\" cellspacing=\"0\">\n" + 
"                    <tbody>\n" + 
"                    	");// line 47, japidviews\AdminController\manageGoodType.html
		for(GoodType type : typeList){// line 53, japidviews\AdminController\manageGoodType.html
		p("                    	<tr id=\"typeChk_");// line 53, japidviews\AdminController\manageGoodType.html
		p(type.id);// line 54, japidviews\AdminController\manageGoodType.html
		p("\" class=\"bgef tl\">\n" + 
"                            <td colspan=\"8\"><input class=\"jsForCheck\" type=\"checkbox\" data=\"");// line 54, japidviews\AdminController\manageGoodType.html
		p(type.id);// line 55, japidviews\AdminController\manageGoodType.html
		p("\"/></td>\n" + 
"                        </tr>\n" + 
"                        <tr id=\"type_");// line 55, japidviews\AdminController\manageGoodType.html
		p(type.id);// line 57, japidviews\AdminController\manageGoodType.html
		p("\">\n" + 
"                            <td class=\"pct30 tl fix\">\n" + 
"                            	<span class=\" pct90 l\">\n" + 
"									<a class=\"previewConsultBtn\" href=\"javascript:;\" data=\"");// line 57, japidviews\AdminController\manageGoodType.html
		p(type.id);// line 60, japidviews\AdminController\manageGoodType.html
		p("\">");// line 60, japidviews\AdminController\manageGoodType.html
		p(type.name);// line 60, japidviews\AdminController\manageGoodType.html
		p("</a>\n" + 
"								</span>\n" + 
"								\n" + 
"                            </td>\n" + 
"                            <td class=\"pct10\">");// line 60, japidviews\AdminController\manageGoodType.html
		p(formatDate(type.createTime, "yyyy-MM-dd HH:mm:ss"));// line 64, japidviews\AdminController\manageGoodType.html
		p("</td>\n" + 
"                    	");// line 64, japidviews\AdminController\manageGoodType.html
		}// line 65, japidviews\AdminController\manageGoodType.html
		p("                        <tr class=\"bgef tr\">\n" + 
"                        	<td class=\"p10\" colspan=\"8\">\n" + 
"                        		");// line 65, japidviews\AdminController\manageGoodType.html
		new pagesTag(manageGoodType.this).render(JapidPlayAdapter.lookup("AdminController.manageGoodType"),"page",page,pageCount); // line 68, japidviews\AdminController\manageGoodType.html// line 68, japidviews\AdminController\manageGoodType.html
		p("                            </td>\n" + 
"                        </tr>\n" + 
"                     </tbody>\n" + 
"            	</table>\n" + 
"            </article>\n" + 
"        </section>\n" + 
"	</div>\n" + 
"</div>\n");// line 68, japidviews\AdminController\manageGoodType.html
		new baseJSLinkTag(manageGoodType.this).render(); // line 77, japidviews\AdminController\manageGoodType.html// line 77, japidviews\AdminController\manageGoodType.html
new iboxJSLinkTag(manageGoodType.this).render(); // line 78, japidviews\AdminController\manageGoodType.html// line 78, japidviews\AdminController\manageGoodType.html
		p("<script src=\"");// line 78, japidviews\AdminController\manageGoodType.html
		p(lookupStatic("/public/js/min/powerFloat.js"));// line 79, japidviews\AdminController\manageGoodType.html
		p("\"></script>\n" + 
"<script src=\"");// line 79, japidviews\AdminController\manageGoodType.html
		p(lookupStatic("/public/js/min/testRemind.js"));// line 80, japidviews\AdminController\manageGoodType.html
		p("\"></script>\n" + 
"<script src=\"");// line 80, japidviews\AdminController\manageGoodType.html
		p(lookupStatic("/public/js/min/ajax.js"));// line 81, japidviews\AdminController\manageGoodType.html
		p("\"></script>\n" + 
"<script src=\"");// line 81, japidviews\AdminController\manageGoodType.html
		p(lookupStatic("/public/js/min/calendar.js"));// line 82, japidviews\AdminController\manageGoodType.html
		p("\"></script>\n" + 
"<script src=\"");// line 82, japidviews\AdminController\manageGoodType.html
		p(lookupStatic("/public/js/crud.js"));// line 83, japidviews\AdminController\manageGoodType.html
		p("\"></script>\n" + 
"<script src=\"");// line 83, japidviews\AdminController\manageGoodType.html
		p(lookupStatic("/public/js/paging.js"));// line 84, japidviews\AdminController\manageGoodType.html
		p("\"></script>\n" + 
"<script src=\"");// line 84, japidviews\AdminController\manageGoodType.html
		p(lookupStatic("/public/js/checkinput.js"));// line 85, japidviews\AdminController\manageGoodType.html
		p("\"></script>\n" + 
"<script src=\"");// line 85, japidviews\AdminController\manageGoodType.html
		p(lookupStatic("/public/js/back_goodType.js"));// line 86, japidviews\AdminController\manageGoodType.html
		p("\"></script>");// line 86, japidviews\AdminController\manageGoodType.html
		
		endDoLayout(sourceTemplate);
	}

}