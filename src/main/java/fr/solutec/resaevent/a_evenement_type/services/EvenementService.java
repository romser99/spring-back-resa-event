package fr.solutec.resaevent.a_evenement_type.services;

import fr.solutec.re.dao.EvenementDAO;
import fr.solutec.re.entites.Type;
import fr.solutec.re.repositories.EvenementRepository;
import fr.solutec.re.entites.Evenement;
import fr.solutec.resaevent.a_evenement_type.dao.EvenementDAO;
import fr.solutec.resaevent.a_evenement_type.entites.Evenement;
import fr.solutec.resaevent.a_evenement_type.entites.Type;
import fr.solutec.resaevent.a_evenement_type.repository.EvenementRepository;
import org.springframework.stereotype.Service;

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

    public void create(Iterable<Evenement> evts) {
        evts.forEach(evenement -> {
            Type type = this.typeService.readByNom(evenement.getType().getNom());
            evenement.setType(type);
        });
        this.evenementRepository.saveAll(evts);
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
