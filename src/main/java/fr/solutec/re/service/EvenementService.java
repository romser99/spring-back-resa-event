package fr.solutec.re.service;

import fr.solutec.re.dao.EvenementDAO;
import fr.solutec.re.entites.Type;
import fr.solutec.re.repositories.EvenementRepository;
import fr.solutec.re.entites.Evenement;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.*;

@Service
public class EvenementService {
    private EvenementDAO evenementDAO;

    private EvenementRepository evenementRepository;

    public EvenementService(EvenementDAO evenementDAO, EvenementRepository evenemntRepository) {
        this.evenementDAO = evenementDAO;
        this.evenementRepository = evenemntRepository;
    }

    /* ///////////////////////////////////////CREATE&UPDATE/////////////////////////////// */

    public void create(Iterable<Evenement> evts) {
        this.evenementRepository.saveAll(evts);
    }

    /* ////////////////////////////////////READ///////////////////////////////////// */

    public Iterable<Evenement> readAll() {
        return this.evenementRepository.findAll();
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

    public Iterable<Evenement> readparid(Iterable<Integer> idevt) {
        return this.evenementRepository.findAllById(idevt);
    }


    /* //////////////////////////////////DELETE/////////////////////////////////////// */

    public void deleteparid(Iterable<Integer> id) {
        this.evenementRepository.deleteAllById(id);
    }

    /* //////////////////////////////////UPDATE///////////////////////////////////////

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
    } */
}
