package fr.solutec.resaevent.services;

import fr.solutec.resaevent.dao.EvenementDAO;
import fr.solutec.resaevent.entites.Salle;
import fr.solutec.resaevent.entites.Type;
import fr.solutec.resaevent.repository.EvenementRepository;
import fr.solutec.resaevent.entites.Evenement;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.*;

@Service
public class EvenementService {

    private SalleService salleService;

    private TypeService typeService;
    private EvenementDAO evenementDAO;

    private EvenementRepository evenementRepository;

    public EvenementService(SalleService salleService, TypeService typeService, EvenementDAO evenementDAO, EvenementRepository evenementRepository) {
        this.salleService = salleService;
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

    public List<Evenement> search(Map<String, Object> params) {
        Map<String, Object> nparams = new HashMap<>();
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

}

