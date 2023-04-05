package fr.solutec.resaevent.repository;
import fr.solutec.resaevent.entites.Evenement;
import fr.solutec.resaevent.entites.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EvenementRepository extends CrudRepository<Evenement, Integer> {


}
