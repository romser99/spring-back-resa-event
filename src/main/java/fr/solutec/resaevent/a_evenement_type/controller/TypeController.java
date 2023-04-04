package fr.solutec.resaevent.a_evenement_type.controller;

import fr.solutec.resaevent.a_evenement_type.services.TypeService;
import fr.solutec.resaevent.a_evenement_type.entites.Type;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin
    @GetMapping (path = "readall")
    public Iterable<Type> readAll() {
        return this.typeService.readAll();
    }
    @CrossOrigin
    @GetMapping
    public Type readByNom(String nomtype) {
        return this.typeService.readByNom(nomtype);
    }
    @CrossOrigin
    @DeleteMapping (path = "{idtype}")
    public void delete(@PathVariable int idtype) {
        typeService.delete(idtype);
    }
}