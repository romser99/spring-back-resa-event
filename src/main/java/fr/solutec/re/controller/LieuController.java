package fr.solutec.re.controller;



import fr.solutec.re.entites.Lieu;
import fr.solutec.re.services.AdresseService;
import fr.solutec.re.services.LieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

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
    public void create(@RequestBody Lieu lieu) {
        System.out.println("[Controller] Creation nouveau lieu");
        this.lieuService.create(lieu);
    }

    @GetMapping(path="{id}")
    public @ResponseBody Lieu read(@PathVariable int id) {
        System.out.println("Lecture du lieu");
        Lieu lieu = this.lieuService.read(id);
        return lieu;
    }

    @GetMapping
    public @ResponseBody Set<Lieu> search(Map<String, String> params) {
        return this.lieuService.search(params);
    }

    /*
    @GetMapping
    public @ResponseBody Set<Lieu> readAll() {
        System.out.println("Lecture des lieux");
        return this.lieuService.readAll();
    }
    */
}