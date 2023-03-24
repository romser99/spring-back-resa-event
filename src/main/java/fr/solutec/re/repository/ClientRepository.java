package fr.solutec.re.repository;

import fr.solutec.re.entites.Client;

import fr.solutec.re.entites.Gestionnaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;
import java.util.Set;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    Optional<Client> findByEmail(String Email);
    Optional<Client> findByPassword(String Password);


}
