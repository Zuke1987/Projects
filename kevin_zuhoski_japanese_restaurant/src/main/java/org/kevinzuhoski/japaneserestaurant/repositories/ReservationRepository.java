package org.kevinzuhoski.japaneserestaurant.repositories;

import org.kevinzuhoski.japaneserestaurant.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ReservationRepository not currently used in this version of the application

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
