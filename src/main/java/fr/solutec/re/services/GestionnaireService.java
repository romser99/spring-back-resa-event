package fr.solutec.re.services;

import fr.solutec.re.dao.GestionnaireDAO;
import fr.solutec.re.dao.LieuDAO;
import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Gestionnaire;
import fr.solutec.re.entites.Lieu;
import fr.solutec.re.repository.GestionnaireRepository;
import org.springframework.stereotype.Service;

import java.net.BindException;
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

    public void save(Gestionnaire gestionnaire) throws BindException {
        String Email = gestionnaire.getEmail();
        String password = gestionnaire.getPassword();
        Optional<Gestionnaire> optionalgestionnaire = this.gestionnaireRepository.findByEmail(Email);
        if (Email == null || password == null){
            String message = "Veuillez remplir tout les champs obligatoires indiqués par *";
            throw new IllegalStateException(message) ;
        }
        if (optionalgestionnaire.isEmpty() == false) {
            String message = String.format ("Un compte est déja associé au mail %s", Email);
            throw new BindException(message) ;

        }
        this.gestionnaireRepository.save(gestionnaire);


    }

    public Gestionnaire findById(int id){
        Optional<Gestionnaire> optionalgestionnaire = this.gestionnaireRepository.findById(id);
        if (optionalgestionnaire.isEmpty()){
            String message = String.format ("Aucun gestionnaire n'a l'id %s", id);
            throw new IllegalArgumentException(message) ;
        }
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
        Optional<Gestionnaire> optionalgestionnaire = this.gestionnaireRepository.findById(id);
        if (optionalgestionnaire.isEmpty()){
            String message = String.format ("Aucun gestionnaire n'a l'id %s", id);
            throw new IllegalArgumentException(message) ;
        }
        this.gestionnaireRepository.deleteById(id);

    }
}
