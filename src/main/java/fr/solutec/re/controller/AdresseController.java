package fr.solutec.re.controller;

import fr.solutec.re.service.AdresseService;
import fr.solutec.re.entites.Adresse;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@CrossOrigin
@RequestMapping(path = "adresse", produces = APPLICATION_JSON_VALUE )
@RestController
public class AdresseController {
    private AdresseService adresseService;
    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Adresse adresse) {
        this.adresseService.create(adresse);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public @ResponseBody Adresse read(@PathVariable int id) {
        return this.adresseService.read(id);
    }
}
