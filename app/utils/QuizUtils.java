package utils;

import java.util.ArrayList;
import java.util.List;

import play.Logger;

import com.google.gson.Gson;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

public class QuizUtils {
	/************************ 需要用户配置的区域 ******************/
	private static final String SOURCE_NAME = "webook";

	/************************ 不需要用户配置的区域 ******************/
	private static final String RIGEST_URL = "http://examination.iclass.cn/regist";
	private static final String LIST_URL = "http://examination.iclass.cn/listExamByPerson";
	private static final String ADD_URL = "http://examination.iclass.cn/addExamPage";
	private static final String VIEW_URL = "http://examination.iclass.cn/showExamPage";
	private static final String DO_URL = "http://examination.iclass.cn/examPage";

	public static Result regist(long userId, String username) {
		final AsyncHttpClient client = new AsyncHttpClient();
		try {
			final Response response = client.preparePost(RIGEST_URL)
					.addParameter("organization", SOURCE_NAME)
					.addParameter("mappingId", userId + "")
					.addParameter("name", username).execute().get();
			return new Gson().fromJson(response.getResponseBody("utf8"),
					Result.class);
		} catch (Exception e) {
			Logger.error(e, e.getMessage());
			return null;
		} finally {
			client.close();
		}
	}

	public static Result listObj(String userId) {
		try {
			return new Gson().fromJson(listStr(userId), Result.class);
		} catch (Exception e) {
			Logger.error(e, e.getMessage());
			return null;
		}
	}

	public static String listStr(String userId) {
		final AsyncHttpClient client = new AsyncHttpClient();
		try {
			final Response response = client.prepareGet(LIST_URL)
					.addQueryParameter("organization", SOURCE_NAME)
					.addQueryParameter("mappingId", userId).execute().get();
			return response.getResponseBody("utf8");
		} catch (Exception e) {
			Logger.error(e, e.getMessage());
			return null;
		} finally {
			client.close();
		}
	}

	public static String getListUrl(String userId) {
		return LIST_URL + "?organization=" + SOURCE_NAME + "&mappingId="
				+ userId;
	}

	public static String getAddUrl(String userId) {
		return ADD_URL + "/" + SOURCE_NAME + "/" + encode(userId);
	}

	public static String getViewUrl(String userId, String examId) {
		return VIEW_URL + "/" + SOURCE_NAME + "/" + encode(userId) + "/"
				+ examId;
	}

	public static String getDoUrl(String userId, String examId, boolean mobile) {
		return DO_URL + (mobile ? "/APP/" : "/WEB/") + SOURCE_NAME + "/"
				+ encode(userId) + "/" + examId;
	}

	public class Result {
		public String status;
		public int statusCode;
		public ResultList result;
	}

	public class ResultList {
		public List<Quiz> array;
		public int totalPage;
	}

	public class Quiz {
		public long id;
		public String name;
		public String content;
		public long createTime;
		public Double score;
	}

	private static final List<Character> chars = new ArrayList<Character>() {
		{
			for (int i = 97; i < 123; i++) {
				add((char) i);
			}
			for (int i = 65; i < 91; i++) {
				add((char) i);
			}
			for (int i = 49; i < 58; i++) {
				add((char) i);
			}
		}
	};

	private static String encode(String inputStr) {
		long input = Long.parseLong(inputStr);
		StringBuffer sb = new StringBuffer();
		do {
			sb.append(chars.get((int) (input % chars.size())));
			input = input / chars.size();
		} while (input != 0);
		return sb.toString();
	}
}
