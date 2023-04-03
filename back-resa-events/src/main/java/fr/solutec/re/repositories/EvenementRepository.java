package fr.solutec.re.repositories;

import fr.solutec.re.entites.Evenement;
import fr.solutec.re.entites.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EvenementRepository extends CrudRepository<Evenement, Integer> {


}
