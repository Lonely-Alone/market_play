package models.person;

import japidviews._javatags.CommonUtils;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.commons.lang.StringUtils;

import play.Logger;

/**
 * 会员用户
 */
@Entity
public class Member extends Person {

	public String openId;// 唯一对应微信的用户OpenId
	private String nickName;
	public String city;
	public String country;
	public String province;
	public String language;
	public Date subscribeTime;
	public boolean hasSubscribed;
	@Enumerated(EnumType.STRING)
	public Sex sex;
	private String vipSerial;// 会员ID

	public enum Sex {
		Female, Male, Unknown
	}

	public static Member findByOpenId(String openId) {
		Member member = null;
		member = find(getDefaultContitionSql("openId=?"), openId).first();
		return member;
	}

	public static Member findMemberById(long memberId) {
		return find(getDefaultContitionSql("id=?"), memberId).first();
	}

	public static Member registerByOpenId(String openId) {
		Member member = findByOpenId(openId);
		if (null == member) {
			member = new Member();
			member.openId = openId;
			member.create();
			member.vipSerial = member.genVIPSerial();
			member.save();
			// 前2000名注册用户送500积分
			if (member.id <= 2000) {
				member.points = 500;
				member.totalPoints = 500;
				member.save();
			}
			Logger.warn("register member by openId: " + openId);
		}
		return member;
	}

	public static List<Member> fetchMembers(String nickName, int page,
			int pageSize) {
		if (StringUtils.isBlank(nickName)) {
			return find(
					getDefaultContitionSql("openId is not null order by points desc, createTime desc"))
					.fetch();
		} else {
			return find(
					getDefaultContitionSql("nickName like? and openId is not null order by points desc, createTime desc"),
					"%" + nickName + "%").fetch(page, pageSize);
		}
	}

	/**
	 * 积分排名
	 */
	public static int getRank(Member member) {
		List<Member> members = find(
				"openId is not null and isDeleted=false order by points desc, createTime desc")
				.fetch();
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).id.equals(member.id)) {
				return i + 1;
			}
		}
		return -1;
	}

	public static long countAll() {
		return count("isDeleted=false");
	}

	/****** 实例方法 ******/

	/**
	 * 增加积分(通过付款时商品的价格换取积分, 1分人民币的=1积分，积分兑换现金参考具体方法this.getPointsExchange())
	 */
	public void increasePoint(long delta) {
		points += delta;
		this.save();
	}

	/**
	 * 8位会员编号
	 */
	private String genVIPSerial() {
		return CommonUtils.formatNumber(id, "00000000");
	}

	public String vipSerial() {
		if (StringUtils.isBlank(vipSerial)) {
			vipSerial = genVIPSerial();
			this.save();
		}
		return vipSerial;
	}

	/**
	 * <p>
	 * VIP等级
	 * </p>
	 * LV0 0~999 <br/>
	 * LV1 1000~4999 <br/>
	 * LV2 5000~14999 <br/>
	 * LV3 15000~29999 <br/>
	 * LV4 30000~49999 <br/>
	 * LV5 50000~99999 <br/>
	 * LV6 100000~ <br/>
	 */
	public int getLevel() {
		long points = totalPoints / 100;
		if (points < 5000) {
			return 1;
		} else if (points < 15000) {
			return 2;
		}
		if (points < 30000) {
			return 3;
		} else if (points < 50000) {
			return 4;
		} else if (points < 100000) {
			return 5;
		} else {
			return 6;
		}
	}

	/**
	 * 积分兑换现金规则（目前是：100个积分兑换1元人民币）
	 */
	public double getPointsExchange() {
		return points / 100.0;
	}

	public String getVipSerail() {
		return this.vipSerial;
	}
}
