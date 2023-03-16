package fr.solutec.resaevent.repository;

import fr.solutec.resaevent.entites.Adresse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends CrudRepository<Adresse, Integer> {

}
