package fr.solutec.re.controller;
import org.springframework.web.bind.annotation.CrossOrigin;


import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Lieu;
import fr.solutec.re.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.net.BindException;
import java.security.NoSuchAlgorithmException;
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
    @PostMapping(consumes = APPLICATION_JSON_VALUE, path = "inscription")
    public void save(@RequestBody Client client) throws BindException, NoSuchAlgorithmException {
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

    /*@GetMapping(path = "/auth/login")
    public @ResponseBody boolean login(@RequestParam(required = false) String mail,
                                       @RequestParam(required = false) String password) {
        boolean valid = this.clientService.login(mail, password) ;
        return valid ;
    }*/

    @GetMapping(path = "{id}")
    public Client findById(@PathVariable int id) {
        Client client = this.clientService.findById(id) ;
        return client ;
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable int id){
        this.clientService.deleteById(id);
    }



}


