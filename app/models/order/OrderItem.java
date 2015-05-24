package models.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import models.BaseModel;
import models.enums.OrderStatus;
import models.goods.Good;
import models.goods.Good.GoodPlace;
import models.person.Member;

@Entity
public class OrderItem extends BaseModel {
	@ManyToOne
	public OrderSum orderSum;
	@ManyToOne
	public Good good;
	public int amount;
	public int soldPrice;// 交易时使用的真实单价，单位是分（主要是用于区别抢购时的HotBuy.hotPrice）

	public static OrderItem createOne(OrderSum orderSum, Good good, int amount,
			int soldPrice) {
		OrderItem item = new OrderItem();
		item.orderSum = orderSum;
		item.good = good;
		item.amount = amount;
		item.soldPrice = soldPrice;
		item.save();
		good.addGood(-1 * amount);// 商品数量减一（若订单取消，则数量加一）
		return item;
	}

	public static OrderItem findByOrderId(long orderId) {
		return find(getDefaultContitionSql("id=?"), orderId).first();
	}

	public static List<OrderItem> fetchBySum(OrderSum orderSum) {
		return find(getDefaultContitionSql("orderSum=?"), orderSum).fetch();
	}

	public static Map<Long, List<OrderItem>> fetchBySums(
			List<OrderSum> orderSums) {
		Map<Long, List<OrderItem>> map = new HashMap();
		for (OrderSum sum : orderSums) {
			map.put(sum.id, Collections.EMPTY_LIST);
		}
		if (!orderSums.isEmpty()) {
			List<OrderItem> items = find(
					getDefaultContitionSql("orderSum in (:sumList)")).bind(
					"sumList", orderSums.toArray()).fetch();
			for (OrderItem item : items) {
				if (map.get(item.orderSum.id).isEmpty()) {
					map.put(item.orderSum.id, new ArrayList());
				}
				map.get(item.orderSum.id).add(item);
			}
		}
		return map;
	}

	// 以下方法用于纠正旧数据
	public static void calculate() {
		List<OrderItem> items = OrderItem.find(
				getDefaultContitionSql("orderSum.status !=? "),
				OrderStatus.CANCELLED).fetch();
		Map<Good, Integer> countMap = new HashMap();
		for (OrderItem item : items) {
			Integer c = countMap.get(item.good);
			if (null == c) {
				c = 0;
			}
			countMap.put(item.good, c + item.amount);
		}
		for (Map.Entry<Good, Integer> e : countMap.entrySet()) {
			e.getKey().addGood(e.getValue() * -1);
		}
	}

	public static void initPrice() {
		for (OrderItem item : OrderItem.find("isDeleted=false")
				.<OrderItem> fetch()) {
			if (item.soldPrice == 0) {
				item.soldPrice = 1;
				item.save();
			}
		}
	}

	public static List<OrderItem> getFromListByPlace(List<OrderItem> list,
			GoodPlace place) {
		List<OrderItem> itemList = new ArrayList<OrderItem>();
		for (OrderItem item : list) {
			if (item.good.place == place) {
				itemList.add(item);
			}
		}
		return itemList == null ? Collections.EMPTY_LIST : itemList;

	}

	public static long fetchAmountByOwnerAndGood(Member member, Good good) {
		Long num = OrderItem
				.find("select sum(it.amount) from OrderItem it where it.isDeleted = false and  it.orderSum.isDeleted = false and it.orderSum.owner=? and it.good = ? ",
						member, good).first();
		return num==null?0:num;

	}
}
