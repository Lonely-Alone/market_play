package models.order;

import japidviews._javatags.CommonUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import models.BaseModel;
import models.enums.OrderStatus;
import models.goods.Good;
import models.person.Admin;
import models.person.Member;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.hibernate.Session;

import play.data.binding.As;
import play.db.jpa.JPA;

/**
 * 某个用户的购物车对象，作为OrderItem的FK
 */
@Entity
public class OrderSum extends BaseModel {

	public enum PayMode {
		货到付款, 微信支付
	}

	public enum DeliverMode {
		普通快递, 到点自提
	}

	@ManyToOne
	public Member owner;
	@ManyToOne
	public Admin shop;// 一个订单归属于一个商店

	public String orderSerial;// 订单号
	public String transId;// 交易号（微信支付后生成，用于发货、查询等接口传参）

	public String chief;// 订单描述、名称
	@Lob
	public String memo;// 备注
	@Enumerated(EnumType.STRING)
	public PayMode payMode;// 付款方式
	@Enumerated(EnumType.STRING)
	public DeliverMode deliverMode;// 配送方式
	@ManyToOne
	public Location location;// 自提地点
	@Temporal(TemporalType.TIMESTAMP)
	public Date paidTime;// 付款时间
	@Temporal(TemporalType.TIMESTAMP)
	public Date deliveredTime;// 发货日期
	@Temporal(TemporalType.TIMESTAMP)
	public Date receivedTime;// 收货日期
	@Enumerated(EnumType.STRING)
	public OrderStatus status = OrderStatus.NOT_SUB;

	@OneToOne
	public Invoice invoice;

	// copied from Address
	public String addressName;
	public String addressCellphone;
	public String addressAddress;
	public String addressPostCode;

	public int points;// 使用的积分
	public int sumPrice;// 订单总价

	public String password;// 取货的密码

	public Boolean isConfirmed = false;

	public String prepay_id;//

	// copied from Address

	/** 静态方法 **/
	public static OrderSum createOne(Member owner) {
		OrderSum sum = new OrderSum();
		sum.owner = owner;
		Address defAdd = Address.findDefaultAddressByOwner(owner);
		sum.setAddress(defAdd);
		sum.invoice = Invoice.createInvoice("");
		sum.payMode = PayMode.微信支付;
		sum.deliverMode = DeliverMode.普通快递;
		sum.create();
		sum.genOrderSerial();
		return sum;
	}

	public void setAddress(Address address) {
		if (address != null) {
			this.addressAddress = address.location + " " + address.address;
			this.addressCellphone = address.cellphone;
			this.addressName = address.name;
			this.addressPostCode = address.postCode;
			this.save();
		}
	}

	public void savePrepay(String prepay_id) {
		this.prepay_id = prepay_id;
		this.save();
	}

	public void saveDeliverMode(OrderSum orderSum, String payMode,
			String deliverMode, Date time, Long locationId) {
		if (payMode.equals("货到付款")) {
			this.updatePayMode(PayMode.货到付款);
		} else {
			this.updatePayMode(PayMode.微信支付);
		}
		if (deliverMode.equals("普通快递")) {
			this.updateDeliverMode(DeliverMode.普通快递);
		} else {
			this.updateDeliverMode(DeliverMode.到点自提);
			this.receivedTime = time;
			this.location = Location.findById(locationId);
		}
		this.password = RandomStringUtils.randomNumeric(12);
		this.save();
	}

	public static OrderSum findOneById(long id) {
		OrderSum s = findById(id);
		return null == s || s.isDeleted ? null : s;
	}

	public static OrderSum findOneByGoodAndStatus(long id) {
		OrderSum s = findById(id);
		return null == s || s.isDeleted ? null : s;
	}

	/**
	 * 取货验证
	 * 
	 * @param id
	 * @return
	 */
	public static OrderSum findOneByPassword(String pass) {
		OrderSum s = find(getDefaultContitionSql("password=?"), pass).first();
		return s == null ? null : s;
	}

	public static OrderSum findOneByTransId(String transId) {
		return find(getDefaultContitionSql("transId=?"), transId).first();
	}

	public static OrderSum findOneByOrderSerial(String orderSerial) {
		return find(getDefaultContitionSql("orderSerial=?"), orderSerial)
				.first();
	}

	public static List<OrderSum> fetchByOwner(Member owner, int page,
			int pageSize) {
		return find(
				getDefaultContitionSql("owner=? and status <> ? order by createTime desc"),
				owner, OrderStatus.NOT_SUB).fetch(page, pageSize);
	}

	public static List<OrderSum> fetchOrderSums(OrderStatus orderStatus,
			String orderSerial, String goodName, Date beginTime, Date endTime,
			int pageSize, int page) {
		List<Object> params = new ArrayList();
		StringBuffer hql = new StringBuffer("");
		if (StringUtils.isNotBlank(goodName)) {
			hql.append("select s from OrderSum s, OrderItem i where s=i.orderSum and i.good.name like? and s.isDeleted=false and i.isDeleted=false ");
			params.add("%" + goodName + "%");
		} else {
			hql.append("select s from OrderSum s where s.isDeleted=false ");
		}
		hql.append(" and s.orderSerial like? ");
		params.add("%" + orderSerial + "%");

		if (orderStatus != OrderStatus.OTHER) {
			hql.append(" and s.status=? ");
			params.add(orderStatus);
		}

		if (null != beginTime) {
			hql.append("and s.createTime>=? ");
			params.add(beginTime);
		}

		if (null != endTime) {
			hql.append("and s.createTime<? ");
			params.add(endTime);
		}
		hql.append("order by s.createTime desc");
		return find(hql.toString(), params.toArray()).fetch(page, pageSize);
	}

