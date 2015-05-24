package japidviews._javatags;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import models.enums.AdminMenu;
import models.goods.Good;
import models.order.OrderItem;
import models.person.Person;

import org.apache.commons.lang.StringUtils;

import play.mvc.Http.Cookie;
import play.mvc.Http.Request;
import play.mvc.Scope.Session;
import play.templates.JavaExtensions;
import utils.PictureUtil;
import utils.PictureUtil.Effect;
import controllers.BaseController;

/**
 * @author Administrator
 *
 */
/**
 * @author
 *
 */
public class CommonUtils {
	private static final String LOGGED_PERSON_ID = "loggedPersonId";
	private static final String KEEP_LOGIN_ID = "KEEP_LOGIN";

	public static String DEFAULT_GOOD_IMAGE = "/public/img/goods/g1.jpg";
	public static String DEFAULT_SHOP_IMAGE = "/public/img/shop/s1.png";

	private static String getDataFromSession(String arg) {
		Session session = Session.current();
		return null != session && session.contains(arg) ? session.get(arg)
				: null;
	}

	public static String getDataFromCookie(String arg) {
		Map<String, Cookie> cookies = Request.current().cookies;
		Cookie cookie = cookies.get(arg);
		if (null != cookie) {
			return cookie.value;
		}
		return null;
	}

	public static int getGoodNumFromCookie() {
		Iterator it = Request.current().cookies.keySet().iterator();
		int totalNum = 0;
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key.contains("good_")) {
				totalNum++;
			}
		}
		return totalNum;

	}

	public static <T extends Person> T getCurrentPerson() {
		T currPerson = null;
		String s = getDataFromSession(BaseController.CURRENT_PERSON_ID);
		if (StringUtils.isNotBlank(s)) {
			currPerson = Person.findOneById(Long.valueOf(s));
		}
		return null != currPerson && !currPerson.isDeleted ? currPerson : null;
	}

	public static String getPassedTime(Date date) {
		Date now = new Date();
		if (now.before(date)) {
			return "";
		}
		long delta = (now.getTime() - date.getTime()) / 1000;
		if (delta < 60) {
			return delta + "秒前";
		}
		if (delta < 60 * 60) {
			long minutes = delta / 60;
			return minutes + "分钟前";
		}
		if (delta < 24 * 60 * 60) {
			long hours = delta / (60 * 60);
			return hours + "小时前";
		}
		if (delta < 4 * 24 * 60 * 60) {
			long days = delta / (24 * 60 * 60);
			return days + "天前";
		}
		return JavaExtensions.format(date, "yyyy-MM-dd");
	}

	public static String formatDate(Date date, String format) {
		return JavaExtensions.format(date, format);
	}

	public static Date getDate(String dateStr, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String formatNumber(Number number, String format) {
		return JavaExtensions.format(number, format);
	}

	public static Map<String, Integer> getInterval(Date beginTime, Date endTime) {
		Map<String, Integer> result = new HashMap();
		long seconds = (endTime.getTime() - beginTime.getTime()) / 1000;
		long dCount = seconds / 60 / 60 / 24;
		long hCount = (seconds / 60 / 60) % 24;
		long mCount = (seconds / 60) % (24 * 60);
		long sCount = seconds % (24 * 60 * 60);

		result.put("DAY", (int) dCount);
		result.put("HOUR", (int) hCount);
		result.put("MINUTE", (int) mCount);
		result.put("SECOND", (int) sCount);
		return result;
	}

	public static String escapeURL(String url) {
		return url.replace("=", "%3D").replace("/", "%2F").replace(":", "%3A")
				.replace("&", "%26").replace("amp;", "%26");
	}

	public static AdminMenu[] leftMenus() {
		return AdminMenu.values();
	}

	public static AdminMenu[] leftServiceMenu() {
		AdminMenu[] menus = { AdminMenu.账号管理, AdminMenu.提货验证, AdminMenu.订单管理,
				AdminMenu.求购管理, AdminMenu.问答管理, AdminMenu.发布问答 };
		return menus;
	}

	public static String nl2brStr(String source) {
		if (StringUtils.isBlank(source)) {
			return "";
		}
		return JavaExtensions.nl2br(source).toString();
	}

	public static String getPictureFromPicServer(int w, int h, Effect effect,
			String url) {
		return StringUtils.isBlank(url) ? DEFAULT_GOOD_IMAGE : PictureUtil
				.getPictureFromPicServer(w, h, effect, url);
	}

	public static int fetchAmount(Good good) {
		return (int) OrderItem.fetchAmountByOwnerAndGood(getCurrentPerson(),
				good);
	}

	public static boolean escapeEmoji(String value) {
		if (StringUtils.isNotBlank(value)) {
			for (int i = 0; i < value.length(); i++) {
				if (value.codePointAt(i) >= 127744) {
					i++;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static String escape_Html(String html) {
		if (html == null)
			return "";
		html = html.replace("'", "&apos;");
		html = html.replaceAll("&", "&amp;");
		html = html.replace("\"", "&quot;"); // "
		html = html.replace("\t", "&nbsp;&nbsp;");// 替换跳格
		html = html.replace(" ", "&nbsp;");// 替换空格
		html = html.replace("<", "&lt;");
		html = html.replaceAll(">", "&gt;");
		return html;
	}
}
