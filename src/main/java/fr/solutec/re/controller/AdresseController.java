package fr.solutec.re.controller;

import fr.solutec.re.entites.Adresse;
import fr.solutec.re.services.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "adresse" , produces = APPLICATION_JSON_VALUE)
@RestController
public class AdresseController {

    private AdresseService adresseService;
    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }



    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void save(@RequestBody Adresse adresse){
        System.out.println("[controler]creation d'une nouvelle adresse");
        this.adresseService.save(adresse);

    }
    @GetMapping
    public @ResponseBody Iterable<Adresse> findAll(){
        System.out.println("lecture des adresses");
        return this.adresseService.findAll();

    }
    @GetMapping(path = "{id}")
    public @ResponseBody Adresse findById(@PathVariable int id){
        System.out.println("lecture des adresses");
        return this.adresseService.findById(id);

    }

    @DeleteMapping(path = "{id}")
    public void delete (@PathVariable int id){
        this.adresseService.delete(id);
    }
}
