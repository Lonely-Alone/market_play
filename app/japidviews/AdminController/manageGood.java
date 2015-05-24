//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import models.order.OrderSum;
import org.apache.commons.lang.StringUtils;
import models.enums.AdminMenu;
import models.goods.Good;
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
// NOTE: This file was generated from: japidviews/AdminController/manageGood.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class manageGood extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/manageGood.html";
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


	public manageGood() {
	super((StringBuilder)null);
	initHeaders();
	}
	public manageGood(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public manageGood(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"currName", "inSold", "goods", "goodCount", "pageCount", "page",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"String", "Boolean", "List<Good>", "int", "int", "int",  };
	public static final Object[] argDefaults= new Object[] {null,null,null,null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.manageGood.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private String currName; // line 8, japidviews/AdminController/manageGood.html
	private Boolean inSold; // line 8, japidviews/AdminController/manageGood.html
	private List<Good> goods; // line 8, japidviews/AdminController/manageGood.html
	private int goodCount; // line 8, japidviews/AdminController/manageGood.html
	private int pageCount; // line 8, japidviews/AdminController/manageGood.html
	private int page; // line 8, japidviews/AdminController/manageGood.html
	public cn.bran.japid.template.RenderResult render(String currName,Boolean inSold,List<Good> goods,int goodCount,int pageCount,int page) {
		this.currName = currName;
		this.inSold = inSold;
		this.goods = goods;
		this.goodCount = goodCount;
		this.pageCount = pageCount;
		this.page = page;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 8, japidviews/AdminController/manageGood.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(String currName,Boolean inSold,List<Good> goods,int goodCount,int pageCount,int page) {
		return new manageGood().render(currName, inSold, goods, goodCount, pageCount, page);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\manageGood.html
Map<Long, Long> map = OrderSum.getSoldCount(goods);// line 9, japidviews\AdminController\manageGood.html

p("<div class=\"content_page\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		");// line 11, japidviews\AdminController\manageGood.html
		new leftMenusTag(manageGood.this).render(AdminMenu.商品管理); // line 14, japidviews\AdminController\manageGood.html// line 14, japidviews\AdminController\manageGood.html
		p("        <section class=\"cell\">\n" + 
"			<nav class=\"nav_content_box fix\">\n" + 
"				<span class=\"l\">所有商品</span>\n" + 
"				<span class=\"r\">\n" + 
"	                显示：\n" + 
"	                <select id=\"goodFilter\">\n" + 
"	                	<option value=\"\" ");// line 14, japidviews\AdminController\manageGood.html
		p(inSold == null ? "selected" : "");// line 21, japidviews\AdminController\manageGood.html
		p(">全部</option>\n" + 
"	                	<option value=\"true\" ");// line 21, japidviews\AdminController\manageGood.html
		p(inSold != null ?(inSold ? "selected" : ""):"");// line 22, japidviews\AdminController\manageGood.html
		p(">在售</option>\n" + 
"	                	<option value=\"false\" ");// line 22, japidviews\AdminController\manageGood.html
		p(inSold != null ?(!inSold ? "selected" : ""):"");// line 23, japidviews\AdminController\manageGood.html
		p(">已下架</option>\n" + 
"	                </select>\n" + 
"                </span>\n" + 
"			</nav>\n" + 
"            <article class=\"mt10\">\n" + 
"            	<div class=\"p10 bgf9 bdc\">\n" + 
"					<div>\n" + 
"				    	宝贝名称：\n" + 
"				        <input id=\"searchNameInput\" class=\"mr20 input pct20\" type=\"text\" value=\"");// line 23, japidviews\AdminController\manageGood.html
		p(StringUtils.defaultIfBlank(currName, ""));// line 31, japidviews\AdminController\manageGood.html
		p("\"/>\n" + 
"				        <a id=\"searchGoodBtn\" class=\"bluebtn btn_s bdrad3 ml10\" href=\"javascript:;\">搜索</a>\n" + 
"				    </div>\n" + 
"				</div>\n" + 
"                <div class=\"p5 fix\">\n" + 
"                	<span class=\"l\">\n" + 
"                    	<input id=\"checkAllChk\" class=\"vn\" type=\"checkbox\" />\n" + 
"                        <a id=\"checkAllBtn\" href=\"javascript:;\">全选</a>\n" + 
"                        <a id=\"removeBtn\" class=\"ml10\" href=\"javascript:;\">删除</a>\n" + 
"                    </span>\n" + 
"                    <span class=\"r\">\n" + 
"                        商品总数：<span id=\"dataCount\" class=\"co\">");// line 31, japidviews\AdminController\manageGood.html
		p(goodCount);// line 42, japidviews\AdminController\manageGood.html
		p("</span>\n" + 
"                        个\n" + 
"                    </span>\n" + 
"                </div>\n" + 
"                <div class=\"mt10 mb5 p5 bgef bdc tc\">\n" + 
"                	<span class=\"dib pct30\">商品</span>\n" + 
"                	<span class=\"dib pct10\">编号</span>\n" + 
"                    <span class=\"dib pct10\">单价（元）</span>\n" + 
"                    <span class=\"dib2 pct10\">库存</span>\n" + 
"                    <span class=\"dib pct10\">已销量</span>\n" + 
"                    <span class=\"dib pct10\">发布时间</span> \n" + 
"                    <span class=\"dib pct10\">操作</span>       \n" + 
"                </div>\n" + 
"                <table width=\"100%\" class=\"bdc tc\" cellpadding=\"5\" cellspacing=\"0\">\n" + 
"                    <tbody>\n" + 
"                    	");// line 42, japidviews\AdminController\manageGood.html
		for(Good good : goods){// line 57, japidviews\AdminController\manageGood.html
		p("                    	<tr id=\"goodChk_");// line 57, japidviews\AdminController\manageGood.html
		p(good.id);// line 58, japidviews\AdminController\manageGood.html
		p("\" class=\"bgef tl\">\n" + 
"                            <td colspan=\"8\"><input class=\"jsForCheck\" type=\"checkbox\" data=\"");// line 58, japidviews\AdminController\manageGood.html
		p(good.id);// line 59, japidviews\AdminController\manageGood.html
		p("\"/></td>\n" + 
"                        </tr>\n" + 
"                        <tr id=\"good_");// line 59, japidviews\AdminController\manageGood.html
		p(good.id);// line 61, japidviews\AdminController\manageGood.html
		p("\">\n" + 
"                            <td class=\"pct30 tl fix\">\n" + 
"                            	<div class=\"w15 ml5 co l\">");// line 61, japidviews\AdminController\manageGood.html
		p(good.inSold?"售卖中":"已下架");// line 63, japidviews\AdminController\manageGood.html
		p("</div>\n" + 
"                                <img class=\"ml5 mr10 l\" width=\"50\" height=\"50\" src=\"");// line 63, japidviews\AdminController\manageGood.html
		p(getPictureFromPicServer(100, 100, Effect.FILL, good.previewURL));// line 64, japidviews\AdminController\manageGood.html
		p("\"/>\n" + 
"                                <div class=\"cell\">\n" + 
"                                    ");// line 64, japidviews\AdminController\manageGood.html
		p("\n" + 
"                                    <a class=\"previewGoodBtn\" href=\"javascript:;\" data=\"");// line 66, japidviews\AdminController\manageGood.html
		p(good.id);// line 67, japidviews\AdminController\manageGood.html
		p("\">");// line 67, japidviews\AdminController\manageGood.html
		p(good.name);// line 67, japidviews\AdminController\manageGood.html
		p("</a>\n" + 
"                                </div>\n" + 
"                            </td>\n" + 
"                            <td class=\"pct10\">");// line 67, japidviews\AdminController\manageGood.html
		p(good.goodSerial);// line 70, japidviews\AdminController\manageGood.html
		p("</td>\n" + 
"                            <td class=\"pct10\">");// line 70, japidviews\AdminController\manageGood.html
		p(formatNumber(good.realPrice/100.0, "0.00"));// line 71, japidviews\AdminController\manageGood.html
		p("</td>\n" + 
"                            <td class=\"pct10\">");// line 71, japidviews\AdminController\manageGood.html
		p(good.leftCount);// line 72, japidviews\AdminController\manageGood.html
		p("</td>\n" + 
"                            <td class=\"pct10\">");// line 72, japidviews\AdminController\manageGood.html
		p(null == map.get(good.id) ? 0 : map.get(good.id));// line 73, japidviews\AdminController\manageGood.html
		p("</td>\n" + 
"                            <td class=\"pct10\">");// line 73, japidviews\AdminController\manageGood.html
		p(formatDate(good.createTime, "yyyy-MM-dd HH:mm:ss"));// line 74, japidviews\AdminController\manageGood.html
		p("</td>\n" + 
"							<td class=\"pct10\">\n" + 
"                            	<a href=\"");// line 74, japidviews\AdminController\manageGood.html
		p(lookup("AdminController.editGood", good.id));// line 76, japidviews\AdminController\manageGood.html
		p("\">编辑</a>\n" + 
"                            </td>\n" + 
"                        </tr>\n" + 
"                    	");// line 76, japidviews\AdminController\manageGood.html
		}// line 79, japidviews\AdminController\manageGood.html
		p("                        <tr class=\"bgef tr\">\n" + 
"                        	<td class=\"p10\" colspan=\"8\">\n" + 
"                        		");// line 79, japidviews\AdminController\manageGood.html
		new pagesTag(manageGood.this).render(JapidPlayAdapter.lookup("AdminController.manageGood", currName),"page",page,pageCount); // line 82, japidviews\AdminController\manageGood.html// line 82, japidviews\AdminController\manageGood.html
		p("                            </td>\n" + 
"                        </tr>\n" + 
"                     </tbody>\n" + 
"            	</table>\n" + 
"            </article>\n" + 
"        </section>\n" + 
"	</div>\n" + 
"</div>\n");// line 82, japidviews\AdminController\manageGood.html
		new baseJSLinkTag(manageGood.this).render(); // line 91, japidviews\AdminController\manageGood.html// line 91, japidviews\AdminController\manageGood.html
new iboxJSLinkTag(manageGood.this).render(); // line 92, japidviews\AdminController\manageGood.html// line 92, japidviews\AdminController\manageGood.html
		p("<script src=\"");// line 92, japidviews\AdminController\manageGood.html
		p(lookupStatic("/public/js/min/powerFloat.js"));// line 93, japidviews\AdminController\manageGood.html
		p("\"></script>\n" + 
"<script src=\"");// line 93, japidviews\AdminController\manageGood.html
		p(lookupStatic("/public/js/min/testRemind.js"));// line 94, japidviews\AdminController\manageGood.html
		p("\"></script>\n" + 
"<script src=\"");// line 94, japidviews\AdminController\manageGood.html
		p(lookupStatic("/public/js/min/ajax.js"));// line 95, japidviews\AdminController\manageGood.html
		p("\"></script>\n" + 
"<script src=\"");// line 95, japidviews\AdminController\manageGood.html
		p(lookupStatic("/public/js/min/calendar.js"));// line 96, japidviews\AdminController\manageGood.html
		p("\"></script>\n" + 
"<script src=\"");// line 96, japidviews\AdminController\manageGood.html
		p(lookupStatic("/public/js/crud.js"));// line 97, japidviews\AdminController\manageGood.html
		p("\"></script>\n" + 
"<script src=\"");// line 97, japidviews\AdminController\manageGood.html
		p(lookupStatic("/public/js/paging.js"));// line 98, japidviews\AdminController\manageGood.html
		p("\"></script>\n" + 
"<script src=\"");// line 98, japidviews\AdminController\manageGood.html
		p(lookupStatic("/public/js/checkinput.js"));// line 99, japidviews\AdminController\manageGood.html
		p("\"></script>\n" + 
"<script src=\"");// line 99, japidviews\AdminController\manageGood.html
		p(lookupStatic("/public/js/back_good.js"));// line 100, japidviews\AdminController\manageGood.html
		p("\"></script>");// line 100, japidviews\AdminController\manageGood.html
		
		endDoLayout(sourceTemplate);
	}

}