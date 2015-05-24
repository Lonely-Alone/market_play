package models.order;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import models.BaseModel;
import models.person.Member;

@Entity
public class Address extends BaseModel {
	@ManyToOne
	public Member owner;

	public boolean isDefault = false;
	public String name;// 收货人姓名
	public String cellphone;// 联系电话
	public String address;// 地区（省市区三级），形如"广东省-广州市-天河区"
	public String location;// 详细地址
	public String postCode;// 邮编

	public static Address createOne(Member owner, String name,
			String cellphone, String location, String address, String postCode) {
		Address a = new Address();
		a.owner = owner;
		a.name = name;
		a.cellphone = cellphone;
		a.location = location;
		a.address = address;
		a.postCode = postCode;
		return a.save();
	}

	public void updateAddress(Member owner, String name, String cellphone,
			String location, String address, String postCode) {
		this.owner = owner;
		this.name = name;
		this.cellphone = cellphone;
		this.location = location;
		this.address = address;
		this.postCode = postCode;
		this.save();
	}

	public void deleteOne() {
		this.isDeleted = true;
		this.save();
	}

	public static Address findOneById(long id) {
		Address a = findById(id);
		return null != a && !a.isDeleted ? a : null;
	}

	public static List<Address> fetchByOwnerId(long ownerId) {
		return find(
				getDefaultContitionSql("owner.id=? order by createTime desc"),
				ownerId).fetch();
	}

	public static Address findDefaultAddressByOwner(Member owner) {
		return find(
				getDefaultContitionSql("owner=? and isDefault=true order by createTime desc"),
				owner).first();
	}

	public static void modDefaultAddress(long newAddId, Member owner) {
		Address oldAdd = findDefaultAddressByOwner(owner);
		if (null != oldAdd) {
			oldAdd.isDefault = false;
			oldAdd.save();
		}
		Address newAdd = findOneById(newAddId);
		newAdd.isDefault = true;
		newAdd.save();
	}

}
