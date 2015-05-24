package models.sever;

import japidviews._javatags.CommonUtils;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.Logger;
import models.BaseModel;
import models.order.Invoice;
import models.order.Invoice.InvoiceType;
import models.person.Member;

@Entity
public class Consult extends BaseModel {

	public String name;
	public String description;
	public int num;
	public String picUrl;
	public String priceRange;
	public String contactPerson;
	public String contactNum;
	public String contactAddress;
	public String zipCode;// 邮编
	public String remarks;// 备注

	@OneToOne
	public Invoice invoice;

	@ManyToOne
	public Member member;

	@Enumerated(EnumType.STRING)
	public ConsultType type;

	@Enumerated(EnumType.STRING)
	public ContactType contactType;

	//
	public enum ConsultType {
		inquiry, wanted;
		public static ConsultType convert2Enum(String type) {
			if (type.equals("询价")) {
				return ConsultType.inquiry;
			} else if (type.equals("求购")) {
				return ConsultType.wanted;
			}
			return null;
		}
	}

	public enum ContactType {
		pub {
			@Override
			public String getName() {
				return "公开";
			}
		},
		semi {
			@Override
			public String getName() {
				return "报价后公开";
			}
		},
		priv {
			@Override
			public String getName() {
				return "不公开";
			}
		};
		public abstract String getName();

		public static ContactType convert2Enum(String type) {
			if (type == null) {
				return ContactType.pub;
			} else if (type.equals("报价后公开")) {
				return ContactType.semi;
			} else if (type.equals("不公开")) {
				return ContactType.priv;
			} else {
				return ContactType.pub;
			}
		}

	}

	public Consult() {

	}

	public static Consult createConsult() {
		Consult consult = new Consult();
		return consult.save();
	}

	public void updateConsult(String name, String description, int num,
			String picUrl, String priceRange, String contactPerson,
			String contactNum, String contactAddress, String zipCode,
			String remarks, String invoiceType, String consultType,
			String contactType, Member member) {
		this.name = name;
		this.description = description;
		this.num = num;
		this.picUrl = picUrl;
		this.priceRange = priceRange;
		this.contactAddress = contactAddress;
		this.contactNum = contactNum;
		this.contactPerson = contactPerson;
		this.zipCode = zipCode;
		this.remarks = remarks;

		if ("询价".equals(consultType.trim())) {
			this.invoice = Invoice.createInvoice(invoiceType);
		}
		this.type = ConsultType.convert2Enum(consultType);
		this.member = member;
		this.contactType = ContactType.convert2Enum(contactType);
		this.save();
	}

	public void removeConsult() {
		this.isDeleted = true;
		this.save();
	}

	public static Consult findByConsultId(long consultId) {
		return Consult.find(getDefaultContitionSql("id=?"), consultId).first();
	}

	public static List<Consult> fecthByPerson(Member member, int page,
			int pageSize) {
		return Consult
				.find("select c from Consult c where c.isDeleted=false and c.member=?",
						member).fetch(page, pageSize);
	}

	public static List<Consult> fecthConsults(int page, int pageSize) {
		return Consult
				.find("select c from Consult c where c.isDeleted = false order by createTime desc")
				.fetch(page, pageSize);
	}

	public static int countConsult(int page, int pageSize) {
		return fecthConsults(page, pageSize).size();
	}

	public static int countConsultByMember(Member member, int page, int pageSize) {
		return fecthByPerson(member, page, pageSize).size();

	}

}
