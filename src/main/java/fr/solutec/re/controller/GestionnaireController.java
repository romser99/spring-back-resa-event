package fr.solutec.re.controller;
import fr.solutec.re.entites.Gestionnaire;
import fr.solutec.re.services.GestionnaireService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "gestionnaire" , produces = APPLICATION_JSON_VALUE)
@RestController
public class GestionnaireController {

    private GestionnaireService gestionnaireService;
    public GestionnaireController(GestionnaireService gestionnaireService) {
        this.gestionnaireService = gestionnaireService;
    }



    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Gestionnaire gestionnaire){
        this.gestionnaireService.create(gestionnaire);

    }
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Set<Gestionnaire> readALL(){
        return this.gestionnaireService.readALL();

    }
}
