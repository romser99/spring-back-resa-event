package fr.solutec.re.controller;



import fr.solutec.re.entites.Lieu;
import fr.solutec.re.services.LieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Lieu lieu) {
        System.out.println("[Controller] Creation nouveau lieu");
        this.lieuService.create(lieu);
    }

    @RequestMapping(method = GET)
    public @ResponseBody Set<Lieu> readAll() {
        System.out.println("Lecture des lieux");
        return this.lieuService.readAll();
    }
}