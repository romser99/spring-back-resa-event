package fr.solutec.re.services;

import fr.solutec.re.dao.EquipeDAO;
import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Equipe;
import fr.solutec.re.entites.Gestionnaire;
import fr.solutec.re.enums.RoleEnum;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class EquipeService {
    private EquipeDAO equipeDAO ;

    public EquipeService(EquipeDAO equipeDAO) {
        this.equipeDAO = equipeDAO;
    }

    public void create(Equipe equipe){

        this.equipeDAO.create(equipe);

    }

    public Equipe read(int id){
        Equipe equipe = this.equipeDAO.read(id);
        return equipe;

    }

    public Set<Equipe> search(Map<String, String> params){
        Map<String, String> nparams =  new HashMap<>();
        for (String key: params.keySet()) {
            if(params.get(key) != null ) {
                nparams.put(key, params.get(key) ) ;
            }
        }

        return this.equipeDAO.search(nparams) ;
    }

    public void delete(int id){
        this.equipeDAO.delete(id);

    }

    public void update(int ideq, RoleEnum libelle) {
        this.equipeDAO.update(ideq, libelle);

    }
}
