package fr.solutec.re.services;

import fr.solutec.re.dao.EquipeDAO;
import fr.solutec.re.entites.Equipe;

import fr.solutec.re.enums.RoleEnum;
import fr.solutec.re.repository.EquipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class EquipeService {
    private EquipeDAO equipeDAO ;
    private EquipeRepository equipeRepository;

    public EquipeService(EquipeDAO equipeDAO, EquipeRepository equipeRepository) {
        this.equipeDAO = equipeDAO;
        this.equipeRepository = equipeRepository;
    }

    public void save(Equipe equipe){
        this.equipeRepository.save(equipe);
    }

    public Equipe findById(int id){
        Optional<Equipe> optionalequipe = this.equipeRepository.findById(id);
        return optionalequipe.get();

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

    public void deleteById(int id){
        this.equipeRepository.deleteById(id);

    }

    public void update(int ideq, RoleEnum libelle) {
        this.equipeDAO.update(ideq, libelle);

    }
}
