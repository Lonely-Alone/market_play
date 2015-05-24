package models;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@MappedSuperclass
public class BaseLog extends Model {
	@Temporal(TemporalType.TIMESTAMP)
	public Date createTime = new Date();
	public long excutorId;
}
