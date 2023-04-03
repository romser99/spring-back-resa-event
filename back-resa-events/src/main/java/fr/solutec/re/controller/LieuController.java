package fr.solutec.re.controller;

import fr.solutec.re.service.LieuService;
import fr.solutec.re.entites.Lieu;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    @GetMapping
    public ResponseEntity read(int id) {
        try { //////// try catch = masquer les erreurs systeme 500 a l'utilisateur
            return ResponseEntity.status(HttpStatus.OK).body(lieuService.read(id));
        }
        catch (Exception e) { /// gestion des erreurs
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new HashMap<>().put("message", e.getMessage()));
            // ou throw new LieuException...
        }
    }
}
