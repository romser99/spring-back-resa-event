package fr.solutec.resaevent.a_evenement_type.repository;


import fr.solutec.resaevent.a_evenement_type.entites.Evenement;
import org.springframework.data.repository.CrudRepository;

public interface EvenementRepository extends CrudRepository<Evenement, Integer> {


}
