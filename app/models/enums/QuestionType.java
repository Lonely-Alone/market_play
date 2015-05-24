package models.enums;

import org.apache.commons.lang.StringUtils;

public enum QuestionType {
	all, system, skills, device, net, others;

	public String convert2Str() {
		String str = "其他问题";
		switch (this) {
		case system:
			str = "系统相关";
			break;
		case skills:
			str = "使用技巧";
			break;
		case device:
			str = "设备使用";
			break;
		case net:
			str = "网络异常";
			break;
		case others:
			str = "其他问题";
			break;
		case all:
			str = "全部问题";
			break;
		default:
			break;
		}
		return str;
	}

	public static QuestionType convert2Enum(String type) {
		if (StringUtils.isBlank(type)) {
			return QuestionType.all;
		} else if (type.equals("系统相关")) {
			return QuestionType.system;
		} else if (type.equals("使用技巧")) {
			return QuestionType.skills;
		} else if (type.equals("设备使用")) {
			return QuestionType.device;
		} else if (type.equals("网络异常")) {
			return QuestionType.net;
		} else if (type.equals("其他问题") || type.equals("全部问题")) {
			return QuestionType.others;
		}
		return QuestionType.all;
	}
}
