package fr.solutec.resaevent.services;

import fr.solutec.resaevent.entites.Evenement;
import fr.solutec.resaevent.dao.TypeDAO;
import fr.solutec.resaevent.repository.TypeRepository;
import fr.solutec.resaevent.entites.Type;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class TypeService {

    private TypeRepository typeRepository;
    private TypeDAO typeDAO;


    public TypeService(TypeRepository typeRepository, TypeDAO typeDAO) {
        this.typeRepository = typeRepository;
        this.typeDAO = typeDAO;
    }

    public void create(Type type) {
        System.out.println("[service] Création d'un nouveau type");
        this.typeRepository.save(type);
    }
    public Iterable<Type> readAll() {
        System.out.println("[service] Lecture des types");
        return this.typeRepository.findAll();
    }

    public Type readByNom(String nomtype) {
        return this.typeRepository.findByNom(nomtype);
    }
    public int idByNom(String nom) {
        return this.typeRepository.findByNom(nom).getId();
    }
    public List<Type> search(Map<String, String> params) {
        Map<String, String> nparams = new HashMap<>();
        for (String key : params.keySet()) {
            if (params.get(key) != null) {
                nparams.put(key, params.get(key));
            }
        }
        return this.typeDAO.search(nparams);
    }
    public void delete(int idtype) {
        System.out.println("[Service] Suppression d'un type");
        this.typeRepository.deleteById(idtype);
    }

}
