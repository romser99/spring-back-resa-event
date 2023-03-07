package fr.solutec.resaevents.services;

import fr.solutec.resaevents.entites.Evenement;

public class EvenementService {
    public Evenement create(Evenement evenement) {
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
        + EvenementACreer.getType() + " et a lieu dans la salle "); /*+ EvenementACreer.getSalle())*/;
    }
}
