package fr.solutec.resaevent.controller;
import fr.solutec.resaevent.entites.Evenement;
import fr.solutec.resaevent.services.TypeService;
import fr.solutec.resaevent.entites.Type;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RequestMapping(path = "type", produces = APPLICATION_JSON_VALUE)
@RestController
public class TypeController {
    private TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }
    @CrossOrigin
    @PostMapping
    public void create(@RequestBody Type type) {
        this.typeService.create(type);
    }
    /*@CrossOrigin
    @GetMapping
    public Type readByNom( String nom) {
        return this.typeService.readByNom(nom);
    }
    @CrossOrigin
    @GetMapping
    public int idByNom( String nom) {
        return this.typeService.idByNom(nom);
    } */

    @CrossOrigin
    @GetMapping
    public @ResponseBody List<Type> search(
            //@RequestParam(required = false) Date date,
            @RequestParam(required = false) String nom) {
        Map<String, String> params = new HashMap<>();
        params.put("nom", nom);
        return this.typeService.search(params);
    }

    @CrossOrigin
    @DeleteMapping (path = "{idtype}")
    public void delete(@PathVariable int idtype) {
        typeService.delete(idtype);
    }

}
