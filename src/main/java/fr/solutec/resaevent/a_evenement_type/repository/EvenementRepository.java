package fr.solutec.resaevent.a_evenement_type.repository;

import fr.solutec.re.entites.Evenement;
import fr.solutec.re.entites.Type;
import fr.solutec.resaevent.a_evenement_type.entites.Evenement;
import org.springframework.data.repository.CrudRepository;

public interface EvenementRepository extends CrudRepository<Evenement, Integer> {


}
