package fr.solutec.re.controller;

import fr.solutec.re.entites.Lieu;
import fr.solutec.re.services.LieuService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "lieu" , produces = APPLICATION_JSON_VALUE)
@RestController

public class LieuController {

    private LieuService lieuService;
    public LieuController(LieuService lieuService) {
        this.lieuService = lieuService;
    }



    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Lieu lieu){
        System.out.println("[controler]creation d'un nouveau lieu");
        this.lieuService.create(lieu);

    }
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Set<Lieu> readALL(){
        System.out.println("lecture des lieux");
        return this.lieuService.readALL();

    }


}
