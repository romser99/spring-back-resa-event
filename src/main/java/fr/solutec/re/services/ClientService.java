package fr.solutec.re.services;

import fr.solutec.re.dao.ClientDAO;
import fr.solutec.re.entites.Client;
import fr.solutec.re.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientService {
    private ClientDAO clientDAO ;
    private ClientRepository clientRepository ;

    public ClientService(ClientDAO clientDAO, ClientRepository clientRepository) {
        this.clientDAO = clientDAO;
        this.clientRepository = clientRepository;
    }

    public void save(Client client){
        this.clientRepository.save(client);

    }

    public Client findById(int id){
        Optional<Client> optionalclient = this.clientRepository.findById(id);
        return optionalclient.get() ;

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

    /*public void modify(Map<String, String> params){
        Map<String, String> nparams =  new HashMap<>();
        for (String key: params.keySet()) {
            if(params.get(key) != null ) {
                nparams.put(key, params.get(key) ) ;
            }
        }

        this.clientDAO.modify(nparams) ;
    }*/




    public void deleteById(int id){
        this.clientRepository.deleteById(id);

    }
}
