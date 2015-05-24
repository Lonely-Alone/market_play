package models.order;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import models.BaseModel;

import org.apache.commons.lang.StringUtils;

@Entity
public class Invoice extends BaseModel {

	public String title;
	public String content;

	@Enumerated(EnumType.STRING)
	public InvoiceType invoiceType;// 发票类型

	public enum InvoiceType {
		普通发票, 增值税发票, 无需发票;
	}

	public static Invoice createInvoice(String invoiceType) {
		Invoice invoice = new Invoice();
		if (StringUtils.isNotBlank(invoiceType)) {
			invoice.invoiceType = InvoiceType.valueOf(invoiceType);
		}
		return invoice.save();
	}

	public void updateInvoiceType(String type) {
		this.invoiceType = InvoiceType.valueOf(type);
		this.save();
	}

	public void updateInvoice(String title, String content) {
		this.content = content;
		if (!content.equals("不开发票")) {
			this.title = title;
		}
		this.save();
	}
}
