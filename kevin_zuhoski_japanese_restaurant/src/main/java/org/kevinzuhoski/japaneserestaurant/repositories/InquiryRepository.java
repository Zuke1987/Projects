package org.kevinzuhoski.japaneserestaurant.repositories;

import org.kevinzuhoski.japaneserestaurant.models.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//InquiryRepository 

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {

}
