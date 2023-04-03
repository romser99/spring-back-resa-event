package fr.solutec.re.controller;

import fr.solutec.re.service.TypeService;
import fr.solutec.re.entites.Type;
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
    @GetMapping
    public Type readByNom(String nom) {
        return this.typeService.readByNom(nom);
    }
    @CrossOrigin
    @GetMapping (path = "{nom}")
    public int idByNom(@PathVariable String nom) {
        return this.typeService.idByNom(nom);
    }

   /* @GetMapping
    public Type readByNom(String nomtype) {
        return this.typeService.readByNom(nomtype);
    }*/

    @CrossOrigin
    @DeleteMapping (path = "{idtype}")
    public void delete(@PathVariable int idtype) {
        typeService.delete(idtype);
    }


}
