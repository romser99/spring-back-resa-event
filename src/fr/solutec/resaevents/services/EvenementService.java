package fr.solutec.resaevents.services;

import fr.solutec.resaevents.entites.Evenement;
import fr.solutec.resaevents.entites.Type;

import java.util.ArrayList;
import java.util.List;

public class EvenementService {
    /*public Evenement create(Evenement evenement) {
        Evenement EvenementACreer = new Evenement();
        EvenementACreer.setNom(evenement.getNom());
        EvenementACreer.setId(EvenementACreer.getId());
        EvenementACreer.setDescription(EvenementACreer.getDescription());
        EvenementACreer.setType(EvenementACreer.getType());
        //EvenementACreer.setSalle(EvenementACreer.getSalle());
        return EvenementACreer;
    }

    public void display(Evenement EvenementACreer) {
        System.out.println("L'évènement " + EvenementACreer.getNom() + " a l'id " + EvenementACreer.getId() +
        ", la description suivante : " + EvenementACreer.getDescription() + " est du type "
        + EvenementACreer.getType() + " et a lieu dans la salle "); /*+ EvenementACreer.getSalle()) */

    public Evenement create(Evenement evenement) {
        int id = (int)(Math.random() * 50 + 1);
        evenement.setId(id);
        return new Evenement(evenement.getId(), evenement.getNom(), evenement.getDescription(), evenement.getType());
    }

    public List<Evenement> list() {
        List<Evenement> evenements = new ArrayList<>();
        for (int i = 0; i < 10; i++ ) {
            Evenement evenement = new Evenement();
            evenement.setNom("Nom" + i);
        }
        return evenements;
    }

    public void display(Evenement evenement) {
        System.out.println("le Type " + evenement.getNom() + " a l'id " + evenement.getId());
    }

    public Evenement read(String nom) {
        List<Evenement> evenements = this.list();
        Evenement evenement;
        evenement = this.filter(evenements, nom);
        return evenement;
    }

    private Evenement filter(List<Evenement> evenements, String nom) {
        return evenements.stream().filter(evenement -> evenement.getNom().equals(nom)).findFirst().get();
    }

    public void delete(int id) { // potentiellement supp
    }
}

