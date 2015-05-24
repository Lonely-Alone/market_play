//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import models.order.OrderSum;
import org.apache.commons.lang.StringUtils;
import models.enums.AdminMenu;
import utils.PictureUtil;
import utils.PictureUtil.Effect;
import cn.bran.play.JapidPlayAdapter;
import models.enums.OrderStatus;
import models.order.OrderItem;
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
// NOTE: This file was generated from: japidviews/AdminController/manageOrderSum.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class manageOrderSum extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/manageOrderSum.html";
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


	public manageOrderSum() {
	super((StringBuilder)null);
	initHeaders();
	}
	public manageOrderSum(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public manageOrderSum(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"orderSums", "map", "currStatus", "goodName", "orderSerial", "dateFrom", "dateTo", "sumCount", "pageCount", "page",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"List<OrderSum>", "Map<Long, List<OrderItem>>", "OrderStatus", "String", "String", "Date", "Date", "int", "int", "int",  };
	public static final Object[] argDefaults= new Object[] {null,null,null,null,null,null,null,null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.manageOrderSum.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private List<OrderSum> orderSums; // line 10, japidviews/AdminController/manageOrderSum.html
	private Map<Long, List<OrderItem>> map; // line 10, japidviews/AdminController/manageOrderSum.html
	private OrderStatus currStatus; // line 10, japidviews/AdminController/manageOrderSum.html
	private String goodName; // line 10, japidviews/AdminController/manageOrderSum.html
	private String orderSerial; // line 10, japidviews/AdminController/manageOrderSum.html
	private Date dateFrom; // line 10, japidviews/AdminController/manageOrderSum.html
	private Date dateTo; // line 10, japidviews/AdminController/manageOrderSum.html
	private int sumCount; // line 10, japidviews/AdminController/manageOrderSum.html
	private int pageCount; // line 10, japidviews/AdminController/manageOrderSum.html
	private int page; // line 10, japidviews/AdminController/manageOrderSum.html
	public cn.bran.japid.template.RenderResult render(List<OrderSum> orderSums,Map<Long, List<OrderItem>> map,OrderStatus currStatus,String goodName,String orderSerial,Date dateFrom,Date dateTo,int sumCount,int pageCount,int page) {
		this.orderSums = orderSums;
		this.map = map;
		this.currStatus = currStatus;
		this.goodName = goodName;
		this.orderSerial = orderSerial;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.sumCount = sumCount;
		this.pageCount = pageCount;
		this.page = page;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 10, japidviews/AdminController/manageOrderSum.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(List<OrderSum> orderSums,Map<Long, List<OrderItem>> map,OrderStatus currStatus,String goodName,String orderSerial,Date dateFrom,Date dateTo,int sumCount,int pageCount,int page) {
		return new manageOrderSum().render(orderSums, map, currStatus, goodName, orderSerial, dateFrom, dateTo, sumCount, pageCount, page);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\manageOrderSum.html

p("<div class=\"content_page\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		");// line 12, japidviews\AdminController\manageOrderSum.html
		new leftMenusTag(manageOrderSum.this).render(AdminMenu.订单管理); // line 15, japidviews\AdminController\manageOrderSum.html// line 15, japidviews\AdminController\manageOrderSum.html
		p("        <section class=\"cell\">\n" + 
"        	<nav class=\"nav_content_box fix\">\n" + 
"				<span class=\"l\">所有订单</span>\n" + 
"				<span class=\"r\">\n" + 
"	                订单状态：\n" + 
"	                <select id=\"orderFilter\">\n" + 
"	                	");// line 15, japidviews\AdminController\manageOrderSum.html
		for(OrderStatus status : OrderStatus.values()){// line 22, japidviews\AdminController\manageOrderSum.html
		p("	                		<option value=\"");// line 22, japidviews\AdminController\manageOrderSum.html
		p(status);// line 23, japidviews\AdminController\manageOrderSum.html
		p("\" ");// line 23, japidviews\AdminController\manageOrderSum.html
		p(status == currStatus ? "selected" : "");// line 23, japidviews\AdminController\manageOrderSum.html
		p(">");// line 23, japidviews\AdminController\manageOrderSum.html
		p(status.cnName());// line 23, japidviews\AdminController\manageOrderSum.html
		p("</option>\n" + 
"	                	");// line 23, japidviews\AdminController\manageOrderSum.html
		}// line 24, japidviews\AdminController\manageOrderSum.html
		p("	                </select>\n" + 
"                </span>\n" + 
"			</nav>\n" + 
"            <article class=\"mt10\">\n" + 
"            	<div class=\"p10 bgf9 bdc\">\n" + 
"                	<div>\n" + 
"                    	宝贝名称：\n" + 
"                        <input id=\"goodNameInput\" class=\"mr20 input pct20\" type=\"text\" value=\"");// line 24, japidviews\AdminController\manageOrderSum.html
		p(StringUtils.defaultIfBlank(goodName, ""));// line 32, japidviews\AdminController\manageOrderSum.html
		p("\"/>\n" + 
"                    	订单编号：\n" + 
"                        <input id=\"orderSerialInput\" class=\"mr20 input pct15\" type=\"text\" value=\"");// line 32, japidviews\AdminController\manageOrderSum.html
		p(StringUtils.defaultIfBlank(orderSerial, ""));// line 34, japidviews\AdminController\manageOrderSum.html
		p("\" />\n" + 
"                        成交时间：\n" + 
"                        从\n" + 
"                        <input id=\"dateFromInput\" class=\"w70 input\" type=\"text\" value=\"");// line 34, japidviews\AdminController\manageOrderSum.html
		p(null == dateFrom ? "请选择时间" : formatDate(dateFrom, "yyyy-MM-dd"));// line 37, japidviews\AdminController\manageOrderSum.html
		p("\" />\n" + 
"                        到\n" + 
"                        <input id=\"dateToInput\" class=\"w70 input mr20\" type=\"text\" value=\"");// line 37, japidviews\AdminController\manageOrderSum.html
		p(null == dateTo ? "请选择时间" : formatDate(dateTo, "yyyy-MM-dd"));// line 39, japidviews\AdminController\manageOrderSum.html
		p("\" />\n" + 
"                        <a id=\"searchOrderBtn\" class=\"bluebtn btn_s bdrad3\" href=\"javascript:;\">搜索</a>\n" + 
"                    </div>\n" + 
"                </div>\n" + 
"                <div class=\"mt10 p5 fix\">\n" + 
"                    <span class=\"r\">\n" + 
"                        订单总数：<span id=\"dataCount\" class=\"co\">");// line 39, japidviews\AdminController\manageOrderSum.html
		p(sumCount);// line 45, japidviews\AdminController\manageOrderSum.html
		p("</span>&nbsp;个\n" + 
"                    </span>\n" + 
"                </div>\n" + 
"                <div class=\"p5 bgef bdc\">\n" + 
"                	<span class=\"inline_six\">订单号</span>\n" + 
"                	<span class=\"inline_six\">商铺</span>\n" + 
"                    <span class=\"inline_six\">成交时间</span>\n" + 
"                    <span class=\"inline_six\">买家</span>\n" + 
"                    <span class=\"inline_six\">交易状态</span>\n" + 
"                    <span class=\"inline_six\">积分抵款（元）</span> \n" + 
"                    <span class=\"inline_six\">实收款（元）</span>       \n" + 
"                </div>\n" + 
"                ");// line 45, japidviews\AdminController\manageOrderSum.html
		for(OrderSum sum : orderSums){// line 57, japidviews\AdminController\manageOrderSum.html
                	OrderStatus status = sum.getStatus();// line 58, japidviews\AdminController\manageOrderSum.html
		p("		            <div class=\"mt10 bdc\">\n" + 
"	                	<div class=\"p5 bgf9\">\n" + 
"	                    	<span class=\"inline_six\"><a href=\"");// line 58, japidviews\AdminController\manageOrderSum.html
		p(lookup("AdminController.orderSumDetail", sum.id));// line 61, japidviews\AdminController\manageOrderSum.html
		p("\">");// line 61, japidviews\AdminController\manageOrderSum.html
		p(StringUtils.defaultIfBlank(sum.orderSerial, sum.id+""));// line 61, japidviews\AdminController\manageOrderSum.html
		p("</a></span>\n" + 
"	                        <span class=\"inline_six\"></span>\n" + 
"	                        <span class=\"inline_six\">");// line 61, japidviews\AdminController\manageOrderSum.html
		p(formatDate(sum.createTime, "yyyy-MM-dd HH:mm"));// line 63, japidviews\AdminController\manageOrderSum.html
		p("</span>\n" + 
"	                        <span class=\"inline_six\">");// line 63, japidviews\AdminController\manageOrderSum.html
		p(sum.owner!=null?sum.owner.nickName():"");// line 64, japidviews\AdminController\manageOrderSum.html
		p("</span>\n" + 
"	                        <span class=\"inline_six ");// line 64, japidviews\AdminController\manageOrderSum.html
		p(status.fontColor());// line 65, japidviews\AdminController\manageOrderSum.html
		p("\">");// line 65, japidviews\AdminController\manageOrderSum.html
		p(status.cnName());// line 65, japidviews\AdminController\manageOrderSum.html
		p("</span>	\n" + 
"	                         <span class=\"inline_six ");// line 65, japidviews\AdminController\manageOrderSum.html
		p(status.fontColor());// line 66, japidviews\AdminController\manageOrderSum.html
		p("\">");// line 66, japidviews\AdminController\manageOrderSum.html
		p(formatNumber(sum.points/100.0, "0.00"));// line 66, japidviews\AdminController\manageOrderSum.html
		p("</span>\n" + 
"	                        <span class=\"inline_six\">");// line 66, japidviews\AdminController\manageOrderSum.html
		p(formatNumber(sum.getCost()/100.0, "0.00"));// line 67, japidviews\AdminController\manageOrderSum.html
		p("</span> \n" + 
"	                    </div>\n" + 
"	                    ");// line 67, japidviews\AdminController\manageOrderSum.html
		for(OrderItem item : map.get(sum.id)){// line 69, japidviews\AdminController\manageOrderSum.html
		p("	                    <div class=\"p5 fix\">\n" + 
"	                    	<img class=\"mr10 vm\" width=\"30\" height=\"30\" src=\"");// line 69, japidviews\AdminController\manageOrderSum.html
		p(getPictureFromPicServer(60, 60, Effect.FILL, item.good.previewURL));// line 71, japidviews\AdminController\manageOrderSum.html
		p("\"/>\n" + 
"	                        ");// line 71, japidviews\AdminController\manageOrderSum.html
		p("\n" + 
"	                        <span>");// line 72, japidviews\AdminController\manageOrderSum.html
		p(item.good.name);// line 73, japidviews\AdminController\manageOrderSum.html
		p("</span>\n" + 
"	                    </div>             \n" + 
"	                    ");// line 73, japidviews\AdminController\manageOrderSum.html
		}// line 75, japidviews\AdminController\manageOrderSum.html
		p("	                </div>\n" + 
"                ");// line 75, japidviews\AdminController\manageOrderSum.html
		}// line 77, japidviews\AdminController\manageOrderSum.html
		p("                <div class=\"tr p10\">\n" + 
"                	");// line 77, japidviews\AdminController\manageOrderSum.html
		new pagesTag(manageOrderSum.this).render(JapidPlayAdapter.lookup("AdminController.manageOrderSum", currStatus, goodName, orderSerial, dateFrom, dateTo),"page",page,pageCount); // line 79, japidviews\AdminController\manageOrderSum.html// line 79, japidviews\AdminController\manageOrderSum.html
		p("                </div>\n" + 
"            </article>\n" + 
"        </section>\n" + 
"   	</div>\n" + 
"</div>\n");// line 79, japidviews\AdminController\manageOrderSum.html
		new baseJSLinkTag(manageOrderSum.this).render(); // line 85, japidviews\AdminController\manageOrderSum.html// line 85, japidviews\AdminController\manageOrderSum.html
new iboxJSLinkTag(manageOrderSum.this).render(); // line 86, japidviews\AdminController\manageOrderSum.html// line 86, japidviews\AdminController\manageOrderSum.html
		p("<script src=\"");// line 86, japidviews\AdminController\manageOrderSum.html
		p(lookupStatic("/public/js/min/powerFloat.js"));// line 87, japidviews\AdminController\manageOrderSum.html
		p("\"></script>\n" + 
"<script src=\"");// line 87, japidviews\AdminController\manageOrderSum.html
		p(lookupStatic("/public/js/min/testRemind.js"));// line 88, japidviews\AdminController\manageOrderSum.html
		p("\"></script>\n" + 
"<script src=\"");// line 88, japidviews\AdminController\manageOrderSum.html
		p(lookupStatic("/public/js/min/ajax.js"));// line 89, japidviews\AdminController\manageOrderSum.html
		p("\"></script>\n" + 
"<script src=\"");// line 89, japidviews\AdminController\manageOrderSum.html
		p(lookupStatic("/public/js/min/calendar.js"));// line 90, japidviews\AdminController\manageOrderSum.html
		p("\"></script>\n" + 
"<script src=\"");// line 90, japidviews\AdminController\manageOrderSum.html
		p(lookupStatic("/public/js/paging.js"));// line 91, japidviews\AdminController\manageOrderSum.html
		p("\"></script>\n" + 
"<script src=\"");// line 91, japidviews\AdminController\manageOrderSum.html
		p(lookupStatic("/public/js/back_order.js"));// line 92, japidviews\AdminController\manageOrderSum.html
		p("\"></script>\n");// line 92, japidviews\AdminController\manageOrderSum.html
		
		endDoLayout(sourceTemplate);
	}

}