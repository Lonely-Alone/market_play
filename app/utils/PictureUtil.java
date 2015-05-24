package utils;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import play.Logger;
import play.Play;

import com.google.gson.JsonParser;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Request;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;

/**
 * @author xuyuzhu
 */
public class PictureUtil {
	private static final String PIC_SERVER_BASEURL = Play.configuration
			.getProperty("picserver.baseurl", "http://weshop/picserver/weshop");
	private static final String UPLOAD_SERVER_BASEURL = Play.configuration
			.getProperty("picserver.uploadurl", "http://127.0.0.1:9009/stream");
	private static Log fmsLogger = LogFactory.getLog("fms");

	public enum Effect {
		PURE {// 原图
			@Override
			public String toString() {
				return "";
			}
		},
		FILL {// 填充
			@Override
			public String toString() {
				return "f";
			}
		},
		CUT {// 裁剪
			@Override
			public String toString() {
				return "c";
			}
		};
		@Override
		abstract public String toString();
	}

	public static boolean isFromPicServer(String picUrl) {
		return StringUtils.startsWithIgnoreCase(picUrl, PIC_SERVER_BASEURL);
	}

	/**
	 * @author xz8885 获取指定大小图片的方法，当宽或高为零时为零的维度会等比缩放，均为0则返回原始图片
	 *
	 * @param width
	 * @param height
	 * @param defaultUrl
	 * @return 图片url
	 */
	public static String getPictureFromPicServer(int width, int height,
			Effect effect, String defaultUrl) {
		if (!isFromPicServer(defaultUrl)) {
			return defaultUrl;
		}
		String fileName = StringUtils.substringAfterLast(defaultUrl, "/");
		effect = effect == null ? Effect.PURE : effect;
		return PIC_SERVER_BASEURL + "/" + width + "_" + height
				+ effect.toString() + "/" + fileName;
	}

	public static String uploadFile(File file) {
		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
		String responseBody = null;
		try {
			Request request = new RequestBuilder("POST")
					.setBody(file)
					.setFollowRedirects(true)
					.setUrl(UPLOAD_SERVER_BASEURL)
					.addQueryParameter("qqfile",
							URLEncoder.encode(file.getName(), "utf8"))
					.addQueryParameter("bucketName", "icweshop")
					.addQueryParameter("source", "webapp").build();
			Response response = asyncHttpClient.executeRequest(request).get();
			responseBody = response.getResponseBody();
			fmsLogger.info(responseBody);
			return (new JsonParser().parse(responseBody).getAsJsonObject())
					.get("html").getAsString();
		} catch (InterruptedException e) {
			Logger.error(e, e.getMessage());
			return null;
		} catch (ExecutionException e) {
			Logger.error(e, e.getMessage());
			return null;
		} catch (IOException e) {
			Logger.error(e, e.getMessage());
			return null;
		} catch (Exception e) {
			Logger.error(responseBody);
			return null;
		} finally {
			if (!asyncHttpClient.isClosed()) {
				asyncHttpClient.close();
			}
		}
	}

}
