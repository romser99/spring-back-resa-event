package fr.solutec.resaevents.services;


import fr.solutec.resaevents.entites.Client;
import fr.solutec.resaevents.entites.Role;
import fr.solutec.resaevents.enums.RoleEnum;

import java.util.ArrayList;
import java.util.List;

import static fr.solutec.resaevents.outils.Data.ROLES_LABELS;

public class ClientService {
    /* public Client create(Client client) {
        Client clientACreer = new Client();
        clientACreer.setId(client.getId());
        return clientACreer;
    }

    public void display(Client ClientACreer) {
        System.out.println(ClientACreer.getId());
    } */

    public Client create(Client client) {
        int id = (int)(Math.random() * 50 + 1);
        client.setId(id);
        return new Client(client.getNom(), client.getPrenom(), client.getMdp(), client.getMail(), client.getTelephone(), client.getId());
    }

    public List<Client> list() {
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < 10; i++ ) {
            Client client = new Client();
            client.setNom("Nom" + i);
            client.setPrenom("Prenom" + i);
            client.setMdp("Mdp" + i);
            client.setMail("Mail" + i);
            client.setTelephone("Telephone" + i);
        }
        return clients;
    }

    public void display(Client client) {
        System.out.println("le Client " + client.getNom() + " a l'id " + client.getId());
    }

    public Client read(Client nom) {
        List<Client> clients = this.list();
        Client client;
        client = this.filter(clients, nom);
        return client;
    }

    private Client filter(List<Client> clients, Client nom) {
        return clients.stream().filter(client -> client.getNom().equals(nom)).findFirst().get();
    }

    public void delete(int id) { // potentiellement supp
    }

}


