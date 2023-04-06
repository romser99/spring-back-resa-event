package fr.solutec.resaevent.repository;

import fr.solutec.resaevent.entites.Client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.Optional;

@CrossOrigin
public interface ClientRepository extends CrudRepository<Client, Integer> {

    Optional<Client> findByEmail(String Email);
    Optional<Client> findByPassword(String Password);


}
