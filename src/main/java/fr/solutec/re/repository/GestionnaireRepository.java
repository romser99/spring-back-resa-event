package fr.solutec.re.repository;

import fr.solutec.re.entites.Gestionnaire;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GestionnaireRepository extends CrudRepository<Gestionnaire, Integer> {

    Optional<Gestionnaire> findByEmail(String Email);
}
