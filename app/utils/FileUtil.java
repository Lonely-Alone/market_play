package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import play.Logger;
import play.Play;
import play.Play.Mode;
import cn.bran.play.JapidPlayAdapter;

import com.google.gson.Gson;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import com.ning.http.multipart.FilePart;
import com.ning.http.multipart.StringPart;

public class FileUtil {

	public static String AUDIO_SERVER = "http://oss.iclass.cn/formAudio";
	public static String PICTURE_SERVER_BASEURL = "http://oss.iclass.cn/smallfiles";

	private class Result {
		public boolean succ;
		public String html;
	}

	public static String uploadAudio(File file) {
		final AsyncHttpClient client = new AsyncHttpClient();
		try {
			final Response response = client.preparePost(AUDIO_SERVER)
					.addBodyPart(new FilePart("qqfile", file))
					.addBodyPart(new StringPart("bucketName", "smallfiles"))
					.addBodyPart(new StringPart("source", "WEBOOK")).execute()
					.get();
			final String responseBody = response.getResponseBody("utf8");
			try {
				return new Gson().fromJson(responseBody, Result.class).html;
			} catch (Exception e) {
				Logger.error("[EndServer has not started.]");
			}
		} catch (Exception e) {
			Logger.error(e, e.getMessage());
		} finally {
			client.close();
		}
		return "";
	}

}