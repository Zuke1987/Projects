package org.kevinzuhoski.japaneserestaurant.models.dto;


// //InquiryReasonDTO class for transferring InquiryReason data to separate InquiryReason Entity from InquiryReason data transferred. 

public class InquiryReasonDTO {
	private Integer inquiryReasonId;
	private String optionName;
	
	public Integer getInquiryReasonId() {
		return inquiryReasonId;
	}
	public void setInquiryReasonId(Integer inquiryReasonId) {
		this.inquiryReasonId = inquiryReasonId;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
}
