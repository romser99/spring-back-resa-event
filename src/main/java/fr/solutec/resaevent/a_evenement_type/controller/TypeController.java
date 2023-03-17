package fr.solutec.resaevent.a_evenement_type.controller;

import fr.solutec.re.service.TypeService;
import fr.solutec.re.entites.Type;
import fr.solutec.resaevent.a_evenement_type.services.TypeService;
import fr.solutec.resaevent.a_evenement_type.entites.Type;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "type", produces = APPLICATION_JSON_VALUE)
@RestController
public class TypeController {
    private TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping
    public void create(@RequestBody Type type) {
        this.typeService.create(type);
    }

   @GetMapping (path = "readall")
    public Iterable<Type> readAll() {
        return this.typeService.readAll();
    }

    @GetMapping
    public Type readByNom(String nomtype) {
        return this.typeService.readByNom(nomtype);
    }

    @DeleteMapping (path = "{idtype}")
    public void delete(@PathVariable int idtype) {
        typeService.delete(idtype);
    }


}
