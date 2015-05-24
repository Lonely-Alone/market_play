//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import models.goods.Good;
import utils.PictureUtil.Effect;
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
// NOTE: This file was generated from: japidviews/AdminController/goodPreview.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class goodPreview extends frontLayout
{
	public static final String sourceTemplate = "japidviews/AdminController/goodPreview.html";
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


	public goodPreview() {
	super((StringBuilder)null);
	initHeaders();
	}
	public goodPreview(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public goodPreview(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"good", "pictures",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"Good", "List<Attachment>",  };
	public static final Object[] argDefaults= new Object[] {null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.goodPreview.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private Good good; // line 5, japidviews/AdminController/goodPreview.html
	private List<Attachment> pictures; // line 5, japidviews/AdminController/goodPreview.html
	public cn.bran.japid.template.RenderResult render(Good good,List<Attachment> pictures) {
		this.good = good;
		this.pictures = pictures;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 5, japidviews/AdminController/goodPreview.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(Good good,List<Attachment> pictures) {
		return new goodPreview().render(good, pictures);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\goodPreview.html
// line 7, japidviews\AdminController\goodPreview.html
// line 12, japidviews\AdminController\goodPreview.html
		p("<div class=\"content_page pt1\">\n" + 
"	<section class=\"mb1 product_show_area\">\n" + 
"    	<div class=\"f18 tc\">\n" + 
"            <p class=\"g0\">");// line 12, japidviews\AdminController\goodPreview.html
		p(good.name);// line 16, japidviews\AdminController\goodPreview.html
		p("</p>\n" + 
"            <p class=\"g0\">");// line 16, japidviews\AdminController\goodPreview.html
		p(good.chief);// line 17, japidviews\AdminController\goodPreview.html
		p("</p>\n" + 
"            <p><img width=\"100%\" src=\"");// line 17, japidviews\AdminController\goodPreview.html
		p(getPictureFromPicServer(640, 0, Effect.FILL, good.imageURL));// line 18, japidviews\AdminController\goodPreview.html
		p("\"/></p>\n" + 
"            <div class=\"f16 fix\">\n" + 
"            	<div class=\"ml1 l\">\n" + 
"                	<p class=\"cf5\">微信价：&yen; ");// line 18, japidviews\AdminController\goodPreview.html
		p(formatNumber(good.realPrice/100.0, "0.00"));// line 21, japidviews\AdminController\goodPreview.html
		p("元</p>\n" + 
"                    <p class=\"f14 g9 tdl\">市场价：&yen; ");// line 21, japidviews\AdminController\goodPreview.html
		p(formatNumber(good.showPrice/100.0, "0.00"));// line 22, japidviews\AdminController\goodPreview.html
		p("元</p>\n" + 
"                </div>\n" + 
"                <div class=\"mr1 r\">\n" + 
"                	<p class=\"cf5\">销售");// line 22, japidviews\AdminController\goodPreview.html
		p(good.soldCount);// line 25, japidviews\AdminController\goodPreview.html
		p("件</p>\n" + 
"                    <p>库存：剩余");// line 25, japidviews\AdminController\goodPreview.html
		p(good.leftCount);// line 26, japidviews\AdminController\goodPreview.html
		p("件</p>\n" + 
"                </div>\n" + 
"            </div>\n" + 
"    	</div>\n" + 
"    </section>\n" + 
"	<section>\n" + 
"    	<div class=\"mb1 product_show_area\">\n" + 
"			<div class=\"p1\">\n" + 
"		    	<p class=\"f18\">产品详细介绍</p> \n" + 
"		    	<p class=\"lh20\">");// line 26, japidviews\AdminController\goodPreview.html
		p(nl2br(good.descr));// line 35, japidviews\AdminController\goodPreview.html
		p("</p>\n" + 
"			</div>\n" + 
"	    </div>\n" + 
"	   	<div class=\"mb05 product_show_area\">\n" + 
"		    ");// line 35, japidviews\AdminController\goodPreview.html
		for(Attachment picture : pictures){// line 39, japidviews\AdminController\goodPreview.html
		p("		    	<img width=\"100%\" src=\"");// line 39, japidviews\AdminController\goodPreview.html
		p(getPictureFromPicServer(640, 0, Effect.FILL, picture.url));// line 40, japidviews\AdminController\goodPreview.html
		p("\"/>\n" + 
"		    ");// line 40, japidviews\AdminController\goodPreview.html
		}// line 41, japidviews\AdminController\goodPreview.html
		p("		</div>\n" + 
"    </section>\n" + 
"</div>");// line 41, japidviews\AdminController\goodPreview.html
		
		endDoLayout(sourceTemplate);
	}

	@Override protected void moreCSSLink() {
		// line 7, japidviews\AdminController\goodPreview.html
		p("<style>\n" + 
".content_page{width:400px; border:none}\n" + 
"</style>\n");// line 7, japidviews\AdminController\goodPreview.html
		;
	}
	@Override protected void bodyStyle() {
		// line 12, japidviews\AdminController\goodPreview.html
		p("class=\"bgf9\"");// line 12, japidviews\AdminController\goodPreview.html
		;
	}
}