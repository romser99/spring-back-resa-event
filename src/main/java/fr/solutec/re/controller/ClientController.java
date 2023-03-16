package fr.solutec.re.controller;

import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Lieu;
import fr.solutec.re.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "client" , produces = APPLICATION_JSON_VALUE)
@RestController
public class ClientController {


    private ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }



    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void save(@RequestBody Client client){
        this.clientService.save(client);

    }

    @GetMapping
    public @ResponseBody Set<Client> search(@RequestParam(required = false) String id,
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
        return this.clientService.search(params);

    }



    @GetMapping(path = "{id}")
    public Client findById(@PathVariable int id) {
        Client client = this.clientService.findById(id) ;
        return client ;
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable int id){
        this.clientService.deleteById(id);
    }

    /*@GetMapping
    public void modify(@RequestParam String id,
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
        this.clientService.modify(params);

    }*/

}


