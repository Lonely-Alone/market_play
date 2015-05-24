//version: 0.9.5.1
package japidviews.AdminController;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import org.apache.commons.lang.StringUtils;
import utils.PictureUtil;
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
// NOTE: This file was generated from: japidviews/AdminController/picUploadTag.html
// Change to this file will be lost next time the template file is compiled.
//
@cn.bran.play.NoEnhance
public class picUploadTag extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/AdminController/picUploadTag.html";
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


	public picUploadTag() {
	super((StringBuilder)null);
	initHeaders();
	}
	public picUploadTag(StringBuilder out) {
		super(out);
		initHeaders();
	}
	public picUploadTag(cn.bran.japid.template.JapidTemplateBaseWithoutPlay caller) {
		super(caller);
	}

/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"good", "attachments",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"Good", "List<Attachment>",  };
	public static final Object[] argDefaults= new Object[] {null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.AdminController.picUploadTag.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private Good good; // line 7, japidviews/AdminController/picUploadTag.html
	private List<Attachment> attachments; // line 7, japidviews/AdminController/picUploadTag.html
	public cn.bran.japid.template.RenderResult render(Good good,List<Attachment> attachments) {
		this.good = good;
		this.attachments = attachments;
		try {super.layout();} catch (RuntimeException __e) { super.handleException(__e);} // line 7, japidviews/AdminController/picUploadTag.html
		return getRenderResult();
	}

	public static cn.bran.japid.template.RenderResult apply(Good good,List<Attachment> attachments) {
		return new picUploadTag().render(good, attachments);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
;// line 1, japidviews\AdminController\picUploadTag.html

p("<div class=\"mb10 fix\">\n" + 
" 	<span class=\"l\">宝贝图片：</span>\n" + 
"    <div class=\"cell\">\n" + 
"    	<div class=\"ml10 pct85 bdc\">\n" + 
"        	<div class=\"pl10 pt10 bgef\">\n" + 
"            	<a class=\"upload_nav_on\" href=\"#\">本地上传</a>\n" + 
"                ");// line 7, japidviews\AdminController\picUploadTag.html
		p("\n" + 
"            </div>\n" + 
"            <div class=\"mt20 ml80 pl20 pb20\">\n" + 
"                <p class=\"mt20 mb10 ml45 g9\">\n" + 
"                    提示：1.&nbsp;本地上传图片大小不能超过&nbsp;<span class=\"co\">500K</span>&nbsp;。\n" + 
"                </p>\n" + 
"                <p class=\"ml80 mb10 g9\">\n" + 
"                    2.&nbsp;您必须上传&nbsp;<span class=\"co\">1</span>&nbsp;张商品预览图和&nbsp;<span class=\"co\">1</span>&nbsp;张主图。\n" + 
"                    		副图最多可以上传&nbsp;<span class=\"co\">8</span>&nbsp;张,最少<span class=\"co\">4</span>&nbsp;张。\n" + 
"                </p>\n" + 
"                <p class=\"ml80 g9\">\n" + 
"                    3.&nbsp;商品logo宽高推荐<span class=\"co\">300*300</span>像素，主图和附图宽高推荐<span class=\"co\">640*355</span>像素。\n" + 
"                </p>\n" + 
"            </div>\n" + 
"            <div class=\"mt10 p10 bgf9\">\n" + 
"            	<div class=\"mt10 fix\">\n" + 
"            		<div id=\"previewPicDiv\" class=\"upload_img_box2 l rel\">\n" + 
"            			");// line 16, japidviews\AdminController\picUploadTag.html
		p(upload(1, 300, 300, Effect.CUT, "logo(300*300)", null == good ? "" : good.previewURL));// line 33, japidviews\AdminController\picUploadTag.html
		p("\n" + 
"            		</div>\n" + 
"            		<div id=\"mainPicDiv\" class=\"upload_img_box3 l rel\">\n" + 
"            			");// line 33, japidviews\AdminController\picUploadTag.html
		p(upload(2, 640, 0, Effect.CUT, "主图(640*355)", null == good ? "" : good.imageURL));// line 36, japidviews\AdminController\picUploadTag.html
		p("\n" + 
"            		</div>\n" + 
"            		");// line 36, japidviews\AdminController\picUploadTag.html
		if(null != good){// line 38, japidviews\AdminController\picUploadTag.html
            			int i = 0;// line 39, japidviews\AdminController\picUploadTag.html
            			for(Attachment a : attachments){// line 40, japidviews\AdminController\picUploadTag.html
		p("                			<div class=\"commPic upload_img_box l rel\">\n" + 
"	                        	");// line 40, japidviews\AdminController\picUploadTag.html
		p(upload(++i+2, 640, 0, Effect.CUT, "附图"+i+"(640*355)", a.url));// line 42, japidviews\AdminController\picUploadTag.html
		p("\n" + 
"                			</div>\n" + 
"            			");// line 42, japidviews\AdminController\picUploadTag.html
		}// line 44, japidviews\AdminController\picUploadTag.html
            			for(; i < 8;){// line 45, japidviews\AdminController\picUploadTag.html
		p("                            <div class=\"commPic upload_img_box l rel ");// line 45, japidviews\AdminController\picUploadTag.html
		p(i>=4?"mt10":"");// line 46, japidviews\AdminController\picUploadTag.html
		p("\">\n" + 
"                            	");// line 46, japidviews\AdminController\picUploadTag.html
		p(upload(++i+2, 640, 0, Effect.CUT, "附图"+i+"(640*355)", ""));// line 47, japidviews\AdminController\picUploadTag.html
		p("\n" + 
"                            </div>\n" + 
"            			");// line 47, japidviews\AdminController\picUploadTag.html
		}// line 49, japidviews\AdminController\picUploadTag.html
            		}else{// line 50, japidviews\AdminController\picUploadTag.html
            			for(int i = 0; i < 8; i ++){// line 51, japidviews\AdminController\picUploadTag.html
		p("            				<div class=\"commPic upload_img_box l rel ");// line 51, japidviews\AdminController\picUploadTag.html
		p(i>=4?"mt10":"");// line 52, japidviews\AdminController\picUploadTag.html
		p("\">\n" + 
"            					");// line 52, japidviews\AdminController\picUploadTag.html
		p(upload(i+3, 640, 0, Effect.CUT, "附图"+(i+1)+"(640*355)", ""));// line 53, japidviews\AdminController\picUploadTag.html
		p("\n" + 
"            				</div>\n" + 
"                		");// line 53, japidviews\AdminController\picUploadTag.html
		}// line 55, japidviews\AdminController\picUploadTag.html
            		}// line 56, japidviews\AdminController\picUploadTag.html
		p("                </div>\n" + 
"            </div>\n" + 
"        </div>\n" + 
"    </div>\n" + 
" </div>\n");// line 56, japidviews\AdminController\picUploadTag.html
		// line 62, japidviews\AdminController\picUploadTag.html
		
		endDoLayout(sourceTemplate);
	}

public String upload(int target, int width, int height, Effect effect, String name, String url) {
StringBuilder sb = new StringBuilder();
StringBuilder ori = getOut();
this.setOut(sb);
TreeMap<Integer, cn.bran.japid.template.ActionRunner> parentActionRunners = actionRunners;
actionRunners = new TreeMap<Integer, cn.bran.japid.template.ActionRunner>();
// line 62, japidviews\AdminController\picUploadTag.html
boolean noPic = StringUtils.isBlank(url);// line 63, japidviews\AdminController\picUploadTag.html
		p("<form target=\"upload_target");// line 63, japidviews\AdminController\picUploadTag.html
		p(target);// line 64, japidviews\AdminController\picUploadTag.html
		p("\" class=\"dib uploadForm abs_out\" enctype=\"multipart/form-data\" method=\"post\" action=\"");// line 64, japidviews\AdminController\picUploadTag.html
		p(lookup("AdminController.upload", new Object[]{}));// line 64, japidviews\AdminController\picUploadTag.html
		p("\">\n" + 
"	<input id=\"fileInput");// line 64, japidviews\AdminController\picUploadTag.html
		p(target);// line 65, japidviews\AdminController\picUploadTag.html
		p("\" type=\"file\" name=\"file\" class=\"p5 g5 jsForUpload\" style=\"width:60px;\"/>\n" + 
"	<input type=\"hidden\" name=\"target\" value=\"");// line 65, japidviews\AdminController\picUploadTag.html
		p(target);// line 66, japidviews\AdminController\picUploadTag.html
		p("\"/>\n" + 
"	<input type=\"hidden\" name=\"width\" value=\"");// line 66, japidviews\AdminController\picUploadTag.html
		p(width);// line 67, japidviews\AdminController\picUploadTag.html
		p("\"/>\n" + 
"	<input type=\"hidden\" name=\"height\" value=\"");// line 67, japidviews\AdminController\picUploadTag.html
		p(height);// line 68, japidviews\AdminController\picUploadTag.html
		p("\"/>\n" + 
"	<input type=\"hidden\" name=\"effect\" value=\"");// line 68, japidviews\AdminController\picUploadTag.html
		p(effect.name());// line 69, japidviews\AdminController\picUploadTag.html
		p("\"/>\n" + 
"</form>\n" + 
"<iframe id=\"upload_target");// line 69, japidviews\AdminController\picUploadTag.html
		p(target);// line 71, japidviews\AdminController\picUploadTag.html
		p("\" name=\"upload_target");// line 71, japidviews\AdminController\picUploadTag.html
		p(target);// line 71, japidviews\AdminController\picUploadTag.html
		p("\" class=\"abs_out\"></iframe>\n" + 
"<img id=\"uploadedPic");// line 71, japidviews\AdminController\picUploadTag.html
		p(target);// line 72, japidviews\AdminController\picUploadTag.html
		p("\" class=\"l mr10 jsForUploaded");// line 72, japidviews\AdminController\picUploadTag.html
		p(noPic ? " abs_out" : "");// line 72, japidviews\AdminController\picUploadTag.html
		p("\" src=\"");// line 72, japidviews\AdminController\picUploadTag.html
		p(noPic ? "" : getPictureFromPicServer(640, 0, Effect.CUT, url));// line 72, japidviews\AdminController\picUploadTag.html
		p("\" origin=\"");// line 72, japidviews\AdminController\picUploadTag.html
		p(noPic ? "" : url);// line 72, japidviews\AdminController\picUploadTag.html
		p("\" height=\"90\" width=\"90\" rel=\"fileInput");// line 72, japidviews\AdminController\picUploadTag.html
		p(target);// line 72, japidviews\AdminController\picUploadTag.html
		p("\"/>\n" + 
"<p class=\"pt20 uploadBtn");// line 72, japidviews\AdminController\picUploadTag.html
		p(target);// line 73, japidviews\AdminController\picUploadTag.html
		p("");// line 73, japidviews\AdminController\picUploadTag.html
		p(noPic ? "" : " abs_out");// line 73, japidviews\AdminController\picUploadTag.html
		p("\">");// line 73, japidviews\AdminController\picUploadTag.html
		p(name);// line 73, japidviews\AdminController\picUploadTag.html
		p("</p>\n" + 
"<p class=\"pt20 uploadBtn");// line 73, japidviews\AdminController\picUploadTag.html
		p(target);// line 74, japidviews\AdminController\picUploadTag.html
		p("");// line 74, japidviews\AdminController\picUploadTag.html
		p(noPic ? "" : " abs_out");// line 74, japidviews\AdminController\picUploadTag.html
		p("\">\n" + 
"	<a id=\"uploadTrigger");// line 74, japidviews\AdminController\picUploadTag.html
		p(target);// line 75, japidviews\AdminController\picUploadTag.html
		p("\" class=\"bdc p5 g5 uploadBtn\" href=\"javascript:;\" rel=\"fileInput");// line 75, japidviews\AdminController\picUploadTag.html
		p(target);// line 75, japidviews\AdminController\picUploadTag.html
		p("\">点击上传</a>\n" + 
"</p>\n" + 
"<a id=\"removePicBtn");// line 75, japidviews\AdminController\picUploadTag.html
		p(target);// line 77, japidviews\AdminController\picUploadTag.html
		p("\" class=\"i_delete jsForRmPic");// line 77, japidviews\AdminController\picUploadTag.html
		p(noPic ? " abs_out" : "");// line 77, japidviews\AdminController\picUploadTag.html
		p("\" href=\"javascript:;\" data=\"");// line 77, japidviews\AdminController\picUploadTag.html
		p(target);// line 77, japidviews\AdminController\picUploadTag.html
		p("\"></a>\n");// line 77, japidviews\AdminController\picUploadTag.html
		
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