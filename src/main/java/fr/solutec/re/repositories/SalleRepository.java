package fr.solutec.re.repositories;

import fr.solutec.re.entites.Salle;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends CrudRepository <Salle, Integer> {
   /*Salle findByNom(int id);
    */
}
