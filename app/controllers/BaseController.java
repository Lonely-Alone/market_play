package controllers;

import org.apache.commons.lang.StringUtils;

import play.mvc.Before;
import play.mvc.Scope.Session;
import cn.bran.play.JapidController;

public class BaseController extends JapidController {
	public static final String CURRENT_PERSON_ID = "currentPersonId";
	public static final String CURRENT_OPENID = "currentOpenId";

	@Before
	private static void cleanCookies() {
		response.cookies.remove(CURRENT_PERSON_ID);
		response.cookies.remove(CURRENT_OPENID);
	}



}
