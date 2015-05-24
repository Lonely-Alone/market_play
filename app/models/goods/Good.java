package models.goods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import jpaListeners.GoodListener;
import models.BaseModel;

import org.apache.commons.lang.StringUtils;

@Entity
@EntityListeners(GoodListener.class)
public class Good extends BaseModel {
	public enum GoodPlace {
		个人馆, 企业馆, 生活馆, 爆款
	}

	@ManyToOne
	public GoodType type;
	@Enumerated(EnumType.STRING)
	public GoodPlace place;
	public String name;
	public String chief;// 简单描述
	@Lob
	public String descr;// 详细描述
	public String previewURL;// 预览图，1:1
	public String imageURL;// 主图， 3:1

	public boolean inSold;// 在售
	public int leftCount;// 库存
	public int soldCount;// 已销售
	public int limitCount;// 限购数量
	// 参考价（单位：分，避免浮点运算）
	public int showPrice;
	// 实际价格（单位：分，避免浮点运算）
	public int realPrice;
	public String goodSerial;

	public static List<Good> fetchGoods(String name, Boolean inSold,
			int pagesize, int page) {
		String hql = "isDeleted=false";
		if (inSold != null) {
			hql += " and inSold=" + inSold.toString();
		}
		if (StringUtils.isNotBlank(name)) {
			hql += " and name like '" + name + "'";
		}

		hql += " order by createTime desc";
		return Good.find(hql).fetch(page, pagesize);
	}

	public static int countGoods(String name, Boolean inSold) {
		String hql = "isDeleted=false";
		if (inSold != null) {
			hql += " and inSold=" + inSold.toString();
		}
		if (StringUtils.isNotBlank(name)) {
			hql += " and name like '" + name + "'";
		}
		return (int) Good.count(hql);
	}

	public static Good createOne() {
		return new Good().save();
	}

	/*** 实例方法 ***/
	public void updateAttributes(String name, String chief, int showPrice,
			int realPrice, int leftCount, int limitCount, String descr,
			boolean isPublished, String imageURL, String previewURL,
			List<String> picUrls, long goodTypeId, GoodPlace goodPlace) {
		this.name = name;
		this.chief = chief;
		this.showPrice = showPrice;
		this.realPrice = realPrice;
		this.leftCount = leftCount;
		this.limitCount = limitCount;
		this.descr = descr;
		inSold = isPublished;
		this.imageURL = imageURL;
		this.previewURL = previewURL;
		this.type = GoodType.findByTypeId(goodTypeId);
		this.place = goodPlace;
		this.save();
		if (null != picUrls) {
			Attachment.updateGoodPictures(this, picUrls);
		}
	}

	public void removeOne() {
		// 相关的orderItem不删除
		// 相关的attachment不删除
		isDeleted = true;
		this.save();
	}

	public void addGood(int count) {
		leftCount += count;
		soldCount -= count;
		this.save();
	}

	// 爆款
	public static Good findHotSale() {
		return find(getDefaultContitionSql("isDeleted = false and place = ?"),
				GoodPlace.爆款).first();
	}

	public static List<Good> fetchByConditions(String name, long typeId,
			GoodPlace place, int page, int pageSize) {
		List<Object> paraList = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer(
				"select g from Good g where g.isDeleted = false and g.inSold=true ");
		if (StringUtils.isNotBlank(name)) {
			sb.append(" and g.name like ?");
			paraList.add("%" + name + "%");
		}
		if (typeId != 0) {
			sb.append(" and g.type.id = ?");
			paraList.add(typeId);
		}
		if (StringUtils.isNotBlank(place.toString())) {
			sb.append(" and g.place = ?");
			paraList.add(place);
		}
		sb.append("order by g.createTime desc");
		return Good.find(sb.toString(), paraList.toArray()).fetch(page,
				pageSize);
	}

	public static int countGoods(String name, long typeId, GoodPlace place,
			int page, int pageSize) {
		return fetchByConditions(name, typeId, place, page, pageSize).size();
	}

	public static List<Good> fetchGoodsByIds(List<Long> ids) {
		if (ids.size() == 0) {
			return Collections.EMPTY_LIST;
		}
		return find(
				"select g from Good g where g.isDeleted = false and g.id in (:ids) order by g.createTime desc")
				.bind("ids", ids.toArray()).fetch();

	}

	public static List<GoodType> fetchTypesByPlce(GoodPlace place) {
		return find(
				"select distinct(g.type) from Good g where g.isDeleted = false and g.place = ?",
				place).fetch();

	}

}
