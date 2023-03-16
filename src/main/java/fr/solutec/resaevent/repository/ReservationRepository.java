package fr.solutec.resaevent.repository;

import fr.solutec.resaevent.entites.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

}
