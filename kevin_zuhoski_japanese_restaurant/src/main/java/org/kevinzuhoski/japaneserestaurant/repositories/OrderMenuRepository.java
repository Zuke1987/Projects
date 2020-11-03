package org.kevinzuhoski.japaneserestaurant.repositories;

import org.kevinzuhoski.japaneserestaurant.models.OrderMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//OrderMenu Repository

@Repository
public interface OrderMenuRepository extends JpaRepository<OrderMenu, Integer>{

}
