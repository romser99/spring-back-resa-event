package fr.solutec.re.services;

import fr.solutec.re.dao.GestionnaireDAO;
import fr.solutec.re.dao.LieuDAO;
import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Gestionnaire;
import fr.solutec.re.entites.Lieu;
import fr.solutec.re.repository.GestionnaireRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class GestionnaireService {
    private GestionnaireDAO gestionnaireDAO ;
    private GestionnaireRepository gestionnaireRepository;

    public GestionnaireService(GestionnaireDAO gestionnaireDAO, GestionnaireRepository gestionnaireRepository) {
        this.gestionnaireDAO = gestionnaireDAO;
        this.gestionnaireRepository = gestionnaireRepository;
    }

    public void save(Gestionnaire gestionnaire){
        this.gestionnaireRepository.save(gestionnaire);

    }

    public Gestionnaire findById(int id){
        Optional<Gestionnaire> optionalgestionnaire = this.gestionnaireRepository.findById(id);
        return optionalgestionnaire.get();

    }

    public Set<Gestionnaire> search(Map<String, String> params){
        Map<String, String> nparams =  new HashMap<>();
        for (String key: params.keySet()) {
            if(params.get(key) != null ) {
                nparams.put(key, params.get(key) ) ;
            }
        }

        return this.gestionnaireDAO.search(nparams) ;
    }

    public void deleteById(int id){
        this.gestionnaireRepository.deleteById(id);

    }
}
