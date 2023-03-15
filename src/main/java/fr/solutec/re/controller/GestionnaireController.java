package fr.solutec.re.controller;
import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Gestionnaire;
import fr.solutec.re.services.GestionnaireService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "gestionnaire" , produces = APPLICATION_JSON_VALUE)
@RestController
public class GestionnaireController {

    private GestionnaireService gestionnaireService;
    public GestionnaireController(GestionnaireService gestionnaireService) {
        this.gestionnaireService = gestionnaireService;
    }



    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Gestionnaire gestionnaire){
        this.gestionnaireService.create(gestionnaire);

    }

    @GetMapping(path = "{id}")
    public Gestionnaire read (@PathVariable int id) {
        Gestionnaire gestionnaire = this.gestionnaireService.read(id) ;
        return gestionnaire ;
    }

    @GetMapping
    public @ResponseBody Set<Gestionnaire> search(@RequestParam (required = false) String id,
                                                  @RequestParam(required = false) String nom,
                                                  @RequestParam(required = false) String prenom,
                                                  @RequestParam(required = false) String mail,
                                                  @RequestParam(required = false) String telephone){
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("nom", nom);
        params.put("prenom", prenom);
        params.put("mail", mail);
        params.put("telephone", telephone);
        return this.gestionnaireService.search(params);

    }

    @DeleteMapping(path = "{id}")
    public void delete (@PathVariable int id){
        this.gestionnaireService.delete(id);
    }
}
