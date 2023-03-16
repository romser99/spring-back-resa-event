package fr.solutec.re.controller;

import fr.solutec.re.entites.Type;
import fr.solutec.re.service.EvenementService;
import fr.solutec.re.entites.Evenement;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    /* ///////////////////////////////////CREATE&UPDATE////////////////////////////////////// */
    @PostMapping
    public void create(@RequestBody List<Evenement> events) {
        this.evenementService.create(events);
    }

    /* ///////////////////////////////////READ////////////////////////////////////// */

    @GetMapping (path = "readall")
    public @ResponseBody Iterable<Evenement> readAll() {
        return this.evenementService.readAll();
    }

    @GetMapping
    public @ResponseBody Set<Evenement> search(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String type){
        Map<String, String> params = new HashMap<>();
        params.put("nom", nom);
        params.put("type", type);
        return this.evenementService.search(params);
    }

    /* //////////////////////////////////DELETE/////////////////////////////////////// */
    @DeleteMapping
    public void deleteparid(@RequestParam Set<Integer> id) {
        evenementService.deleteparid(id);
    }

    /* /////////////////////////////////UPDATE////////////////////////////////////////

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
    } */


}
