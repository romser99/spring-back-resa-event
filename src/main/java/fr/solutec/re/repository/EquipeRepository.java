package fr.solutec.re.repository;


import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Equipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EquipeRepository extends CrudRepository<Equipe, Integer> {
    Optional<Equipe> findByEmail(String Email);
}
