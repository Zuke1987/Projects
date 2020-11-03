package org.kevinzuhoski.japaneserestaurant.services;

import java.util.List;
import java.util.Map;

import org.kevinzuhoski.japaneserestaurant.models.dto.InquiryDTO;
import org.kevinzuhoski.japaneserestaurant.models.dto.InquiryReasonDTO;


/**
 * This interface contains methods for CRUD functions related to making inquiries via the contact form
 * @author kevinzuhoski
 *
 */
public interface ContactService {
	
	
	/**
	 * This method creates an inquiry made by the user
	 * @param user
	 */
	public boolean createInquiry(InquiryDTO inquiry);
	
	/**
	 * This method gets all of the possible inquiryReasons
	 * @param user
	 */
	public List<InquiryReasonDTO> getAllInquiryReason();
}
