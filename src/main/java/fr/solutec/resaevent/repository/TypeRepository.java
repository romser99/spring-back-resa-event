package fr.solutec.resaevent.repository;
import fr.solutec.resaevent.entites.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository <Type, Integer> {

    Type findByNom(String nomtype);
}
