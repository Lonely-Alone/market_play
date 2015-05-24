package jpaListeners;

import java.util.Date;

import javax.persistence.PreUpdate;

import models.BaseModel;

public class BaseModelListener {

	@PreUpdate
	public static void preUpdate(BaseModel baseModel) {

		baseModel.lastModifyTime = new Date();
	}

}