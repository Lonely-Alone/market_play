//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import models.enums.AdminMenu;
import models.goods.GoodType;
import models.goods.Good;
import models.goods.Good.GoodPlace;
import models.goods.Attachment;
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
// NOTE: This file was generated from: japidviews/AdminController/editGood.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class editGood extends backLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/editGood.html";
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


	public editGood() {
	super((StringBuilder)null);
	initHeaders();
	}
	public editGood(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public editGood(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"good", "attachments", "typeList",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"Good", "List<Attachment>", "List<GoodType>",  };
	public static final Object[] argDefaults= new Object[] {null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.editGood.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private Good good; // line 7, japidviews/AdminController/editGood.html
	private List<Attachment> attachments; // line 7, japidviews/AdminController/editGood.html
	private List<GoodType> typeList; // line 7, japidviews/AdminController/editGood.html
	public cn.bran.japid.template.RenderResult render(Good good,List<Attachment> attachments,List<GoodType> typeList) {
		this.good = good;
		this.attachments = attachments;
		this.typeList = typeList;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 7, japidviews/AdminController/editGood.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(Good good,List<Attachment> attachments,List<GoodType> typeList) {
		return new editGood().render(good, attachments, typeList);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\editGood.html

p("<div class=\"content_page\">\n" + 
"	<div class=\"constr fix\">\n" + 
"		");// line 9, japidviews\AdminController\editGood.html
		new leftMenusTag(editGood.this).render(AdminMenu.发布商品); // line 12, japidviews\AdminController\editGood.html// line 12, japidviews\AdminController\editGood.html
		p("		<section class=\"cell\">\n" + 
"			<nav id=\"addGoodNav\" class=\"nav_content_box fix\">\n" + 
"				<h4 class=\"l\">填写宝贝基本信息</h4>\n" + 
"                <span class=\"g9 r\">\n" + 
"                	<span class=\"cr\">*</span>\n" + 
"                    表示该项必填\n" + 
"                </span>\n" + 
"			</nav>\n" + 
"            <article class=\"mt20\">\n" + 
"            	<div class=\"p5 ca f14 bbahc\">1.宝贝基本信息</div>\n" + 
"                <div class=\"ml20 mt10\">\n" + 
"                    <div class=\"mb10\">\n" + 
"                    	宝贝名称：\n" + 
"                        <span class=\"cr\">*</span>\n" + 
"                        <input id=\"nameInput\" class=\"jsForCount pct60 input vn\" type=\"text\" value=\"");// line 12, japidviews\AdminController\editGood.html
		p(null == good ? "" : good.name);// line 27, japidviews\AdminController\editGood.html
		p("\"/>\n" + 
"                        还能输入\n" + 
"                        <span class=\"cg\">");// line 27, japidviews\AdminController\editGood.html
		p(null == good ? 30 : 30-good.name.length());// line 29, japidviews\AdminController\editGood.html
		p("</span>\n" + 
"                        字\n" + 
"                    </div>\n" + 
"                    <div class=\"mb10\">\n" + 
"                    	<span class=\"dib w60 tr\">副标题：</span>\n" + 
"                        <span class=\"cr\">*</span>\n" + 
"                        <input id=\"chiefInput\" class=\"jsForCount pct60 input vn\" type=\"text\" value=\"");// line 29, japidviews\AdminController\editGood.html
		p(null == good ? "" : good.chief);// line 35, japidviews\AdminController\editGood.html
		p("\"/>\n" + 
"                        还能输入\n" + 
"                        <span class=\"cg\">");// line 35, japidviews\AdminController\editGood.html
		p(null == good ? 30 : 30-good.chief.length());// line 37, japidviews\AdminController\editGood.html
		p("</span>\n" + 
"                        字\n" + 
"                    </div>\n" + 
"                    <div class=\"mb10\">\n" + 
"                    	<span class=\"dib w60 tr\">宝贝类型：</span>\n" + 
"                        <span class=\"cr\">*</span>\n" + 
"                        <select id=\"goodType\">\n" + 
"		                	<option value=\"\">--请选择商品类型--</option>\n" + 
"		                	");// line 37, japidviews\AdminController\editGood.html
		for(GoodType type : typeList){// line 45, japidviews\AdminController\editGood.html
		p("		                		<option value=\"");// line 45, japidviews\AdminController\editGood.html
		p(type.id);// line 46, japidviews\AdminController\editGood.html
		p("\" ");// line 46, japidviews\AdminController\editGood.html
		p((null != good && good.type !=null && good.type.equals(type)) ? "selected":"");// line 46, japidviews\AdminController\editGood.html
		p(" data=\"");// line 46, japidviews\AdminController\editGood.html
		p(type.id);// line 46, japidviews\AdminController\editGood.html
		p("\">");// line 46, japidviews\AdminController\editGood.html
		p(type.name);// line 46, japidviews\AdminController\editGood.html
		p("</option>\n" + 
"		                	");// line 46, japidviews\AdminController\editGood.html
		}// line 47, japidviews\AdminController\editGood.html
		p("		                </select>\n" + 
"                    </div>\n" + 
"                    <div class=\"mb10\">\n" + 
"                    	<span class=\"dib w60 tr\">宝贝归属：</span>\n" + 
"                        <span class=\"cr\">*</span>\n" + 
"                        <select id=\"goodPlace\">\n" + 
"		                	<option value=\"\">--请选择商品归属--</option>\n" + 
"		                	");// line 47, japidviews\AdminController\editGood.html
		for(GoodPlace place : GoodPlace.values()){// line 55, japidviews\AdminController\editGood.html
		p("		                		<option value=\"");// line 55, japidviews\AdminController\editGood.html
		p(place);// line 56, japidviews\AdminController\editGood.html
		p("\" ");// line 56, japidviews\AdminController\editGood.html
		p((null != good && good.place !=null && good.place.equals(place)) ? "selected":"");// line 56, japidviews\AdminController\editGood.html
		p(" >");// line 56, japidviews\AdminController\editGood.html
		p(place);// line 56, japidviews\AdminController\editGood.html
		p("</option>\n" + 
"		                	");// line 56, japidviews\AdminController\editGood.html
		}// line 57, japidviews\AdminController\editGood.html
		p("		                </select>\n" + 
"                    </div>\n" + 
"                    <div class=\"mb10\">\n" + 
"                    	<span class=\"dib w60 tr\">市场价：</span>\n" + 
"                        <span class=\"cr\">*</span>");// line 57, japidviews\AdminController\editGood.html
		p("\n" + 
"                        <input id=\"showPriceInput\" value=\"");// line 62, japidviews\AdminController\editGood.html
		p(null == good ? "" : good.showPrice/100.0);// line 63, japidviews\AdminController\editGood.html
		p("\" class=\"pct20 input vn jsForPrice\" type=\"text\"/>\n" + 
"                        元\n" + 
"                        <span class=\"ml20 dib w60 tr\">微信价：</span>\n" + 
"                        <span class=\"cr\">*</span>");// line 63, japidviews\AdminController\editGood.html
		p("\n" + 
"                        <input id=\"realPriceInput\" value=\"");// line 66, japidviews\AdminController\editGood.html
		p(null == good ? "" : good.realPrice/100.0);// line 67, japidviews\AdminController\editGood.html
		p("\" class=\"pct20 input vn jsForPrice\" type=\"text\"/>\n" + 
"                        元\n" + 
"                        <p class=\"mt10 pl20 ml45 g9\">本类目下商品的价格必须在1元-20000元之间，精度到小数点后两位</p>\n" + 
"                    </div>\n" + 
"                    <div class=\"mb10\">\n" + 
"                    	<span class=\"dib w60 tr\">宝贝数量：</span>\n" + 
"                        <span class=\"cr\">*</span>\n" + 
"                        <input id=\"leftCountInput\" class=\"pct20 input vn jsForNumber\" type=\"text\" value=\"");// line 67, japidviews\AdminController\editGood.html
		p(null == good ? "" : good.leftCount);// line 74, japidviews\AdminController\editGood.html
		p("\"/>\n" + 
"                        件\n" + 
"                        <span class=\"ml20 dib w60 tr\">限购数量：</span>\n" + 
"                        <span class=\"cr\">&nbsp;</span>\n" + 
"                        <input id=\"limitCountInput\" class=\"pct20 input vn jsForNumber\" type=\"text\" value=\"");// line 74, japidviews\AdminController\editGood.html
		p(null == good ? "" : good.limitCount);// line 78, japidviews\AdminController\editGood.html
		p("\"/>\n" + 
"                        件				\n" + 
"                     </div>\n" + 
"                     ");// line 78, japidviews\AdminController\editGood.html
		new picUploadTag(editGood.this).render(good,attachments); // line 81, japidviews\AdminController\editGood.html// line 81, japidviews\AdminController\editGood.html
		p("                     <div class=\"mb10 fix\">\n" + 
"                     	<div class=\"l\">\n" + 
"                        	<span class=\"dib w60 tr\">宝贝描述：</span>\n" + 
"                     		<span class=\"cr\">*</span>\n" + 
"                        </div>\n" + 
"                        <div class=\"cell\">\n" + 
"                        	<script id=\"msgContent\" type=\"text/plain\" style=\"height:150px; width:640px;\" ></script>\n" + 
"                        	<textarea id=\"descrArea\" class=\"textarea pct85 dn\" rows=\"8\">");// line 81, japidviews\AdminController\editGood.html
		p(null == good ? "" : good.descr);// line 89, japidviews\AdminController\editGood.html
		p("</textarea><br/>\n" + 
"                        </div>\n" + 
"                     </div>\n" + 
"                </div>\n" + 
"                <div class=\"p5 ca f14 bbahc\">2.其他信息</div>\n" + 
"                <div class=\"mt10 ml20\">\n" + 
"                    <div class=\"mb10\">\n" + 
"                    	");// line 89, japidviews\AdminController\editGood.html
		boolean isPublished = null == good ? true : good.inSold;// line 96, japidviews\AdminController\editGood.html
		p("                    	<span class=\"dib w60 tr\">是否上架：</span>\n" + 
"                        <input id=\"isPublishedChk\" class=\"vn\" type=\"checkbox\" ");// line 96, japidviews\AdminController\editGood.html
		p(isPublished ? "checked" : "");// line 98, japidviews\AdminController\editGood.html
		p("/>\n" + 
"                        <label>是</label>\n" + 
"                    </div>\n" + 
"                </div>\n" + 
"                <div class=\"mt10 tc\">\n" + 
"                	<a id=\"previewGoodBtn\" class=\"graybtn btn_m mr10\" href=\"javascript:;\">预览</a>\n" + 
"                	<a id=\"addGoodBtn\" class=\"bluebtn btn_m\" href=\"javascript:;\">");// line 98, japidviews\AdminController\editGood.html
		p(null == good ? "发布商品" : "保存");// line 104, japidviews\AdminController\editGood.html
		p("</a>\n" + 
"                </div>\n" + 
"            </article>\n" + 
"        </section>\n" + 
"	</div>\n" + 
"</div>\n" + 
"<input id=\"goodIdInput\" type=\"hidden\" value=\"");// line 104, japidviews\AdminController\editGood.html
		p(null == good ? 0 : good.id);// line 110, japidviews\AdminController\editGood.html
		p("\"/>\n");// line 110, japidviews\AdminController\editGood.html
		new baseJSLinkTag(editGood.this).render(); // line 111, japidviews\AdminController\editGood.html// line 111, japidviews\AdminController\editGood.html
new iboxJSLinkTag(editGood.this).render(); // line 112, japidviews\AdminController\editGood.html// line 112, japidviews\AdminController\editGood.html
		p("<script src=\"");// line 112, japidviews\AdminController\editGood.html
		p(lookupStatic("/public/js/min/powerFloat.js"));// line 113, japidviews\AdminController\editGood.html
		p("\"></script>\n" + 
"<script src=\"");// line 113, japidviews\AdminController\editGood.html
		p(lookupStatic("/public/js/min/testRemind.js"));// line 114, japidviews\AdminController\editGood.html
		p("\"></script>\n" + 
"<script src=\"");// line 114, japidviews\AdminController\editGood.html
		p(lookupStatic("/public/js/min/ajax.js"));// line 115, japidviews\AdminController\editGood.html
		p("\"></script>\n" + 
"<script src=\"");// line 115, japidviews\AdminController\editGood.html
		p(lookupStatic("/public/js/checkinput.js"));// line 116, japidviews\AdminController\editGood.html
		p("\"></script>\n" + 
"<script type=\"text/javascript\" src=\"");// line 116, japidviews\AdminController\editGood.html
		p(lookupStatic("/public/js/ueditor/ueditor.config.js"));// line 117, japidviews\AdminController\editGood.html
		p("\"></script>\n" + 
"<script type=\"text/javascript\" src=\"");// line 117, japidviews\AdminController\editGood.html
		p(lookupStatic("/public/js/ueditor/ueditor.all.js"));// line 118, japidviews\AdminController\editGood.html
		p("\"></script>\n" + 
"<script src=\"");// line 118, japidviews\AdminController\editGood.html
		p(lookupStatic("/public/js/back_editgood.js"));// line 119, japidviews\AdminController\editGood.html
		p("\"></script>\n" + 
"<script type=\"text/javascript\">\n" + 
"//初始化ueditor\n" + 
"var ue,msgContentBox=$(\"msgContentBox\"),decrip=$(\"descrArea\").txt();\n" + 
"var initUedit = function(){\n" + 
"		ue= UE.getEditor('msgContent');\n" + 
"		ue.addListener(\"ready\", function () {ue.setContent(decrip);});\n" + 
"}\n" + 
"\n" + 
"initUedit();\n" + 
"</script>");// line 119, japidviews\AdminController\editGood.html
		
		endDoLayout(sourceTemplate);
	}

}