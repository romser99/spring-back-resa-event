package fr.solutec.resaevent.controller;
import fr.solutec.resaevent.entites.Place;
import fr.solutec.resaevent.entites.Salle;
import fr.solutec.resaevent.services.PlaceService;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@CrossOrigin
@RequestMapping(
        path = {"place"},
        produces = APPLICATION_JSON_VALUE)
@RestController
public class PlaceController {
    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public void save(@RequestBody Place place) {
        System.out.println("[controller] Création d'une nouvelle place");
        this.placeService.save(place);
    }
    @GetMapping
    public @ResponseBody Iterable<Place> findAll() {
        System.out.println("[controller] Lecture des salles");
        return this.placeService.findAll();
    }
    @GetMapping (path = "{id}")
    @ResponseBody
    public Place read(@PathVariable int id) {
        System.out.println("[controller] Lecture des places");
        return this.placeService.read(id);
    }
}