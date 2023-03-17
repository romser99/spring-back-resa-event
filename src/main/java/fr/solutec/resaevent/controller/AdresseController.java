package fr.solutec.resaevent.controller;
import fr.solutec.resaevent.entites.Adresse;
import fr.solutec.resaevent.services.AdresseService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "adresse", produces = APPLICATION_JSON_VALUE)
@RestController
public class AdresseController {

    private AdresseService adresseService;
    public AdresseController(AdresseService adresseService){
        this.adresseService = adresseService;
    }

    //SEARCH
    @GetMapping (path = "search")
    public @ResponseBody Iterable<Adresse> findAll() {
        System.out.println("Lecture des adresses");
        return this.adresseService.findAll();
    }
    //READ
    @GetMapping (path = "findbyid/{id}")
    public @ResponseBody Optional<Adresse> findById(@PathVariable int id) {
        System.out.println("Lecture d'une adresse");
        return this.adresseService.findById(id);
    }
    @GetMapping (path = "read/{id}")
    public @ResponseBody Adresse read(@PathVariable int id) {
        System.out.println("Lecture d'une adresse");
        return this.adresseService.read(id);
    }
    //CREATE + UPDATE
    @PostMapping (consumes = APPLICATION_JSON_VALUE)
    public void save(@RequestBody Adresse adresse){
        System.out.println("Nouvelle adresse");
        this.adresseService.save(adresse);
    }
}