package fr.solutec.re.repository;

import fr.solutec.re.entites.Lieu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LieuRepository extends CrudRepository <Lieu, Integer> {
    @Query(value = "FROM Lieu l WHERE l.nom LIKE %:nom% AND l.adresse.rue LIKE %:rue% AND l.adresse.ville LIKE %:ville% AND l.adresse.region LIKE %:region%")
    List<Lieu> findByNomAndRueAndVilleAndRegion(String nom, String rue, String ville, String region);
}
