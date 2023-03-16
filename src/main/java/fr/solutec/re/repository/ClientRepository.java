package fr.solutec.re.repository;

import fr.solutec.re.entites.Client;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.Set;

public interface ClientRepository extends CrudRepository<Client, Integer> {

}
