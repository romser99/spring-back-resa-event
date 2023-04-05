package fr.solutec.resaevent.repository;
import fr.solutec.resaevent.entites.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {

}
