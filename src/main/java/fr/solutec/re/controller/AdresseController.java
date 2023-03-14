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



    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Adresse adresse){
        System.out.println("[controler]creation d'une nouvelle adresse");
        this.adresseService.create(adresse);

    }
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Set<Adresse> readALL(){
        System.out.println("lecture des adresses");
        return this.adresseService.readALL();

    }

    @DeleteMapping(path = "{id}")
    public void delete (@PathVariable int id){
        this.adresseService.delete(id);
    }
}
