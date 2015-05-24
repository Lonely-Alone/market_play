//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import org.apache.commons.lang.StringUtils;
import models.enums.AdminMenu;
import cn.bran.play.JapidPlayAdapter;
import models.person.Member;
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
// NOTE: This file was generated from: japidviews/AdminController/manageVIP.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class manageVIP extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/manageVIP.html";
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


	public manageVIP() {
	super((StringBuilder)null);
	initHeaders();
	}
	public manageVIP(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public manageVIP(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"members", "nickName", "page", "pageCount", "memberCount",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"List<Member>", "String", "int", "int", "int",  };
	public static final Object[] argDefaults= new Object[] {null,null,null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.manageVIP.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private List<Member> members; // line 7, japidviews/AdminController/manageVIP.html
	private String nickName; // line 7, japidviews/AdminController/manageVIP.html
	private int page; // line 7, japidviews/AdminController/manageVIP.html
	private int pageCount; // line 7, japidviews/AdminController/manageVIP.html
	private int memberCount; // line 7, japidviews/AdminController/manageVIP.html
	public cn.bran.japid.template.RenderResult render(List<Member> members,String nickName,int page,int pageCount,int memberCount) {
		this.members = members;
		this.nickName = nickName;
		this.page = page;
		this.pageCount = pageCount;
		this.memberCount = memberCount;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 7, japidviews/AdminController/manageVIP.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(List<Member> members,String nickName,int page,int pageCount,int memberCount) {
		return new manageVIP().render(members, nickName, page, pageCount, memberCount);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\manageVIP.html

p("<div class=\"content_page\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		");// line 9, japidviews\AdminController\manageVIP.html
		new leftMenusTag(manageVIP.this).render(AdminMenu.会员管理); // line 12, japidviews\AdminController\manageVIP.html// line 12, japidviews\AdminController\manageVIP.html
		p("        <section class=\"cell\">\n" + 
"        	<div class=\"tr\">\n" + 
"            	昵称\n" + 
"            	<input id=\"nickNameInput\" class=\"ml5 mr5 input pct15\" type=\"text\" value=\"");// line 12, japidviews\AdminController\manageVIP.html
		p(StringUtils.defaultIfBlank(nickName, ""));// line 16, japidviews\AdminController\manageVIP.html
		p("\"/>\n" + 
"                <a id=\"searchVIPBtn\" class=\"bluebtn btn_s bdrad3\" href=\"javascript:;\">搜索</a>\n" + 
"            </div>\n" + 
"            <div class=\"mt10 p5 bgef bdc fix\">\n" + 
"            	<span class=\"l\">\n" + 
"                	");// line 16, japidviews\AdminController\manageVIP.html
		p("\n" + 
"                </span>\n" + 
"            	<span class=\"r\">\n" + 
"                	会员总数：\n" + 
"                	<span class=\"co\">");// line 23, japidviews\AdminController\manageVIP.html
		p(memberCount);// line 27, japidviews\AdminController\manageVIP.html
		p("</span>\n" + 
"                    个\n" + 
"                    <span class=\"ml20\">100个积分兑换1元人民币</span>\n" + 
"                </span>\n" + 
"            </div>\n" + 
"            <table class=\"mt10 sh_table tc\" cellpadding=\"5\" cellspacing=\"0\">\n" + 
"            	<thead>\n" + 
"                	<tr class=\"bgf9\">\n" + 
"                        <th class=\"tl\">会员ID</th>\n" + 
"                        <th>会员昵称</th>\n" + 
"                        <th>会员总积分</th>\n" + 
"                        <th>会员积分排名</th>\n" + 
"                        <th>会员等级</th>\n" + 
"                        <th>可用积分</th>\n" + 
"                        <th>积分兑换金额</th>\n" + 
"                    </tr>\n" + 
"                </thead>\n" + 
"                <tbody>\n" + 
"                	");// line 27, japidviews\AdminController\manageVIP.html
		for(Member member : members){// line 45, japidviews\AdminController\manageVIP.html
		p("                	<tr>\n" + 
"                        <td class=\"tl\">");// line 45, japidviews\AdminController\manageVIP.html
		p(member.vipSerial());// line 47, japidviews\AdminController\manageVIP.html
		p("</td>\n" + 
"                        <td class=\"g9\">");// line 47, japidviews\AdminController\manageVIP.html
		p(member.nickName());// line 48, japidviews\AdminController\manageVIP.html
		p("</td>\n" + 
"                        <td>");// line 48, japidviews\AdminController\manageVIP.html
		p(member.totalPoints);// line 49, japidviews\AdminController\manageVIP.html
		p("</td>\n" + 
"                        <td>");// line 49, japidviews\AdminController\manageVIP.html
		p(Member.getRank(member));// line 50, japidviews\AdminController\manageVIP.html
		p("</td>\n" + 
"                        <td class=\"vip");// line 50, japidviews\AdminController\manageVIP.html
		p(member.getLevel());// line 51, japidviews\AdminController\manageVIP.html
		p("\">VIP");// line 51, japidviews\AdminController\manageVIP.html
		p(member.getLevel());// line 51, japidviews\AdminController\manageVIP.html
		p("</td>\n" + 
"                        <td>");// line 51, japidviews\AdminController\manageVIP.html
		p(member.points);// line 52, japidviews\AdminController\manageVIP.html
		p("</td>\n" + 
"                        <td>");// line 52, japidviews\AdminController\manageVIP.html
		p(formatNumber(member.getPointsExchange(), "0.00"));// line 53, japidviews\AdminController\manageVIP.html
		p("</td>\n" + 
"                    </tr>\n" + 
"                	");// line 53, japidviews\AdminController\manageVIP.html
		}// line 55, japidviews\AdminController\manageVIP.html
		p("                </tbody>\n" + 
"            </table>\n" + 
"            <div class=\"tr p10\">\n" + 
"            	");// line 55, japidviews\AdminController\manageVIP.html
		new pagesTag(manageVIP.this).render(JapidPlayAdapter.lookup("AdminController.manageVIP", nickName),"page",page,pageCount); // line 59, japidviews\AdminController\manageVIP.html// line 59, japidviews\AdminController\manageVIP.html
		p("            </div>\n" + 
"            <div class=\"mt10\">\n" + 
"            	等级设定：\n" + 
"                <p class=\"ml63\">\n" + 
"                	0~4999<span class=\"ml25 pl10\">LV1</span>\n" + 
"                </p>\n" + 
"                <p class=\"ml63\">\n" + 
"                	5000~14999&nbsp&nbsp&nbsp<span class=\"ml20\">LV2</span>\n" + 
"                </p>\n" + 
"                <p class=\"ml63\">\n" + 
"                	15000~29999&nbsp<span class=\"ml20\">LV3</span>\n" + 
"                </p>\n" + 
"                <p class=\"ml63\">\n" + 
"                	30000~49999&nbsp;<span class=\"ml20\">LV4</span>\n" + 
"                </p>\n" + 
"                <p class=\"ml63\">\n" + 
"                	50000~99999&nbsp<span class=\"ml20\">LV5</span>\n" + 
"                </p>\n" + 
"                <p class=\"ml63\">\n" + 
"                	1000000~ &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span class=\"ml20\">LV6</span>\n" + 
"                </p>\n" + 
"            </div>\n" + 
"        </section>\n" + 
"   	</div>\n" + 
"</div>\n");// line 59, japidviews\AdminController\manageVIP.html
		new baseJSLinkTag(manageVIP.this).render(); // line 85, japidviews\AdminController\manageVIP.html// line 85, japidviews\AdminController\manageVIP.html
new iboxJSLinkTag(manageVIP.this).render(); // line 86, japidviews\AdminController\manageVIP.html// line 86, japidviews\AdminController\manageVIP.html
		p("<script src=\"");// line 86, japidviews\AdminController\manageVIP.html
		p(lookupStatic("/public/js/min/powerFloat.js"));// line 87, japidviews\AdminController\manageVIP.html
		p("\"></script>\n" + 
"<script src=\"");// line 87, japidviews\AdminController\manageVIP.html
		p(lookupStatic("/public/js/min/testRemind.js"));// line 88, japidviews\AdminController\manageVIP.html
		p("\"></script>\n" + 
"<script src=\"");// line 88, japidviews\AdminController\manageVIP.html
		p(lookupStatic("/public/js/min/ajax.js"));// line 89, japidviews\AdminController\manageVIP.html
		p("\"></script>\n" + 
"<script src=\"");// line 89, japidviews\AdminController\manageVIP.html
		p(lookupStatic("/public/js/paging.js"));// line 90, japidviews\AdminController\manageVIP.html
		p("\"></script>\n" + 
"<script src=\"");// line 90, japidviews\AdminController\manageVIP.html
		p(lookupStatic("/public/js/back.js"));// line 91, japidviews\AdminController\manageVIP.html
		p("\"></script>\n");// line 91, japidviews\AdminController\manageVIP.html
		
		endDoLayout(sourceTemplate);
	}

}