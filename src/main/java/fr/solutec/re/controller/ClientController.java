package fr.solutec.re.controller;

import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Lieu;
import fr.solutec.re.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "client" , produces = APPLICATION_JSON_VALUE)
@RestController
public class ClientController {


    private ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }



    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Client client){
        this.clientService.create(client);

    }

    @GetMapping
    public @ResponseBody Set<Client> search(@RequestParam (required = false) String id,
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
    public Client read (@PathVariable int id) {
        Client client = this.clientService.read(id) ;
        return client ;
    }

    @DeleteMapping(path = "{id}")
    public void delete (@PathVariable int id){
        this.clientService.delete(id);
    }
}
