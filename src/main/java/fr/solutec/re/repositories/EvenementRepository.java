package fr.solutec.re.repositories;

import fr.solutec.re.entites.Evenement;
import fr.solutec.re.entites.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EvenementRepository extends CrudRepository<Evenement, Integer> {


}
