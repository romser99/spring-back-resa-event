package fr.solutec.resaevents.services;

import fr.solutec.resaevents.entites.Gestionnaire;

public class GestionnaireService {
    public Gestionnaire create(Gestionnaire gestionnaire) {
        Gestionnaire gestionnaireACreer = new Gestionnaire();
        gestionnaireACreer.setId(gestionnaire.getId());
        return gestionnaireACreer;
    }

    public void display(Gestionnaire gestionnaireACreer) {
        System.out.println( gestionnaireACreer.getId() );
    }
}
