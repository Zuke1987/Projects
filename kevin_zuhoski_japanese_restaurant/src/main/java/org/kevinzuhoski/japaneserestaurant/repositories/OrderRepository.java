package org.kevinzuhoski.japaneserestaurant.repositories;

import org.kevinzuhoski.japaneserestaurant.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// OrderRepository

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
