package fr.solutec.resaevent.a_evenement_type.repository;


import fr.solutec.resaevent.a_evenement_type.entites.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository <Type, Integer> {
   // Lieu findByNomAndAdresse_Id(String nom); //l'ordre des paramètres doit être bon

   // @Query("FROM Lieu l WHERE l.nom like '%?%'") // findbynom avec un like
   // List<Lieu> search(String nom);
   // List<Lieu> findByNomContains(String nom);
   // void deleteByNom(String nomtype);

    Type findByNom(String nomtype);
}
