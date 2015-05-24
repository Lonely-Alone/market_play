package jpaListeners;

import javax.persistence.PostPersist;

import models.goods.Good;
import play.templates.JavaExtensions;

/**
 * @author mayan
 */
public class GoodListener {
	@PostPersist
	public static void postPersist(Good good) {
		good.goodSerial = JavaExtensions.format(good.id, "000000000");
	}
}
