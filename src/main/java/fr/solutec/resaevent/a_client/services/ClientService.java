package fr.solutec.resaevent.a_client.services;

import fr.solutec.resaevent.a_client.dao.ClientDAO;
import fr.solutec.resaevent.a_client.entites.Client;
import fr.solutec.resaevent.a_client.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.net.BindException;
import java.util.*;

@Service
public class ClientService {
    private ClientDAO clientDAO ;
    private ClientRepository clientRepository ;

    public ClientService(ClientDAO clientDAO, ClientRepository clientRepository) {
        this.clientDAO = clientDAO;
        this.clientRepository = clientRepository;
    }
    public void save(Client client) throws BindException {
        String Email = client.getEmail();
        String password = client.getPassword();
        Optional<Client> optionalclient = this.clientRepository.findByEmail(Email);
        if (Email == null || password == null){
            String message = "Veuillez remplir tout les champs obligatoires indiqués par *";
            throw new IllegalStateException(message) ;
        }
        if (optionalclient.isEmpty() == false) {
            String message = String.format ("Un compte est déja associé au mail %s", Email);
            throw new BindException(message) ;

        }
        this.clientRepository.save(client);
    }
    public Client findById(int id){
        Optional<Client> optionalclient = this.clientRepository.findById(id);
        if (optionalclient.isEmpty()){
            String message = String.format ("Aucun Client n'a l'id %s", id);
            throw new IllegalArgumentException(message) ;
        }
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

    public void deleteById(int id){
        Optional<Client> optionalclient = this.clientRepository.findById(id);
        if (optionalclient.isEmpty()){
            String message = String.format ("Aucun Client n'a l'id %s", id);
            throw new IllegalArgumentException(message) ;
        }
        this.clientRepository.deleteById(id);
    }
}
