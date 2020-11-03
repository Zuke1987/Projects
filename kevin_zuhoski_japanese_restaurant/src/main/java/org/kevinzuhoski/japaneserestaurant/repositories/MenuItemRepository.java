package org.kevinzuhoski.japaneserestaurant.repositories;

import org.kevinzuhoski.japaneserestaurant.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//MenuItemRepository

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

}
