package fr.solutec.resaevent.controller;
import fr.solutec.resaevent.entites.Lieu;
import fr.solutec.resaevent.services.LieuService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "lieu", produces = APPLICATION_JSON_VALUE)
@RestController
public class LieuController {
    private LieuService lieuService;

    public LieuController(LieuService lieuService) {
        this.lieuService = lieuService;
    }

    //SEARCH
    @GetMapping
    public Iterable<Lieu> findAll(Map<String, String> params) {
        System.out.println("Lecture de toutes les adresses en fonction du lieu");
        return this.lieuService.findAll(params);
    }
    //CREATE + UPDATE
    @PostMapping (consumes = APPLICATION_JSON_VALUE)
        public void save(@RequestBody Lieu lieu) {
        System.out.println("Nouveau lieu");
        this.lieuService.save(lieu);
    }
    //READ
    @GetMapping(path = "{id}")
    public @ResponseBody Lieu findById(@PathVariable int id) {
        System.out.println("Lecture d'une adresse en fonction du lieu");
        Lieu lieu = this.lieuService.findById(id);
        return lieu;
    }
    //DELETE
    @DeleteMapping
    public Lieu delete(@RequestBody Lieu lieu) {
        System.out.println("Suppression d'un lieu");
        this.lieuService.delete(lieu);
        return null;
    }
}
