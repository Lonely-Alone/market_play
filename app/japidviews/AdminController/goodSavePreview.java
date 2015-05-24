//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import models.goods.GoodType;
import utils.PictureUtil.Effect;
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
// NOTE: This file was generated from: japidviews/AdminController/goodSavePreview.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class goodSavePreview extends frontLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/goodSavePreview.html";
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


	public goodSavePreview() {
	super((StringBuilder)null);
	initHeaders();
	}
	public goodSavePreview(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public goodSavePreview(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"name", "chief", "descr", "imageURL", "showPrice", "realPrice", "leftCount", "picUrls", "type", "goodPlace",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"String", "String", "String", "String", "int", "int", "int", "List<String>", "GoodType", "String",  };
	public static final Object[] argDefaults= new Object[] {null,null,null,null,null,null,null,null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.goodSavePreview.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private String name; // line 3, japidviews/AdminController/goodSavePreview.html
	private String chief; // line 3, japidviews/AdminController/goodSavePreview.html
	private String descr; // line 3, japidviews/AdminController/goodSavePreview.html
	private String imageURL; // line 3, japidviews/AdminController/goodSavePreview.html
	private int showPrice; // line 3, japidviews/AdminController/goodSavePreview.html
	private int realPrice; // line 3, japidviews/AdminController/goodSavePreview.html
	private int leftCount; // line 3, japidviews/AdminController/goodSavePreview.html
	private List<String> picUrls; // line 3, japidviews/AdminController/goodSavePreview.html
	private GoodType type; // line 3, japidviews/AdminController/goodSavePreview.html
	private String goodPlace; // line 3, japidviews/AdminController/goodSavePreview.html
	public cn.bran.japid.template.RenderResult render(String name,String chief,String descr,String imageURL,int showPrice,int realPrice,int leftCount,List<String> picUrls,GoodType type,String goodPlace) {
		this.name = name;
		this.chief = chief;
		this.descr = descr;
		this.imageURL = imageURL;
		this.showPrice = showPrice;
		this.realPrice = realPrice;
		this.leftCount = leftCount;
		this.picUrls = picUrls;
		this.type = type;
		this.goodPlace = goodPlace;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 3, japidviews/AdminController/goodSavePreview.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(String name,String chief,String descr,String imageURL,int showPrice,int realPrice,int leftCount,List<String> picUrls,GoodType type,String goodPlace) {
		return new goodSavePreview().render(name, chief, descr, imageURL, showPrice, realPrice, leftCount, picUrls, type, goodPlace);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\goodSavePreview.html
// line 5, japidviews\AdminController\goodSavePreview.html
// line 10, japidviews\AdminController\goodSavePreview.html
		p("<div class=\"content_page pt1\">\n" + 
"	<section class=\"mb1 product_show_area\">\n" + 
"    	<div class=\"f18 tc\">\n" + 
"            <p class=\"g0\">");// line 10, japidviews\AdminController\goodSavePreview.html
		p(name);// line 14, japidviews\AdminController\goodSavePreview.html
		p("</p>\n" + 
"            <p class=\"g0\">");// line 14, japidviews\AdminController\goodSavePreview.html
		p(chief);// line 15, japidviews\AdminController\goodSavePreview.html
		p("</p>\n" + 
"            <p class=\"g0\">");// line 15, japidviews\AdminController\goodSavePreview.html
		p(type.name);// line 16, japidviews\AdminController\goodSavePreview.html
		p("</p>\n" + 
"            <p class=\"g0\">");// line 16, japidviews\AdminController\goodSavePreview.html
		p(goodPlace);// line 17, japidviews\AdminController\goodSavePreview.html
		p("</p>\n" + 
"            <p><img width=\"100%\" src=\"");// line 17, japidviews\AdminController\goodSavePreview.html
		p(getPictureFromPicServer(640, 0, Effect.FILL, imageURL));// line 18, japidviews\AdminController\goodSavePreview.html
		p("\"/></p>\n" + 
"            <div class=\"f16 fix\">\n" + 
"            	<div class=\"ml1 l\">\n" + 
"                	<p class=\"cf5\">微信价：&yen; ");// line 18, japidviews\AdminController\goodSavePreview.html
		p(formatNumber(realPrice/100.0, "0.00"));// line 21, japidviews\AdminController\goodSavePreview.html
		p("元</p>\n" + 
"                    <p class=\"f14 g9 tdl\">市场价：&yen; ");// line 21, japidviews\AdminController\goodSavePreview.html
		p(formatNumber(showPrice/100.0, "0.00"));// line 22, japidviews\AdminController\goodSavePreview.html
		p("元</p>\n" + 
"                </div>\n" + 
"                <div class=\"mr1 r\">\n" + 
"                    <p>库存：剩余");// line 22, japidviews\AdminController\goodSavePreview.html
		p(leftCount);// line 25, japidviews\AdminController\goodSavePreview.html
		p("件</p>\n" + 
"                </div>\n" + 
"            </div>\n" + 
"    	</div>\n" + 
"    </section>\n" + 
"	<section>\n" + 
"		<div class=\"mb1 product_show_area\">\n" + 
"			<div class=\"p1\">\n" + 
"		    	<p class=\"f18\">产品详细介绍</p> \n" + 
"		    	<p class=\"lh20\">");// line 25, japidviews\AdminController\goodSavePreview.html
		p(nl2br(descr));// line 34, japidviews\AdminController\goodSavePreview.html
		p("</p>\n" + 
"			</div>\n" + 
"	    </div>\n" + 
"	   	<div class=\"mb05 product_show_area\">\n" + 
"		    ");// line 34, japidviews\AdminController\goodSavePreview.html
		for(String url : picUrls){// line 38, japidviews\AdminController\goodSavePreview.html
		p("		    	<img width=\"100%\" src=\"");// line 38, japidviews\AdminController\goodSavePreview.html
		p(getPictureFromPicServer(640, 0, Effect.FILL, url));// line 39, japidviews\AdminController\goodSavePreview.html
		p("\"/>\n" + 
"		    ");// line 39, japidviews\AdminController\goodSavePreview.html
		}// line 40, japidviews\AdminController\goodSavePreview.html
		p("		</div>\n" + 
"    </section>\n" + 
"</div>");// line 40, japidviews\AdminController\goodSavePreview.html
		
		endDoLayout(sourceTemplate);
	}

	@Override protected void moreCSSLink() {
		// line 5, japidviews\AdminController\goodSavePreview.html
		p("<style>\n" + 
".content_page{width:400px;border:none;}\n" + 
"</style>\n");// line 5, japidviews\AdminController\goodSavePreview.html
		;
	}
	@Override protected void bodyStyle() {
		// line 10, japidviews\AdminController\goodSavePreview.html
		p("class=\"bgf9\"");// line 10, japidviews\AdminController\goodSavePreview.html
		;
	}
}