package fr.solutec.resaevent.a_client.controller;

import fr.solutec.resaevent.a_client.services.ClientService;
import fr.solutec.resaevent.a_client.entites.Client;
import org.springframework.web.bind.annotation.*;
import java.net.BindException;
import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@CrossOrigin
@RequestMapping(path = "client" , produces = APPLICATION_JSON_VALUE)
@RestController
public class ClientController {
    private ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @CrossOrigin
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void save(@RequestBody Client client) throws BindException {
        this.clientService.save(client);
    }
    @CrossOrigin
    @GetMapping
    public @ResponseBody Set<Client> search(
                @RequestParam(required = false) String id,
                @RequestParam(required = false) String nom,
                @RequestParam(required = false) String prenom,
                @RequestParam(required = false) String mail,
                @RequestParam(required = false) String telephone) {

                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                params.put("nom", nom);
                params.put("prenom", prenom);
                params.put("mail", mail);
                params.put("telephone", telephone);
                return this.clientService.search(params);
            }
    @CrossOrigin
    @GetMapping(path = "{id}")
    public Client findById(@PathVariable int id) {
        Client client = this.clientService.findById(id) ;
        return client ;
    }
    @CrossOrigin
    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable int id){
        this.clientService.deleteById(id);
    }
}