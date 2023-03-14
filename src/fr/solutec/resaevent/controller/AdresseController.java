package fr.solutec.resaevent.controller;

import fr.solutec.resaevent.entites.Adresse;
import fr.solutec.resaevent.services.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "adresse", produces = APPLICATION_JSON_VALUE)
@RestController
public class AdresseController {

    private AdresseService adresseService;
    public AdresseController(AdresseService adresseService){
        this.adresseService = adresseService;
    }
    @RequestMapping (path ="4", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Adresse adresse){
        this.adresseService.create(adresse);
    }
*/ /*
    @RequestMapping (method = RequestMethod.GET)
    public @ResponseBody Set<Adresse> readAll() {
        System.out.println("Lecture des adresses");
        return this.adresseService.readAll();
    }
}
*/