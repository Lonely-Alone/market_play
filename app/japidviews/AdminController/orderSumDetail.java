//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import models.order.OrderSum;
import org.apache.commons.lang.StringUtils;
import utils.PictureUtil;
import utils.PictureUtil.Effect;
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
// NOTE: This file was generated from: japidviews/AdminController/orderSumDetail.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class orderSumDetail extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/orderSumDetail.html";
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


	public orderSumDetail() {
	super((StringBuilder)null);
	initHeaders();
	}
	public orderSumDetail(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public orderSumDetail(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"sum", "items",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"OrderSum", "List<OrderItem>",  };
	public static final Object[] argDefaults= new Object[] {null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.orderSumDetail.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private OrderSum sum; // line 8, japidviews/AdminController/orderSumDetail.html
	private List<OrderItem> items; // line 8, japidviews/AdminController/orderSumDetail.html
	public cn.bran.japid.template.RenderResult render(OrderSum sum,List<OrderItem> items) {
		this.sum = sum;
		this.items = items;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 8, japidviews/AdminController/orderSumDetail.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(OrderSum sum,List<OrderItem> items) {
		return new orderSumDetail().render(sum, items);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\orderSumDetail.html

OrderStatus status = sum.getStatus();// line 10, japidviews\AdminController\orderSumDetail.html
// line 12, japidviews\AdminController\orderSumDetail.html
		p("<div class=\"content_page\">\n" + 
"	<div class=\"constr\">\n" + 
"    	<div class=\"send_area\">\n" + 
"        	<div class=\"fix\">\n" + 
"            	<h3 class=\"l\">当前订单状态：");// line 12, japidviews\AdminController\orderSumDetail.html
		p(status.getDescription());// line 17, japidviews\AdminController\orderSumDetail.html
		p("</h3>\n" + 
"            	");// line 17, japidviews\AdminController\orderSumDetail.html
		if(status == OrderStatus.NOT_PAID){// line 18, japidviews\AdminController\orderSumDetail.html
		p("            		<a id=\"cancelBtn\" href=\"javascript:;\" class=\"bluebtn btn_m r\" data=\"");// line 18, japidviews\AdminController\orderSumDetail.html
		p(sum.id);// line 19, japidviews\AdminController\orderSumDetail.html
		p("\">取消订单</a>\n" + 
"            	");// line 19, japidviews\AdminController\orderSumDetail.html
		}else if(status == OrderStatus.NOT_DELIVERED){// line 20, japidviews\AdminController\orderSumDetail.html
		p("            	");// line 20, japidviews\AdminController\orderSumDetail.html
		p("\n" + 
"            		");// line 21, japidviews\AdminController\orderSumDetail.html
		p("\n" + 
"                	<a id=\"deliverBtn\" href=\"javascript:;\" class=\"bluebtn btn_m r mr10\" data=\"");// line 22, japidviews\AdminController\orderSumDetail.html
		p(sum.id);// line 23, japidviews\AdminController\orderSumDetail.html
		p("\">发货</a>\n" + 
"            	");// line 23, japidviews\AdminController\orderSumDetail.html
		}// line 24, japidviews\AdminController\orderSumDetail.html
		p("            </div>\n" + 
"        	<div class=\"mt10\">\n" + 
"            	<h4>备注：</h4> \n" + 
"                <textarea class=\"mt10 textarea pct98\" cols=\"5\">");// line 24, japidviews\AdminController\orderSumDetail.html
		p(sum.memo);// line 28, japidviews\AdminController\orderSumDetail.html
		p("</textarea>\n" + 
"            </div>\n" + 
"        </div>\n" + 
"        <div class=\"p20 lh20\">\n" + 
"        	<h3>订单信息</h3>\n" + 
"            <div class=\"mt10 inline_two\">\n" + 
"            	<p>\n" + 
"            	买家：&nbsp;");// line 28, japidviews\AdminController\orderSumDetail.html
		p(sum.owner.nickName());// line 35, japidviews\AdminController\orderSumDetail.html
		p("\n" + 
"                </p>\n" + 
"                <p>\n" + 
"                    收货地址：&nbsp;\n" + 
"                    ");// line 35, japidviews\AdminController\orderSumDetail.html
		p(sum.addressName);// line 39, japidviews\AdminController\orderSumDetail.html
		p("，");// line 39, japidviews\AdminController\orderSumDetail.html
		p(sum.addressCellphone);// line 39, japidviews\AdminController\orderSumDetail.html
		p("，\n" + 
"                </p>\n" + 
"                <p class=\"pl20 ml45\">\n" + 
"                    ");// line 39, japidviews\AdminController\orderSumDetail.html
		p(sum.addressAddress);// line 42, japidviews\AdminController\orderSumDetail.html
		p("，");// line 42, japidviews\AdminController\orderSumDetail.html
		p(sum.addressPostCode);// line 42, japidviews\AdminController\orderSumDetail.html
		p("\n" + 
"                </p>\n" + 
"                <p>付款方式：<span class=\"co\">");// line 42, japidviews\AdminController\orderSumDetail.html
		p(null == sum.payMode ? "尚未付款" : sum.payMode);// line 44, japidviews\AdminController\orderSumDetail.html
		p("</span></p>\n" + 
"            </div>\n" + 
"            <div class=\"inline_two\">\n" + 
"            	<p>订单编号：");// line 44, japidviews\AdminController\orderSumDetail.html
		p(StringUtils.defaultIfBlank(sum.orderSerial, sum.id+""));// line 47, japidviews\AdminController\orderSumDetail.html
		p("</p>\n" + 
"                <p>成交时间：");// line 47, japidviews\AdminController\orderSumDetail.html
		p(formatDate(sum.createTime, "yyyy-MM-dd HH:mm:ss"));// line 48, japidviews\AdminController\orderSumDetail.html
		p("</p>\n" + 
"            </div>\n" + 
"        </div>\n" + 
"        <table class=\"sh_table tc\" cellpadding=\"8\" cellspacing=\"0\">\n" + 
"        	<thead>\n" + 
"            	<tr class=\"bgef\">\n" + 
"                	<th class=\"pct70 fix\">\n" + 
"                		<div class=\"pct50 l\">商品</div>\n" + 
"                		<div class=\"pct20 l\">数量</div>\n" + 
"                		<div class=\"pct20 l\">价格</div>\n" + 
"                	</th>\n" + 
"                    <th>状态</th>\n" + 
"                    <th>总价</th>\n" + 
"                    <th>实付款</th>\n" + 
"                </tr>\n" + 
"            </thead>\n" + 
"            <tbody>\n" + 
"            	<tr>\n" + 
"                	<td class=\"pct70\">\n" + 
"                	");// line 48, japidviews\AdminController\orderSumDetail.html
		for(OrderItem item : items){// line 67, japidviews\AdminController\orderSumDetail.html
		p("                		<div class=\"pb10 fix\">\n" + 
"                			<div class=\"pct50 l\">\n" + 
"                				<div class=\"fix\">\n" + 
"	                    			<img class=\"l mr10\" width=\"50\" height=\"50\" src=\"");// line 67, japidviews\AdminController\orderSumDetail.html
		p(getPictureFromPicServer(100, 100, Effect.FILL, item.good.previewURL));// line 71, japidviews\AdminController\orderSumDetail.html
		p("\"/>\n" + 
"	                        		<a class=\"l\" href=\"javascript:;\" data=\"");// line 71, japidviews\AdminController\orderSumDetail.html
		p(item.good.id);// line 72, japidviews\AdminController\orderSumDetail.html
		p("\" id=\"showdetail\">");// line 72, japidviews\AdminController\orderSumDetail.html
		p(item.good.name);// line 72, japidviews\AdminController\orderSumDetail.html
		p("</a>\n" + 
"	                        	</div>\n" + 
"	                        </div>\n" + 
"	                        <div class=\"pct20 l\">");// line 72, japidviews\AdminController\orderSumDetail.html
		p(formatNumber(item.good.realPrice/100.0, "0.00"));// line 75, japidviews\AdminController\orderSumDetail.html
		p("</div>\n" + 
"	                    	<div class=\"pct20 l\">");// line 75, japidviews\AdminController\orderSumDetail.html
		p(item.amount);// line 76, japidviews\AdminController\orderSumDetail.html
		p("</div>\n" + 
"                    	</div>\n" + 
"                    ");// line 76, japidviews\AdminController\orderSumDetail.html
		}// line 78, japidviews\AdminController\orderSumDetail.html
		p("                    </td>                       \n" + 
"                    <td rowspan=\"");// line 78, japidviews\AdminController\orderSumDetail.html
		p(items.size());// line 80, japidviews\AdminController\orderSumDetail.html
		p("\"><span class=\"co\">");// line 80, japidviews\AdminController\orderSumDetail.html
		p(sum.getStatus().cnName());// line 80, japidviews\AdminController\orderSumDetail.html
		p("</span></td>\n" + 
"                    <td rowspan=\"");// line 80, japidviews\AdminController\orderSumDetail.html
		p(items.size());// line 81, japidviews\AdminController\orderSumDetail.html
		p("\">");// line 81, japidviews\AdminController\orderSumDetail.html
		p(formatNumber(sum.sumPrice/100.0, "0.00"));// line 81, japidviews\AdminController\orderSumDetail.html
		p("</td>\n" + 
"                    <td rowspan=\"");// line 81, japidviews\AdminController\orderSumDetail.html
		p(items.size());// line 82, japidviews\AdminController\orderSumDetail.html
		p("\">");// line 82, japidviews\AdminController\orderSumDetail.html
		p(formatNumber(sum.getCost()/100.0, "0.00"));// line 82, japidviews\AdminController\orderSumDetail.html
		p("</td>\n" + 
"                </tr>\n" + 
"            	\n" + 
"            </tbody>\n" + 
"        </table>\n" + 
"    </div>\n" + 
"</div>\n");// line 82, japidviews\AdminController\orderSumDetail.html
		new baseJSLinkTag(orderSumDetail.this).render(); // line 89, japidviews\AdminController\orderSumDetail.html// line 89, japidviews\AdminController\orderSumDetail.html
new iboxJSLinkTag(orderSumDetail.this).render(); // line 90, japidviews\AdminController\orderSumDetail.html// line 90, japidviews\AdminController\orderSumDetail.html
		p("<script src=\"");// line 90, japidviews\AdminController\orderSumDetail.html
		p(lookupStatic("/public/js/min/powerFloat.js"));// line 91, japidviews\AdminController\orderSumDetail.html
		p("\"></script>\n" + 
"<script src=\"");// line 91, japidviews\AdminController\orderSumDetail.html
		p(lookupStatic("/public/js/min/testRemind.js"));// line 92, japidviews\AdminController\orderSumDetail.html
		p("\"></script>\n" + 
"<script src=\"");// line 92, japidviews\AdminController\orderSumDetail.html
		p(lookupStatic("/public/js/min/ajax.js"));// line 93, japidviews\AdminController\orderSumDetail.html
		p("\"></script>\n" + 
"<script src=\"");// line 93, japidviews\AdminController\orderSumDetail.html
		p(lookupStatic("/public/js/back_order.js"));// line 94, japidviews\AdminController\orderSumDetail.html
		p("\"></script>");// line 94, japidviews\AdminController\orderSumDetail.html
		
		endDoLayout(sourceTemplate);
	}

	@Override protected void title() {
		// line 12, japidviews\AdminController\orderSumDetail.html
		p("订单详情");// line 12, japidviews\AdminController\orderSumDetail.html
		;
	}
}