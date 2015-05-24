package models.order;

import java.util.List;

import javax.persistence.Entity;

import org.apache.commons.lang.StringUtils;

import models.BaseModel;

@Entity
public class Location extends BaseModel {

	public String address;

	public static Location createOne(String address) {
		Location location = new Location();
		location.address = address;
		return location.save();
	}

	public void deleteOne() {
		this.isDeleted = true;
		this.save();
	}

	public static List<Location> fectcAllLocations() {
		return find(getDefaultContitionSql("isDeleted = false")).fetch();

	}

	public static List<Location> fetchLocations(String address, int page,
			int pageSize) {
		String hql = " isDeleted = false ";
		if (StringUtils.isNotBlank(address)) {
			hql += " and address like '%" + address + "%'";
		}
		return find(hql).fetch(page, pageSize);
	}

	public static int locationCount(String address, int page, int pageSize) {
		return fetchLocations(address, page, pageSize).size();
	}
}
