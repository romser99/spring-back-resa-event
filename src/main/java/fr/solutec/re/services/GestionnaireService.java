package fr.solutec.re.services;

import fr.solutec.re.dao.GestionnaireDAO;
import fr.solutec.re.dao.LieuDAO;
import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Gestionnaire;
import fr.solutec.re.entites.Lieu;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class GestionnaireService {
    private GestionnaireDAO gestionnaireDAO ;

    public GestionnaireService(GestionnaireDAO gestionnaireDAO) {
        this.gestionnaireDAO = gestionnaireDAO;
    }

    public void create(Gestionnaire gestionnaire){

        this.gestionnaireDAO.create(gestionnaire);

    }

    public Gestionnaire read(int id){
        Gestionnaire gestionnaire = this.gestionnaireDAO.read(id);
        return gestionnaire;

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

    public void delete(int id){
        this.gestionnaireDAO.delete(id);

    }
}
