package models.vo;

public class Result {
	public boolean succ;
	public String msg;
	public String url;
	public String html;
	public Boolean refresh;

	public Result(boolean succ, String msg, String url, String html) {
		this.succ = succ;
		this.msg = msg;
		this.url = url;
		this.html = html;
	}

	public Result(boolean succ, boolean refresh) {
		this.succ = succ;
		this.refresh = refresh;
	}

	public Result(String html) {
		this(true, "", "", html);
	}

	public Result(boolean isSuccess, String message) {
		this(isSuccess, message, "");
	}

	public Result(boolean isSuccess, String message, String url) {
		this(isSuccess, message, url, "");
	}

	public Result(boolean isSuccess) {
		this(isSuccess, "");
	}

	public Result setMessage(String message) {
		this.msg = message;
		return this;
	}
}