	public static long countAllByOwner(long ownerId) {
		return count(getDefaultContitionSql("owner.id=?"), ownerId);
	}

	public static int countOrderSums(OrderStatus orderStatus,
			String orderSerial, String goodName, Date beginTime, Date endTime) {
		List<OrderSum> list = fetchOrderSums(orderStatus, orderSerial,
				goodName, beginTime, endTime, Integer.MAX_VALUE, 1);
		return list.size();
	}

	/**
	 * 交易完成了的商品统计
	 */
	public static Map<Long, Long> getSoldCount(List<Good> goods) {
		Map<Long, Long> map = new HashMap();
		if (!goods.isEmpty()) {
			String hql = "select i.good, sum(i.amount) from OrderItem i where i.good in (:goods) and i.orderSum.status=(:stat) and i.isDeleted=false group by i.good ";
			List<Object[]> results = OrderSum.find(hql)
					.bind("goods", goods.toArray())
					.bind("stat", OrderStatus.FINISHED).fetch();
			for (Object[] objs : results) {
				map.put(((Good) objs[0]).id, (Long) objs[1]);
			}
		}
		return map;
	}

	// 返回2个小时未提交或未付款的订单
	public static List<OrderSum> fetchUnSubOrder() throws Exception {
		long time = System.currentTimeMillis() - 2 * 60 * 60000;
		return OrderSum
				.find("select os from OrderSum os where os.isDeleted=false  and UNIX_TIMESTAMP(os.createTime)*1000 <= ? and (os.status=? or os.status=?)",
						time, OrderStatus.NOT_PAID, OrderStatus.NOT_SUB)
				.fetch();
	}

	public static void cancelOrders() throws Exception {
		List<OrderSum> orders = fetchUnSubOrder();
		for (OrderSum orderSum : orders) {
			orderSum.isDeleted = true;
			if (orderSum.points != 0) {
				orderSum.owner.addPoints(orderSum.points);
			}
			orderSum.save();
			for (OrderItem item : OrderItem.fetchBySum(orderSum)) {
				item.good.addGood(item.amount);
			}
		}
	}

	/***************************** 实例方法 ******************************/

	public void updateStatus(OrderStatus status) {
		this.status = status;
		this.save();
	}

	/**
	 * 选择支付方式
	 *
	 * @param payMode
	 */
	public void updatePayMode(PayMode payMode) {
		this.payMode = payMode;
		if (PayMode.货到付款 == payMode) {// 如果是活到付款，则默认选择支付方式时就默认付款
			status = OrderStatus.NOT_DELIVERED;
		}
		this.save();
	}

	/**
	 * 选择支付方式
	 *
	 * @param payMode
	 */
	public void updateDeliverMode(DeliverMode deliverMode) {
		this.deliverMode = deliverMode;
		this.save();
	}

	/**
	 * 请注意：金钱单位是分！
	 */
	public int getCost() {
		return this.sumPrice - this.points;
	}

	/**
	 * 订单状态的如下依次改变：<br/>
	 * 1. OrderStatus.未支付<br/>
	 * 2. OrderStatus.未发货 == 已支付(买家选择支付方式)<br/>
	 * 3. OrderStatus.未确认收货 == 已发货(卖家发货)<br/>
	 * 4. OrderStatus.交易完成 == 已收货(买家确认收货)<br/>
	 */
	public OrderStatus getStatus() {
		return status;
	}

	/**
	 * 生成订单号（规则目前未定，测试暂定13位，"TEST"+(9位id)形式）
	 */
	public void genOrderSerial() {
		orderSerial = "TEST" + CommonUtils.formatNumber(id, "000000000");
		this.save();
	}

	/**
	 * 提交订单
	 */
	public void submit(int usePoints) {
		this.status = OrderStatus.NOT_PAID;
		this.points = usePoints;
		this.save();
	}

	public void sumPrice(int price) {
		this.sumPrice += price;
		this.save();
	}

	/**
	 * 支付，并保存微信支付成功后的交易号（用于处理支付发货、维权等接口）（wc支付接口回执成功以后，调用此方法）
	 *
	 * @param transId
	 *            支付成功后返回的交易号
	 */
	public void pay(PayNotify payNotify) {
		try {
			paidTime = new SimpleDateFormat("yyyyMMddmmHHss")
					.parse(payNotify.time_end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.transId = payNotify.transaction_id;
		status = OrderStatus.NOT_DELIVERED;
		this.save();
		owner.increasePoint(getCost());
	}

	/**
	 * 发货（支付成功以后，商户发货调用此方法）
	 */
	public void deliver(Date deliverTime) {
		deliveredTime = deliverTime;
		status = OrderStatus.NOT_RECEIVED;
		this.save();
	}

	/**
	 * 确认收货
	 */
	public void confirmReceived() {
		receivedTime = new Date();
		status = OrderStatus.FINISHED;
		this.save();
	}

	/**
	 * 取消订单
	 */
	public void cancel() {
		status = OrderStatus.CANCELLED;
		this.save();
		for (OrderItem item : OrderItem.fetchBySum(this)) {
			item.good.addGood(item.amount);
		}
	}

	public String showPass() {
		if (StringUtils.isNotBlank(this.password)) {
			return this.password.substring(0, 4) + "&nbsp;"
					+ this.password.substring(4, 8) + "&nbsp;"
					+ this.password.substring(8);
		}
		return "";
	}
}
