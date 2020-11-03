package org.kevinzuhoski.japaneserestaurant.models;

import java.util.Date;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Inquiry entity with OneToOne relationship to inquiryReason entity and ManyToOne relationship
// to the customer entity
//Table name, column names, constructors, and setters/getters provided

@Entity
@Table(name="inquiries")
public class Inquiry {
	
	@Id
	@Column(name="inquiry_id", nullable=false, table="inquiries")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer inquiryId;
	
	@OneToOne
	@JoinColumn(name="inquiry_reason_id", referencedColumnName="inquiry_reason_id", nullable=false, table="inquiries")
	private InquiryReason inquiryReason;
	
	@Column(name="inquiry_information", nullable=false, table="inquiries")
	private String inquiryInformation;
	
	@Column(name="inquiry_date", nullable=false, table="inquiries")
	private Date inquiryDate;
	
	@ManyToOne
	@JoinColumn(name="customer_id", referencedColumnName="customer_id", nullable=false, table="inquiries")
	private Customer customer;
	
	@Column(name="visit_history", nullable=false, table="inquiries")
	private char visitHistory;
	
	@Column(name="contact_days", nullable=false, table="inquiries")
	private String contactDays;
	
	public Inquiry() {
		
	}
	
	public Inquiry(InquiryReason inquiryReason, String inquiryInformation, Date inquiryDate, Customer customer,
			char visitHistory, String contactDays) {
		super();
		this.inquiryReason = inquiryReason;
		this.inquiryInformation = inquiryInformation;
		this.inquiryDate = inquiryDate;
		this.customer = customer;
		this.visitHistory = visitHistory;
		this.contactDays = contactDays;
	}

	public Integer getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(Integer inquiryId) {
		this.inquiryId = inquiryId;
	}

	public InquiryReason getInquiryReason() {
		return inquiryReason;
	}

	public void setInquiryReason(InquiryReason inquiryReason) {
		this.inquiryReason = inquiryReason;
	}

	public String getInquiryInformation() {
		return inquiryInformation;
	}

	public void setInquiryInformation(String inquiryInformation) {
		this.inquiryInformation = inquiryInformation;
	}

	public Date getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public char getVisitHistory() {
		return visitHistory;
	}

	public void setVisitHistory(char visitHistory) {
		this.visitHistory = visitHistory;
	}

	public String getContactDays() {
		return contactDays;
	}

	public void setContactDays(String contactDays) {
		this.contactDays = contactDays;
	}
	
	
	
	
	
}
