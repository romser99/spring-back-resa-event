package fr.solutec.re.controller;

import fr.solutec.re.entites.Equipe;
import fr.solutec.re.services.EquipeService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "equipe" , produces = APPLICATION_JSON_VALUE)
@RestController
public class EquipeController {

    private EquipeService equipeService;
    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }



    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Equipe equipe){
        this.equipeService.create(equipe);

    }
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Set<Equipe> readALL(){
        return this.equipeService.readALL();

    }


}
