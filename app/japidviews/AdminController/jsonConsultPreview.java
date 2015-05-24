//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import cn.bran.japid.template.ActionRunner;
import models.sever.Consult;
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
// NOTE: This file was generated from: japidviews/AdminController/jsonConsultPreview.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class jsonConsultPreview extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/AdminController/jsonConsultPreview.html";
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


	public jsonConsultPreview() {
	super((StringBuilder)null);
	initHeaders();
	}
	public jsonConsultPreview(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public jsonConsultPreview(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"consultId",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"long",  };
	public static final Object[] argDefaults= new Object[] {null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.jsonConsultPreview.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private long consultId; // line 4, japidviews/AdminController/jsonConsultPreview.html
	public cn.bran.japid.template.RenderResult render(long consultId) {
		this.consultId = consultId;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 4, japidviews/AdminController/jsonConsultPreview.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(long consultId) {
		return new jsonConsultPreview().render(consultId);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\jsonConsultPreview.html

p("{succ: true, html: \"");// line 4, japidviews\AdminController\jsonConsultPreview.html
		p(escapeJavaScript(html()));// line 5, japidviews\AdminController\jsonConsultPreview.html
		p("\"}\n" + 
"\n" + 
"\n");// line 5, japidviews\AdminController\jsonConsultPreview.html
		// line 8, japidviews\AdminController\jsonConsultPreview.html
		
		endDoLayout(sourceTemplate);
	}

public String html() {
StringBuilder sb = new StringBuilder();
StringBuilder ori = getOut();
this.setOut(sb);
TreeMap<Integer, cn.bran.japid.template.ActionRunner> parentActionRunners = actionRunners;
actionRunners = new TreeMap<Integer, cn.bran.japid.template.ActionRunner>();
// line 8, japidviews\AdminController\jsonConsultPreview.html
			actionRunners.put(getOut().length(), new cn.bran.play.CacheablePlayActionRunner("", ServiceController.class, "consultDetail", consultId, "", 123) {
			@Override
			public void runPlayAction() throws cn.bran.play.JapidResult {
				ServiceController.consultDetail(consultId, "", 123); // line 9, japidviews\AdminController\jsonConsultPreview.html
			}
		}); p("\n");// line 9, japidviews\AdminController\jsonConsultPreview.html

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