package models.goods;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import models.BaseModel;

@Entity
public class Attachment extends BaseModel {
	public String url;
	@ManyToOne
	public Good good;

	public static List<Attachment> fetchPictuesByGood(long goodId) {
		return find(getDefaultContitionSql("good.id=?"), goodId).fetch();
	}

	public static Attachment createPicture(Good good, String url) {
		Attachment a = new Attachment();
		a.good = good;
		a.url = url;
		return a.save();
	}

	public static void updateGoodPictures(Good good, List<String> picUrls) {
		for (Attachment a : fetchPictuesByGood(good.id)) {
			a.isDeleted = true;
			a.save();
		}
		for (int i = 0; i < picUrls.size(); i++) {
			Attachment.createPicture(good, picUrls.get(i));
		}
	}
}
