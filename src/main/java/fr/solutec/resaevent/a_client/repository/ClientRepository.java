package fr.solutec.resaevent.a_client.repository;

import fr.solutec.resaevent.a_client.entites.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    Optional<Client> findByEmail(String Email);

}
