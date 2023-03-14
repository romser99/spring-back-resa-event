package fr.solutec.re.controller;

import fr.solutec.re.Service.LieuService;
import fr.solutec.re.Service.TypeService;
import fr.solutec.re.entites.Lieu;
import fr.solutec.re.entites.Type;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@RequestMapping(path = "lieu", produces = APPLICATION_JSON_VALUE)

@RestController

public class LieuController {
    private LieuService lieuService;

    public LieuController(LieuService lieuService) {
        this.lieuService = lieuService;
    }

    @PostMapping
    public void create(@RequestBody Lieu lieu) {
        this.lieuService.create(lieu);
    }
}
