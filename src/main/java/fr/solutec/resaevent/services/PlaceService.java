package fr.solutec.resaevent.services;
import fr.solutec.resaevent.entites.Place;
import fr.solutec.resaevent.entites.Salle;
import fr.solutec.resaevent.repository.PlaceRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;
@Service
public class PlaceService {
    private PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Place save(Place place) {
        System.out.println("[service] Création d'une nouvelle place");
        return this.placeRepository.save(place);
    }
    public Iterable<Place> findAll() {
        System.out.println("[service] Lecture des salles");
        return this.placeRepository.findAll();
    }

    public Place read(int id) {
        Optional<Place> optionalPlace = this.placeRepository.findById(id);
        if (optionalPlace.isEmpty()) {
            String message = String.format("Aucune Place n'a l'id %s", id);
            throw new IllegalArgumentException();
        } else {
            return (Place)optionalPlace.get();
        }
    }
}
