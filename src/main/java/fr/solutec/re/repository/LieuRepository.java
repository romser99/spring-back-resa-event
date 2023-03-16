package fr.solutec.re.repository;

import fr.solutec.re.entites.Lieu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LieuRepository extends CrudRepository <Lieu, Integer> {

}
