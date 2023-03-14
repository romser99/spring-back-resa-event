package fr.solutec.re.services;

import fr.solutec.re.dao.ClientDAO;
import fr.solutec.re.entites.Client;
import org.springframework.stereotype.Service;

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

    public Set<Client> readALL(){

        return this.clientDAO.readALL();

    }
}
