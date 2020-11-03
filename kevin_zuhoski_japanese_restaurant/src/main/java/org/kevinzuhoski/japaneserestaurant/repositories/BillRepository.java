package org.kevinzuhoski.japaneserestaurant.repositories;

import org.kevinzuhoski.japaneserestaurant.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Bill Repository not currently used in this version of the application

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

}
