package fr.solutec.re.services;

import fr.solutec.re.dao.ClientDAO;
import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Lieu;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class ClientService {
    private ClientDAO clientDAO ;

    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public void create(Client client){

        this.clientDAO.create(client);

    }

    public Client read(int id){
        Client client = this.clientDAO.read(id);
        return client;

    }

    public Set<Client> search(Map<String, String> params){
        Map<String, String> nparams =  new HashMap<>();
        for (String key: params.keySet()) {
            if(params.get(key) != null ) {
                nparams.put(key, params.get(key) ) ;
            }
        }

        return this.clientDAO.search(nparams) ;
    }




    public void delete(int id){
        this.clientDAO.delete(id);

    }
}
