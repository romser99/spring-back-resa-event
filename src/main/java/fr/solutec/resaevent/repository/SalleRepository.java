package fr.solutec.resaevent.repository;
import fr.solutec.resaevent.entites.Salle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SalleRepository extends CrudRepository<Salle, Integer> {

}
