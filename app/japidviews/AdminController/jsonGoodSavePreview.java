//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
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
// NOTE: This file was generated from: japidviews/AdminController/jsonGoodSavePreview.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class jsonGoodSavePreview extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/AdminController/jsonGoodSavePreview.html";
	 private void initHeaders() {
		putHeader("Content-Type", "application/json; charset=utf-8");
		setContentType("application/json; charset=utf-8");
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


	public jsonGoodSavePreview() {
	super((StringBuilder)null);
	initHeaders();
	}
	public jsonGoodSavePreview(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public jsonGoodSavePreview(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"name", "chief", "descr", "imageURL", "showPrice", "realPrice", "leftCount", "picUrls", "goodTypeId", "goodPlace",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"String", "String", "String", "String", "int", "int", "int", "List<String>", "long", "String",  };
	public static final Object[] argDefaults= new Object[] {null,null,null,null,null,null,null,null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.jsonGoodSavePreview.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private String name; // line 1, japidviews/AdminController/jsonGoodSavePreview.html
	private String chief; // line 1, japidviews/AdminController/jsonGoodSavePreview.html
	private String descr; // line 1, japidviews/AdminController/jsonGoodSavePreview.html
	private String imageURL; // line 1, japidviews/AdminController/jsonGoodSavePreview.html
	private int showPrice; // line 1, japidviews/AdminController/jsonGoodSavePreview.html
	private int realPrice; // line 1, japidviews/AdminController/jsonGoodSavePreview.html
	private int leftCount; // line 1, japidviews/AdminController/jsonGoodSavePreview.html
	private List<String> picUrls; // line 1, japidviews/AdminController/jsonGoodSavePreview.html
	private long goodTypeId; // line 1, japidviews/AdminController/jsonGoodSavePreview.html
	private String goodPlace; // line 1, japidviews/AdminController/jsonGoodSavePreview.html
	public cn.bran.japid.template.RenderResult render(String name,String chief,String descr,String imageURL,int showPrice,int realPrice,int leftCount,List<String> picUrls,long goodTypeId,String goodPlace) {
		this.name = name;
		this.chief = chief;
		this.descr = descr;
		this.imageURL = imageURL;
		this.showPrice = showPrice;
		this.realPrice = realPrice;
		this.leftCount = leftCount;
		this.picUrls = picUrls;
		this.goodTypeId = goodTypeId;
		this.goodPlace = goodPlace;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 1, japidviews/AdminController/jsonGoodSavePreview.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(String name,String chief,String descr,String imageURL,int showPrice,int realPrice,int leftCount,List<String> picUrls,long goodTypeId,String goodPlace) {
		return new jsonGoodSavePreview().render(name, chief, descr, imageURL, showPrice, realPrice, leftCount, picUrls, goodTypeId, goodPlace);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\jsonGoodSavePreview.html
p("{succ: \"true\", html: \"");// line 2, japidviews\AdminController\jsonGoodSavePreview.html
		p(escapeJavaScript(getHtml()));// line 3, japidviews\AdminController\jsonGoodSavePreview.html
		p("\"}\n" + 
"\n");// line 3, japidviews\AdminController\jsonGoodSavePreview.html
		// line 5, japidviews\AdminController\jsonGoodSavePreview.html
		
		endDoLayout(sourceTemplate);
	}

public String getHtml() {
StringBuilder sb = new StringBuilder();
StringBuilder ori = getOut();
this.setOut(sb);
TreeMap<Integer, cn.bran.japid.template.ActionRunner> parentActionRunners = actionRunners;
actionRunners = new TreeMap<Integer, cn.bran.japid.template.ActionRunner>();
// line 5, japidviews\AdminController\jsonGoodSavePreview.html
		p("<iframe src=\"");// line 5, japidviews\AdminController\jsonGoodSavePreview.html
		p(lookup("AdminController.goodSavePreview", name, chief, descr, imageURL, showPrice, realPrice, leftCount, picUrls,goodTypeId,goodPlace));// line 6, japidviews\AdminController\jsonGoodSavePreview.html
		p("\" height=490 width=420 frameborder=\"0\"></iframe>\n");// line 6, japidviews\AdminController\jsonGoodSavePreview.html
		
this.setOut(ori);
if (actionRunners.size() > 0) {
	StringBuilder _sb2 = new StringBuilder();
	int segStart = 0;
	for (Map.Entry<Integer, cn.bran.japid.template.ActionRunner> _arEntry : actionRunners.entrySet()) {
		int pos = _arEntry.getKey();
		_sb2.append(sb.substring(segStart, pos));
		segStart = pos;
		cn.bran.japid.template.ActionRunner _a_ = _arEntry.getValue();
		_sb2.append(_a_.run().getContent().toString());
	}
	_sb2.append(sb.substring(segStart));
	actionRunners = parentActionRunners;
	return _sb2.toString();
} else {
	actionRunners = parentActionRunners;
	return sb.toString();
}
}
}