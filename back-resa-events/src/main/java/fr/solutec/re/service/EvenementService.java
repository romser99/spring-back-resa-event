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

    private TypeService typeService;
    private EvenementDAO evenementDAO;

    private EvenementRepository evenementRepository;

    public EvenementService(TypeService typeService, EvenementDAO evenementDAO, EvenementRepository evenementRepository) {
        this.typeService = typeService;
        this.evenementDAO = evenementDAO;
        this.evenementRepository = evenementRepository;
    }

    /* ///////////////////////////////////////CREATE&UPDATE/////////////////////////////// */

    public void create(Evenement evts) {
        this.evenementRepository.save(evts);
    }

    /* ////////////////////////////////////READ///////////////////////////////////// */

    public Iterable<Evenement> readAll() {
        return this.evenementRepository.findAll();
    }

    public List<Evenement> search(Map<String, String> params) {
        Map<String, String> nparams = new HashMap<>();
        for (String key : params.keySet()) {
            if (params.get(key) != null) {
                nparams.put(key, params.get(key));
            }
        }
        return this.evenementDAO.search(nparams);
    }

    public Optional<Evenement> findById(int id) {
        return evenementRepository.findById(id);
    }

    /* public Iterable<Evenement> readparid(Iterable<Integer> idevt) {
        return this.evenementRepository.findAllById(idevt);
    } */

    /* //////////////////////////////////DELETE/////////////////////////////////////// */

    public void deleteparid(Iterable<Integer> ids) {
        for (int id : ids) {
            if (evenementRepository.existsById(id)) {
                String message = String.format("Aucun évènement n'a l'id %s", id);
                throw new IllegalArgumentException();
            }
            this.evenementRepository.deleteAllById(ids);
        }
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
