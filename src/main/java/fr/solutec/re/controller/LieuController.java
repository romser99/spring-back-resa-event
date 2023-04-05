package fr.solutec.re.controller;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "lieu" , produces = APPLICATION_JSON_VALUE)
@RestController

public class LieuController {

    private LieuService lieuService;
    public LieuController(LieuService lieuService) {
        this.lieuService = lieuService;
    }



    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Lieu lieu){
        this.lieuService.save(lieu);

    }

    @GetMapping(path = "{id}")
    public Lieu read (@PathVariable int id) {
        Lieu lieu = this.lieuService.read(id) ;
        return lieu ;
    }


    /*@GetMapping
    public @ResponseBody Set<Lieu> search(Map<String, String> params){
        return this.lieuService.search(params);

    }*/

    @GetMapping
    public Iterable<Lieu> findall(){
        return this.lieuService.findall();
    }


    @DeleteMapping(path = "{id}")
    public void delete (@PathVariable int id){
        this.lieuService.delete(id);
    }


}
