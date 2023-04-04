package fr.solutec.re.controller;

import fr.solutec.re.entites.Type;
import fr.solutec.re.service.EvenementService;
import fr.solutec.re.entites.Evenement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RequestMapping(path = "evenement", produces = APPLICATION_JSON_VALUE)
@RestController
public class EvenementController {
    private EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    /* ///////////////////////////////////CREATE&UPDATE////////////////////////////////////// */
    @CrossOrigin
    @PostMapping
    public void create(@RequestBody Evenement events) {
        this.evenementService.create(events);
    }

    /* ///////////////////////////////////READ////////////////////////////////////// */

    /*@GetMapping (path = "readall")
    public  @ResponseBody Iterable<Evenement> readAll() {
        return this.evenementService.readAll();
    }*/

    @CrossOrigin
    @GetMapping
    public @ResponseBody List<Evenement> search(
            //@RequestParam(required = false) Date date,
            //@RequestParam(required = false) int id,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String salle){
        Map<String, Object> params = new HashMap<>();
        //params.put("e.id", id);
        params.put("e.nom", nom);
        params.put("t.nom", type);
        params.put("s.nom", salle);
        /*if(date == null) {
            params.put("date", new Date());
        } */
        return this.evenementService.search(params);
    }

    @CrossOrigin
    @GetMapping(path = "{id}")
    public @ResponseBody Optional<Evenement> findById(@PathVariable int id) {
        return this.evenementService.findById(id);
    }

    /* //////////////////////////////////DELETE/////////////////////////////////////// */
    @CrossOrigin
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
