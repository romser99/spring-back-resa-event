package fr.solutec.re.controller;

import fr.solutec.re.Service.EvenementService;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Evenement;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "evenement", produces = APPLICATION_JSON_VALUE)
@RestController
public class EvenementController {
    private EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @PostMapping (path = "create")
    public void create(@RequestBody Evenement evenement) {
        System.out.println("[controller] Création d'un nouvel évènement");
        this.evenementService.create(evenement);
    }

    @GetMapping (path = "readall")
    public @ResponseBody Set<Evenement> readAll() {
        System.out.println("[controller] Lecture des évènements");

        return this.evenementService.readAll();
    }

    @GetMapping
    public @ResponseBody Set<Evenement> search(@RequestParam(required = false) String nom, @RequestParam(required = false) String description){
        Map<String, String> params = new HashMap<>();
        params.put("nom", nom);
        params.put("description", description);
        return this.evenementService.search(params);
    }

    @GetMapping (path = "{nomevt}")
    public @ResponseBody Set<Evenement> readparnom( String nomevt) {
        System.out.println("[controller] Lecture des évènements selon le nom");
        return this.evenementService.readparnom(nomevt);
    }

    @GetMapping (path = "readparid")
    public @ResponseBody Set<Evenement> readparid(int idevt) {
        System.out.println("[controller] Lecture des évènements selon l'id");
        return this.evenementService.readparid(idevt);
    }

    @GetMapping (path = "readpartype")
    public @ResponseBody Set<Evenement> readpartype(String typeevt) {
        System.out.println("[controller] Lecture des évènements selon le type");
        return this.evenementService.readpartype(typeevt);
    }

    @PutMapping (path = "updatenom")
    public @ResponseBody void updatenom(@RequestParam String nomevt, @RequestParam int idevt) {
        System.out.println("[controller] Update du nom de l'évènement");
        this.evenementService.updatenom(nomevt, idevt);
    }

    @PutMapping (path = "updatedescription")
    public @ResponseBody void updatedescription(String description, int idevt) {
        System.out.println("[controller] Update de la description de l'évènement");
        this.evenementService.updatedescription(description, idevt);
    }

    @PutMapping (path = "updatetype")
    public @ResponseBody void updatetype(String description, int idevt) {
        System.out.println("[controller] Update du type de l'évènement");
        this.evenementService.updatetype(description, idevt);
    }


    @DeleteMapping (path = "delete")
    public void deleteparid(int idevt) {
        System.out.println("[controller] Suppression d'un évènement");
        evenementService.deleteparid(idevt);
    }


}
