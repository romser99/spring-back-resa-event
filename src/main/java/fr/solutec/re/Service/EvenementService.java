package fr.solutec.re.Service;

import fr.solutec.re.DAO.EvenementDAO;
import fr.solutec.re.DAO.TypeDAO;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Evenement;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class EvenementService {
    private EvenementDAO evenementDAO;

    public EvenementService(EvenementDAO evenementDAO, TypeDAO typeDAO) {
        this.evenementDAO = evenementDAO;
    }

    public void create(Evenement evenement) {
        System.out.println("[service] Création d'un nouvel évènement");
        this.evenementDAO.create(evenement);
    }

    public Set<Evenement> readAll() {
        System.out.println("[service] Lecture des évènements");

        return this.evenementDAO.readAll();
    }

    public Set<Evenement> search(Map<String, String> params){
        Map<String, String> nparams =  new HashMap<>();
        for (String key: params.keySet()) {
            if(params.get(key) != null ) {
                nparams.put(key, params.get(key) ) ;
            }
        }
        return this.evenementDAO.search(nparams) ;
    }

    public Set<Evenement> readparnom(String nomevt) {
        System.out.println("[service] Lecture des évènements selon le nom");
        return this.evenementDAO.readparnom(nomevt);
    }

    public Set<Evenement> readpartype(String nomtype) {
        System.out.println("[service] Lecture des évènements selon le type");
        return this.evenementDAO.readpartype(nomtype);
    }

    public Set<Evenement> readparid(int idevt) {
        System.out.println("[service] Lecture des évènements selon l'id");
        return this.evenementDAO.readparid(idevt);
    }

    public void updatenom(String nomevt, int idevt) {
        System.out.println("[service] Update de l'évènement selon le nom");
        this.evenementDAO.updatenom(nomevt, idevt);
    }
    public void updatedescription(String description, int idevt) {
        System.out.println("[service] Update de l'évènement selon l'id");
        this.evenementDAO.updatedescription(description, idevt);
    }
    public void updatetype(String typeevt, int idevt) {
        System.out.println("[service] Update de l'évènement selon le type");
        this.evenementDAO.updatetype(typeevt, idevt);
    }

    public void deleteparid(int idevt) {
        System.out.println("[Service] Suppression d'un évènement");
        this.evenementDAO.deleteparid(idevt);
    }
}
