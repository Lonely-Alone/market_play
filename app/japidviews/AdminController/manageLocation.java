//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import org.apache.commons.lang.StringUtils;
import models.enums.AdminMenu;
import utils.PictureUtil.Effect;
import cn.bran.play.JapidPlayAdapter;
import models.order.Location;
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
// NOTE: This file was generated from: japidviews/AdminController/manageLocation.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class manageLocation extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/manageLocation.html";
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


	public manageLocation() {
	super((StringBuilder)null);
	initHeaders();
	}
	public manageLocation(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public manageLocation(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"locationList", "locationCount", "pageCount", "page",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"List<Location>", "int", "int", "int",  };
	public static final Object[] argDefaults= new Object[] {null,null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.manageLocation.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private List<Location> locationList; // line 10, japidviews/AdminController/manageLocation.html
	private int locationCount; // line 10, japidviews/AdminController/manageLocation.html
	private int pageCount; // line 10, japidviews/AdminController/manageLocation.html
	private int page; // line 10, japidviews/AdminController/manageLocation.html
	public cn.bran.japid.template.RenderResult render(List<Location> locationList,int locationCount,int pageCount,int page) {
		this.locationList = locationList;
		this.locationCount = locationCount;
		this.pageCount = pageCount;
		this.page = page;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 10, japidviews/AdminController/manageLocation.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(List<Location> locationList,int locationCount,int pageCount,int page) {
		return new manageLocation().render(locationList, locationCount, pageCount, page);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\manageLocation.html

p("\n" + 
"\n");// line 7, japidviews\AdminController\manageLocation.html
		p("\n" + 
"\n" + 
"\n" + 
"<div class=\"content_page\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		");// line 10, japidviews\AdminController\manageLocation.html
		new leftMenusTag(manageLocation.this).render(AdminMenu.自取地点); // line 16, japidviews\AdminController\manageLocation.html// line 16, japidviews\AdminController\manageLocation.html
		p("		 <section class=\"cell\">\n" + 
"			<nav class=\"nav_content_box fix\">\n" + 
"				<span class=\"l\">所有取货地点</span>\n" + 
"				<span class=\"r\">\n" + 
"                </span>\n" + 
"			</nav>\n" + 
"            <article class=\"mt10\">\n" + 
"            	<div class=\"p10 bgf9 bdc\">\n" + 
"					<div>\n" + 
"				    	地址：\n" + 
"				        <input id=\"searchNameInput\" class=\"mr20 input pct20\" type=\"text\" value=\"\"/>\n" + 
"				        \n" + 
"				        <a id=\"searchLocationBtn\" class=\"bluebtn btn_s bdrad3 ml10\" href=\"javascript:;\">搜索</a>\n" + 
"				        \n" + 
"				        <a id=\"addLocationBtn\" class=\"bluebtn btn_s bdrad3 ml10\" href=\"javascript:;\">添加</a>\n" + 
"				    </div>\n" + 
"				</div>\n" + 
"                <div class=\"mt10 p5 bgef bdc tc\">\n" + 
"                	<span class=\"dib pct30\">地址</span>\n" + 
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
"                       类型总数：<span id=\"dataCount\" class=\"co\">");// line 16, japidviews\AdminController\manageLocation.html
		p(locationCount);// line 47, japidviews\AdminController\manageLocation.html
		p("</span>\n" + 
"                        个\n" + 
"                    </span>\n" + 
"                </div>\n" + 
"                <table width=\"100%\" class=\"bdc tc\" cellpadding=\"5\" cellspacing=\"0\">\n" + 
"                    <tbody>\n" + 
"                    	");// line 47, japidviews\AdminController\manageLocation.html
		for(Location location : locationList){// line 53, japidviews\AdminController\manageLocation.html
		p("                    	<tr id=\"locationChk_");// line 53, japidviews\AdminController\manageLocation.html
		p(location.id);// line 54, japidviews\AdminController\manageLocation.html
		p("\" class=\"bgef tl\">\n" + 
"                            <td colspan=\"8\"><input class=\"jsForCheck\" type=\"checkbox\" data=\"");// line 54, japidviews\AdminController\manageLocation.html
		p(location.id);// line 55, japidviews\AdminController\manageLocation.html
		p("\"/></td>\n" + 
"                        </tr>\n" + 
"                        <tr id=\"location_");// line 55, japidviews\AdminController\manageLocation.html
		p(location.id);// line 57, japidviews\AdminController\manageLocation.html
		p("\">\n" + 
"                            <td class=\"pct30 tl fix\">\n" + 
"                            	<span class=\" pct90 l\">\n" + 
"									<a class=\"previewConsultBtn\" href=\"javascript:;\" data=\"");// line 57, japidviews\AdminController\manageLocation.html
		p(location.id);// line 60, japidviews\AdminController\manageLocation.html
		p("\">");// line 60, japidviews\AdminController\manageLocation.html
		p(location.address);// line 60, japidviews\AdminController\manageLocation.html
		p("</a>\n" + 
"								</span>\n" + 
"								\n" + 
"                            </td>\n" + 
"                            <td class=\"pct10\">");// line 60, japidviews\AdminController\manageLocation.html
		p(formatDate(location.createTime, "yyyy-MM-dd HH:mm:ss"));// line 64, japidviews\AdminController\manageLocation.html
		p("</td>\n" + 
"                    	");// line 64, japidviews\AdminController\manageLocation.html
		}// line 65, japidviews\AdminController\manageLocation.html
		p("                        <tr class=\"bgef tr\">\n" + 
"                        	<td class=\"p10\" colspan=\"8\">\n" + 
"                        		");// line 65, japidviews\AdminController\manageLocation.html
		new pagesTag(manageLocation.this).render(JapidPlayAdapter.lookup("AdminController.manageLocation"),"page",page,pageCount); // line 68, japidviews\AdminController\manageLocation.html// line 68, japidviews\AdminController\manageLocation.html
		p("                            </td>\n" + 
"                        </tr>\n" + 
"                     </tbody>\n" + 
"            	</table>\n" + 
"            </article>\n" + 
"        </section>\n" + 
"	</div>\n" + 
"</div>\n");// line 68, japidviews\AdminController\manageLocation.html
		new baseJSLinkTag(manageLocation.this).render(); // line 77, japidviews\AdminController\manageLocation.html// line 77, japidviews\AdminController\manageLocation.html
new iboxJSLinkTag(manageLocation.this).render(); // line 78, japidviews\AdminController\manageLocation.html// line 78, japidviews\AdminController\manageLocation.html
		p("<script src=\"");// line 78, japidviews\AdminController\manageLocation.html
		p(lookupStatic("/public/js/min/powerFloat.js"));// line 79, japidviews\AdminController\manageLocation.html
		p("\"></script>\n" + 
"<script src=\"");// line 79, japidviews\AdminController\manageLocation.html
		p(lookupStatic("/public/js/min/testRemind.js"));// line 80, japidviews\AdminController\manageLocation.html
		p("\"></script>\n" + 
"<script src=\"");// line 80, japidviews\AdminController\manageLocation.html
		p(lookupStatic("/public/js/min/ajax.js"));// line 81, japidviews\AdminController\manageLocation.html
		p("\"></script>\n" + 
"<script src=\"");// line 81, japidviews\AdminController\manageLocation.html
		p(lookupStatic("/public/js/min/calendar.js"));// line 82, japidviews\AdminController\manageLocation.html
		p("\"></script>\n" + 
"<script src=\"");// line 82, japidviews\AdminController\manageLocation.html
		p(lookupStatic("/public/js/crud.js"));// line 83, japidviews\AdminController\manageLocation.html
		p("\"></script>\n" + 
"<script src=\"");// line 83, japidviews\AdminController\manageLocation.html
		p(lookupStatic("/public/js/paging.js"));// line 84, japidviews\AdminController\manageLocation.html
		p("\"></script>\n" + 
"<script src=\"");// line 84, japidviews\AdminController\manageLocation.html
		p(lookupStatic("/public/js/checkinput.js"));// line 85, japidviews\AdminController\manageLocation.html
		p("\"></script>\n" + 
"<script src=\"");// line 85, japidviews\AdminController\manageLocation.html
		p(lookupStatic("/public/js/back_location.js"));// line 86, japidviews\AdminController\manageLocation.html
		p("\"></script>");// line 86, japidviews\AdminController\manageLocation.html
		
		endDoLayout(sourceTemplate);
	}

}