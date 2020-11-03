package org.kevinzuhoski.japaneserestaurant.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//InquiryReason entity
//Table name, column names, constructors, and setters/getters provided


@Entity
@Table(name="inquiry_reasons")
public class InquiryReason {
	
	@Id
	@Column(name="inquiry_reason_id", nullable=false, table="inquiry_reasons")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer inquiryReasonId;
	
	@Column(name="option_name", nullable=false, table="inquiry_reasons")
	private String optionName;

	public InquiryReason() {
		
	}
	
	public InquiryReason(String optionName) {
		super();
		this.optionName = optionName;
	}

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
