package org.kevinzuhoski.japaneserestaurant.repositories;

import org.kevinzuhoski.japaneserestaurant.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// RestaurantRepository not currently used in this version of the application

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
