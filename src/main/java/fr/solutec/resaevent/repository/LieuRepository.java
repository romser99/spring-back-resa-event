package fr.solutec.resaevent.repository;

import fr.solutec.resaevent.entites.Lieu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuRepository extends CrudRepository<Lieu, Integer> {

}
