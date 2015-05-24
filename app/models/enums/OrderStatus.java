package models.enums;

/**
 * <p>
 * 订单状态
 * </p>
 * 订单状态的具体变化过程请参考OrderSum.getStatus()。
 * 
 * @author xuyuzhu
 */
public enum OrderStatus {
	NOT_SUB, NOT_PAID, NOT_DELIVERED, NOT_RECEIVED, FINISHED, CANCELLED, OTHER;
	public String cnName() {
		String cn = "";
		switch (this) {
		case NOT_SUB:
			cn = "未提交";
			break;
		case NOT_PAID:
			cn = "未付款";
			break;
		case NOT_DELIVERED:
			cn = "未发货";
			break;
		case NOT_RECEIVED:
			cn = "待确认收货";
			break;
		case FINISHED:
			cn = "交易完成";
			break;
		case CANCELLED:
			cn = "交易取消";
			break;
		case OTHER:
			cn = "全部";
			break;
		}
		return cn;
	}

	public String fontColor() {
		String c = "";
		switch (this) {
		case NOT_DELIVERED:
			c = "co";
			break;
		case NOT_RECEIVED:
			c = "ca";
			break;
		case FINISHED:
			c = "cg";
			break;
		case CANCELLED:
			c = "cr";
			break;
		}
		return c;
	}

	public String getDescription() {
		String descr = this.cnName();
		switch (this) {
		case NOT_PAID:
			descr = "买家未付款";
			break;
		case NOT_DELIVERED:
			descr = "买家已付款，等待卖家发货";
			break;
		case NOT_RECEIVED:
			descr = "卖家已发货，等待买家确认收货";
			break;
		case FINISHED:
			descr = "交易已完成";
			break;
		case CANCELLED:
			descr = "交易关闭";
			break;
		}
		return descr;
	}

}
