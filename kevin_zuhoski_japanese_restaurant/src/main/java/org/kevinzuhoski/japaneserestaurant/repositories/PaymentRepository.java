package org.kevinzuhoski.japaneserestaurant.repositories;

import org.kevinzuhoski.japaneserestaurant.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// PaymentRepository not currently used in this version of the application

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
