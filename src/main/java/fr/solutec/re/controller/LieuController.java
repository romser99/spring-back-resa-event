package fr.solutec.re.controller;

import fr.solutec.re.entites.Lieu;
import fr.solutec.re.services.AdresseService;
import fr.solutec.re.services.LieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.BindException;
import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path = "lieu", produces = APPLICATION_JSON_VALUE)
public class LieuController {

    private LieuService lieuService;

    public LieuController(LieuService lieuService) {
        this.lieuService = lieuService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Lieu lieu) throws BindException {
        System.out.println("[Controller] Creation nouveau lieu");
        this.lieuService.create(lieu);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id) {
        System.out.println("[Controller] Supression ancien lieu");
        this.lieuService.delete(id);
    }

    @GetMapping(path = "all")
    public @ResponseBody Iterable<Lieu> readAll() {
        System.out.println("[Controller] Lecture des lieux");
        return this.lieuService.readAll();
    }

    @GetMapping(path = "{id}")
    public @ResponseBody Lieu read(@PathVariable int id) {
        System.out.println("[Controller] Lecture du lieu");
            Lieu lieu = this.lieuService.read(id);
            return lieu;
        }

    @GetMapping
    public @ResponseBody Iterable<Lieu> search(@RequestParam(required = false) String nom,
                                                 @RequestParam(required = false) String rue,
                                                 @RequestParam(required = false) String ville,
                                                 @RequestParam(required = false) String region){
        System.out.println("[Controller] Recherche du lieu");
        List<String> params = new ArrayList<>() ;
        if (nom != null){        params.add(nom);    }
        else {        params.add("");    }
        if (rue != null){        params.add(rue);    }
        else {        params.add("");    }
        if (ville != null){        params.add(ville);    }
        else {        params.add("");    }
        if (region != null){        params.add(region);    }
        else {        params.add("");    }
        return this.lieuService.search(params);
    }

}

