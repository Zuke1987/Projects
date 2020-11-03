package org.kevinzuhoski.japaneserestaurant.models.dto;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Size;

//InquiryDTO class for transferring inquiry data to separate Inquiry Entity from Inquiry data transferred. 
//Validation such as @Size used to give a minimum size for number of contact days selected.  

public class InquiryDTO {
	
	private Integer inquiryId;
	
	private InquiryReasonDTO inquiryReason;
	
	private String inquiryInformation;
	
	private Date inquiryDate;
	
	@Valid
	private CustomerDTO customer;
	
	private char visitHistory;
	
	@Size(min = 1, message = "Please select at least one day")
	private String[] contactDays;

	public Integer getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(Integer inquiryId) {
		this.inquiryId = inquiryId;
	}

	public InquiryReasonDTO getInquiryReason() {
		return inquiryReason;
	}

	public void setInquiryReason(InquiryReasonDTO inquiryReason) {
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

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public char getVisitHistory() {
		return visitHistory;
	}

	public void setVisitHistory(char visitHistory) {
		this.visitHistory = visitHistory;
	}

	public String[] getContactDays() {
		return contactDays;
	}

	public void setContactDays(String[] contactDays) {
		this.contactDays = contactDays;
	}
	
}
