package models.goods;

import java.util.List;

import javax.persistence.Entity;

import models.BaseModel;

import org.apache.commons.lang.StringUtils;

@Entity
public class GoodType extends BaseModel {
	public String name;

	public static GoodType createOne(String name) {
		GoodType type = GoodType.findByTypeName(name);
		if (type == null) {
			type = new GoodType();
			type.name = name;
		} else {
			if (type.isDeleted = true) {
				type.isDeleted = false;
			}
		}

		return type.save();
	}

	public void updateOne(String name) {
		this.name = name;
		this.save();
	}

	public void deleteOne() {
		this.isDeleted = true;
		this.save();
	}

	public static GoodType findByTypeId(long typeId) {
		GoodType type = GoodType.find(getDefaultContitionSql("id=?"), typeId)
				.first();
		return type == null ? null : type;
	}

	public static GoodType findByTypeName(String name) {
		return GoodType.find(getDefaultContitionSql("name=?"), name).first();
	}

	public static List<GoodType> fetchTypes(String name, int page, int pageSize) {
		String hql = " isDeleted = false ";
		if (StringUtils.isNotBlank(name)) {
			hql += " and name like '%" + name + "%'";
		}
		return GoodType.find(hql).fetch(page, pageSize);

	}

	public static List<GoodType> fetchGoodTypes() {
		return GoodType.find(getDefaultContitionSql("isDeleted = false"))
				.fetch();

	}

	public static int typeCount(String name, int page, int pageSize) {
		return fetchTypes(name, page, pageSize).size();

	}
}