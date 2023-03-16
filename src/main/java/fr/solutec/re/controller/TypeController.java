package fr.solutec.re.controller;

import fr.solutec.re.service.TypeService;
import fr.solutec.re.entites.Type;
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
        System.out.println("[controller] Création d'un nouveau type");
        this.typeService.create(type);
    }

    @GetMapping
    public Iterable<Type> readAll() {
        System.out.println("[controller] Lecture des types");
        return this.typeService.readAll();
    }

    @DeleteMapping (path = "{idtype}")
    public void delete(@PathVariable int idtype) {
        System.out.println("[controller] Suppression d'un type");
        typeService.delete(idtype);
    }


}
