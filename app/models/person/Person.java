package models.person;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import models.BaseModel;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author xuyuzhu
 */
@Entity
public class Person extends BaseModel {
	public String loginName;
	public String password;
	public String avatarURL;
	public long points;// VIP积分
	public long totalPoints;// VIP积分
	@Temporal(TemporalType.TIMESTAMP)
	public Date lastLoginTime;

	/*** 静态方法 ***/
	public static Person login(String loginName, String pwd) {
		return find(getDefaultContitionSql(" loginName=? and password=?"),
				loginName, DigestUtils.md5Hex(pwd)).first();
	}

	public static <T extends Person> T findOneById(long id) {
		T p = Person.<T> findById(id);
		return null != p && !p.isDeleted ? p : null;
	}

	public static Person findOneByLoginName(String loginName) {
		return find(getDefaultContitionSql("loginName=?"), loginName).first();
	}

	/*** 实例方法 ***/
	public void updateLoginTime() {
		this.lastLoginTime = new Date();
		this.save();
	}

	public boolean validatePwd(String pwd) {
		if (this.password.equals(DigestUtils.md5Hex(pwd))) {
			return true;
		} else {
			return false;
		}
	}

	public void updatePassword(String pwd) {
		this.password = DigestUtils.md5Hex(pwd);
		this.save();
	}

	public void addPoints(long points) {
		this.points += points;
		this.save();
	}

	public void addTotalPoints(long points) {
		this.points += points;
		if (points > 0) {
			this.totalPoints += points;
		}
		this.save();
	}

}
