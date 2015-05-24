//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import org.apache.commons.lang.StringUtils;
import models.enums.AdminMenu;
import cn.bran.play.JapidPlayAdapter;
import models.order.PayNotify;
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
// NOTE: This file was generated from: japidviews/AdminController/manageBill.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class manageBill extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/manageBill.html";
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


	public manageBill() {
	super((StringBuilder)null);
	initHeaders();
	}
	public manageBill(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public manageBill(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"payNotifies", "dateFrom", "dateTo", "page", "payCount", "pageCount",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"List<PayNotify>", "Date", "Date", "int", "int", "int",  };
	public static final Object[] argDefaults= new Object[] {null,null,null,null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.manageBill.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private List<PayNotify> payNotifies; // line 7, japidviews/AdminController/manageBill.html
	private Date dateFrom; // line 7, japidviews/AdminController/manageBill.html
	private Date dateTo; // line 7, japidviews/AdminController/manageBill.html
	private int page; // line 7, japidviews/AdminController/manageBill.html
	private int payCount; // line 7, japidviews/AdminController/manageBill.html
	private int pageCount; // line 7, japidviews/AdminController/manageBill.html
	public cn.bran.japid.template.RenderResult render(List<PayNotify> payNotifies,Date dateFrom,Date dateTo,int page,int payCount,int pageCount) {
		this.payNotifies = payNotifies;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.page = page;
		this.payCount = payCount;
		this.pageCount = pageCount;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 7, japidviews/AdminController/manageBill.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(List<PayNotify> payNotifies,Date dateFrom,Date dateTo,int page,int payCount,int pageCount) {
		return new manageBill().render(payNotifies, dateFrom, dateTo, page, payCount, pageCount);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\manageBill.html
// line 10, japidviews\AdminController\manageBill.html
		p("<div class=\"content_page\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		");// line 10, japidviews\AdminController\manageBill.html
		new leftMenusTag(manageBill.this).render(AdminMenu.进账流水); // line 13, japidviews\AdminController\manageBill.html// line 13, japidviews\AdminController\manageBill.html
		p("        <section class=\"cell\">\n" + 
"        	<nav class=\"pb10 fix\">\n" + 
"            	");// line 13, japidviews\AdminController\manageBill.html
		p("\n" + 
"            	<span class=\"r\">\n" + 
"            		从\n" + 
"                    <input id=\"dateFromInput\" class=\"w70 input\" type=\"text\" value=\"");// line 20, japidviews\AdminController\manageBill.html
		p(null == dateFrom ? "请选择时间" : formatDate(dateFrom, "yyyy-MM-dd"));// line 23, japidviews\AdminController\manageBill.html
		p("\" />\n" + 
"                    到\n" + 
"                    <input id=\"dateToInput\" class=\"w70 input mr5\" type=\"text\" value=\"");// line 23, japidviews\AdminController\manageBill.html
		p(null == dateTo ? "请选择时间" : formatDate(dateTo, "yyyy-MM-dd"));// line 25, japidviews\AdminController\manageBill.html
		p("\" />\n" + 
"                    <a id=\"searchBillBtn\" class=\"bluebtn btn_s bdrad3\" href=\"javascript:;\">搜索</a>\n" + 
"                </span>\n" + 
"            </nav>\n" + 
"            ");// line 25, japidviews\AdminController\manageBill.html
		if(payCount>0){// line 29, japidviews\AdminController\manageBill.html
		p("            <table class=\"sh_table\" cellpadding=\"5\" cellspacing=\"0\">\n" + 
"            	<thead>\n" + 
"                	<tr class=\"bgef tl\">\n" + 
"                    	<th>订单编号</th>\n" + 
"                        <th>交易号</th>\n" + 
"                        <th>总价</th>\n" + 
"                        <th>付款时间</th>\n" + 
"                    </tr>\n" + 
"                </thead>\n" + 
"                <tbody>\n" + 
"                	");// line 29, japidviews\AdminController\manageBill.html
		for(PayNotify pn : payNotifies){// line 40, japidviews\AdminController\manageBill.html
		p("                	<tr>\n" + 
"                    	<td><a href=\"");// line 40, japidviews\AdminController\manageBill.html
		p(lookup("AdminController.sumDetail", pn.out_trade_no));// line 42, japidviews\AdminController\manageBill.html
		p("\">");// line 42, japidviews\AdminController\manageBill.html
		p(pn.out_trade_no);// line 42, japidviews\AdminController\manageBill.html
		p("</a></td>\n" + 
"                        <td>");// line 42, japidviews\AdminController\manageBill.html
		p(pn.transaction_id);// line 43, japidviews\AdminController\manageBill.html
		p("</td>\n" + 
"                        <td>");// line 43, japidviews\AdminController\manageBill.html
		p(formatNumber(pn.total_fee/100.0, "0.00"));// line 44, japidviews\AdminController\manageBill.html
		p("元</td>\n" + 
"                        <td>");// line 44, japidviews\AdminController\manageBill.html
		p(pn.getFormatDate("yyyy-MM-dd HH:mm:ss"));// line 45, japidviews\AdminController\manageBill.html
		p("</td>\n" + 
"                    </tr>\n" + 
"                	");// line 45, japidviews\AdminController\manageBill.html
		}// line 47, japidviews\AdminController\manageBill.html
		p("                </tbody>\n" + 
"            </table>\n" + 
"            ");// line 47, japidviews\AdminController\manageBill.html
		if(pageCount > 1){// line 50, japidviews\AdminController\manageBill.html
		p("			<div class=\"tr p10\">\n" + 
"	        	");// line 50, japidviews\AdminController\manageBill.html
		new pagesTag(manageBill.this).render(JapidPlayAdapter.lookup("AdminController.manageBill", dateFrom, dateTo),"page",page,pageCount); // line 52, japidviews\AdminController\manageBill.html// line 52, japidviews\AdminController\manageBill.html
		p("	        </div>\n" + 
"            ");// line 52, japidviews\AdminController\manageBill.html
		}// line 54, japidviews\AdminController\manageBill.html
		p("            <div class=\"mt5 p5 bgef bdc\">\n" + 
"            	<span class=\"inline_three\">\n" + 
"                	总销售数量：\n" + 
"                	<span class=\"co\">");// line 54, japidviews\AdminController\manageBill.html
		p(PayNotify.getTotalAmount());// line 58, japidviews\AdminController\manageBill.html
		p("</span>\n" + 
"                    件\n" + 
"                </span>\n" + 
"            	<span class=\"ml70 inline_three\">\n" + 
"                	总销售额：\n" + 
"                	<span class=\"co\">");// line 58, japidviews\AdminController\manageBill.html
		p(formatNumber(PayNotify.getTotalFee()/100.0, "0.00"));// line 63, japidviews\AdminController\manageBill.html
		p("</span>\n" + 
"                    元	\n" + 
"                </span>\n" + 
"            </div>\n" + 
"            ");// line 63, japidviews\AdminController\manageBill.html
		}else{// line 67, japidviews\AdminController\manageBill.html
		p("            	暂无进账记录。\n" + 
"            ");// line 67, japidviews\AdminController\manageBill.html
		}// line 69, japidviews\AdminController\manageBill.html
		p("        </section>\n" + 
"   	</div>\n" + 
"</div>\n");// line 69, japidviews\AdminController\manageBill.html
		new baseJSLinkTag(manageBill.this).render(); // line 73, japidviews\AdminController\manageBill.html// line 73, japidviews\AdminController\manageBill.html
new iboxJSLinkTag(manageBill.this).render(); // line 74, japidviews\AdminController\manageBill.html// line 74, japidviews\AdminController\manageBill.html
		p("<script src=\"");// line 74, japidviews\AdminController\manageBill.html
		p(lookupStatic("/public/js/min/powerFloat.js"));// line 75, japidviews\AdminController\manageBill.html
		p("\"></script>\n" + 
"<script src=\"");// line 75, japidviews\AdminController\manageBill.html
		p(lookupStatic("/public/js/min/testRemind.js"));// line 76, japidviews\AdminController\manageBill.html
		p("\"></script>\n" + 
"<script src=\"");// line 76, japidviews\AdminController\manageBill.html
		p(lookupStatic("/public/js/min/ajax.js"));// line 77, japidviews\AdminController\manageBill.html
		p("\"></script>\n" + 
"<script src=\"");// line 77, japidviews\AdminController\manageBill.html
		p(lookupStatic("/public/js/min/calendar.js"));// line 78, japidviews\AdminController\manageBill.html
		p("\"></script>\n" + 
"<script src=\"");// line 78, japidviews\AdminController\manageBill.html
		p(lookupStatic("/public/js/paging.js"));// line 79, japidviews\AdminController\manageBill.html
		p("\"></script>\n" + 
"<script src=\"");// line 79, japidviews\AdminController\manageBill.html
		p(lookupStatic("/public/js/back.js"));// line 80, japidviews\AdminController\manageBill.html
		p("\"></script>\n");// line 80, japidviews\AdminController\manageBill.html
		
		endDoLayout(sourceTemplate);
	}

	@Override protected void title() {
		// line 10, japidviews\AdminController\manageBill.html
		p("进账流水");// line 10, japidviews\AdminController\manageBill.html
		;
	}
}