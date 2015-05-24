package models.person;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 商铺用户
 *
 * @author Yan
 *
 */
@Entity
public class Admin extends Person {

	@Enumerated(EnumType.STRING)
	public AdminType adminType;

	public enum AdminType {
		系统管理员, 门店管理员
	}

	/*** 静态方法 ***/
	public static Admin initAdmin() {
		Admin admin = find(getDefaultContitionSql("loginName=?"), "admin")
				.first();
		if (null == admin) {
			admin = new Admin();
			admin.loginName = "admin";
			admin.password = DigestUtils.md5Hex("111111");
			admin.lastLoginTime = new Date();
			admin.save();
		}
		return admin;
	}

	public static void registerServiceAdmin() {
		Admin admin1 = find(getDefaultContitionSql("loginName=?"), "admin1")
				.first();
		if (null == admin1) {
			admin1 = new Admin();
			admin1.loginName = "admin1";
			admin1.password = DigestUtils.md5Hex("111111");
			admin1.lastLoginTime = new Date();
			admin1.adminType = AdminType.门店管理员;
			admin1.save();
		}
		Admin admin2 = find(getDefaultContitionSql("loginName=?"), "admin2")
				.first();
		if (null == admin2) {
			admin2 = new Admin();
			admin2.loginName = "admin2";
			admin2.password = DigestUtils.md5Hex("111111");
			admin2.lastLoginTime = new Date();
			admin2.adminType = AdminType.门店管理员;
			admin2.save();
		}

	}

	/*** 实例方法 ***/
	public void resetPassword() {
		password = DigestUtils.md5Hex("111111");
		this.save();
	}

	public boolean isService() {
		return this.adminType == null ? false : this.adminType
				.equals(AdminType.门店管理员);
	}
}
