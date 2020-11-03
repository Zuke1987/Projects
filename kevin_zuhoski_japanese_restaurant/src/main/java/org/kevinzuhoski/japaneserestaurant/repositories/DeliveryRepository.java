package org.kevinzuhoski.japaneserestaurant.repositories;

import org.kevinzuhoski.japaneserestaurant.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Delivery Repository not currently used in this version of the project

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}
