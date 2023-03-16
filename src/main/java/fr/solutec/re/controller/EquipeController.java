package fr.solutec.re.controller;

import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Equipe;
import fr.solutec.re.enums.RoleEnum;
import fr.solutec.re.services.EquipeService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "equipe" , produces = APPLICATION_JSON_VALUE)
@RestController
public class EquipeController {

    private EquipeService equipeService;
    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }



    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void save(@RequestBody Equipe equipe){
        this.equipeService.save(equipe);

    }

    @GetMapping(path = "{id}")
    public Equipe findById(@PathVariable int id) {
        Equipe equipe = this.equipeService.findById(id) ;
        return equipe ;
    }


    @GetMapping
    public @ResponseBody Set<Equipe> search(@RequestParam (required = false) String id,
                                            @RequestParam(required = false) String nom,
                                            @RequestParam(required = false) String prenom,
                                            @RequestParam(required = false) String mail,
                                            @RequestParam(required = false) String telephone,
                                            @RequestParam(required = false) String role){
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("nom", nom);
        params.put("prenom", prenom);
        params.put("mail", mail);
        params.put("telephone", telephone);
        params.put("role", role);

        return this.equipeService.search(params);

    }
    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable int id){
        this.equipeService.deleteById(id);
    }

    @PatchMapping(path ="{ideq}/role" )
    public void update(@PathVariable int ideq, @RequestParam (required = false) RoleEnum libelle){
        this.equipeService.update(ideq, libelle) ;
    }


}
