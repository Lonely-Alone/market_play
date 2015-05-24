package models.enums;

import cn.bran.play.JapidPlayAdapter;

public enum AdminMenu {
	账号管理, 发布商品, 商品管理, 商品类型, 订单管理, 进账流水, 会员管理, 提货验证, 发布问答, 问答管理, 求购管理, 自取地点;
	public String getRenderUrl() {
		String url = "";
		switch (this) {
		case 账号管理:
			url = JapidPlayAdapter.lookup("AdminController.personCenter");
			break;
		case 订单管理:
			url = JapidPlayAdapter.lookup("AdminController.manageOrderSum");
			break;
		case 发布商品:
			url = JapidPlayAdapter.lookup("AdminController.publishGood");
			break;
		case 商品管理:
			url = JapidPlayAdapter.lookup("AdminController.manageGood");
			break;
		case 商品类型:
			url = JapidPlayAdapter.lookup("AdminController.manageGoodType");
			break;
		case 进账流水:
			url = JapidPlayAdapter.lookup("AdminController.manageBill");
			break;
		case 会员管理:
			url = JapidPlayAdapter.lookup("AdminController.manageVIP");
			break;
		case 提货验证:
			url = JapidPlayAdapter.lookup("AdminController.deliverConfirm");
			break;
		case 发布问答:
			url = JapidPlayAdapter.lookup("AdminController.publishQuestion");
			break;
		case 问答管理:
			url = JapidPlayAdapter.lookup("AdminController.manageQuestion");
			break;
		case 求购管理:
			url = JapidPlayAdapter.lookup("AdminController.manageConsult");
			break;
		case 自取地点:
			url = JapidPlayAdapter.lookup("AdminController.manageLocation");
			break;
		}
		return url;
	}
}