package fr.solutec.re.repository;

import fr.solutec.re.entites.Client;

import fr.solutec.re.entites.Gestionnaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.Optional;
import java.util.Set;

@CrossOrigin
public interface ClientRepository extends CrudRepository<Client, Integer> {

    Optional<Client> findByEmail(String Email);
    Optional<Client> findByPassword(String Password);


}
