package org.kevinzuhoski.japaneserestaurant.repositories;

import java.util.List;

import org.kevinzuhoski.japaneserestaurant.models.InquiryReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// InquiryReasonRepository 

@Repository
public interface InquiryReasonRepository extends JpaRepository<InquiryReason, Integer> {
	
	public List<InquiryReason> findByInquiryReasonId(Integer inquiryReasonId);
	
}
