package models.order;

import groovy.transform.TimedInterrupt;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import models.BaseModel;
import models.person.Member;
import models.person.Person;

@Entity
public class Points extends BaseModel {

	public enum sourceType {
		购买产品, 技术咨询, 微社区发帖, 朋友圈转发, 平台奖励, 购物使用, 扣减货款
	}

	public long num;// 积分多少
	@ManyToOne
	public Person owner;

	@Enumerated(EnumType.STRING)
	public sourceType type;

	@ManyToOne
	public OrderSum orderSum;

	@Temporal(TemporalType.TIMESTAMP)
	public Date validDate;// 积分有效期

	public static Points createOne() {
		return new Points().save();
	}

	public void update(long num, sourceType type, Person owner) {
		this.num = num;
		this.type = type;
		this.owner = owner;
		this.save();

	}

	// 购买商品产生积分
	public static void generatePointsByOrder(OrderSum orderSum, Member owner) {
		if (orderSum.sumPrice >= 100) {
			Points points = new Points();
			points.orderSum = orderSum;
			points.num = orderSum.sumPrice / 100;
			points.type = sourceType.购买产品;
			points.owner = owner;
			points.save();
			owner.addTotalPoints(points.num);
			if (orderSum.points != 0) {
				deductionPointsByOder(orderSum, owner);
			}
		}

	}

	public static void deductionPointsByOder(OrderSum orderSum, Member owner) {
		Points points = new Points();
		points.orderSum = orderSum;
		points.num = -1 * orderSum.points;
		points.type = sourceType.扣减货款;
		points.owner = owner;
		points.save();
		owner.addPoints(points.num);
	}

	public static List<Points> fetchByMember(Person owner) {
		return find(getDefaultContitionSql("owner = ?"), owner).fetch();
	}
}
