package fr.solutec.re.services;

import fr.solutec.re.dao.EquipeDAO;
import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Equipe;

import fr.solutec.re.enums.RoleEnum;
import fr.solutec.re.repository.EquipeRepository;
import org.springframework.stereotype.Service;

import java.net.BindException;
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

    public void save(Equipe equipe) throws BindException {
        String Email = equipe.getEmail();
        String password = equipe.getPassword();
        Optional<Equipe> optionalequipe = this.equipeRepository.findByEmail(Email);
        if (Email == null || password == null){
            String message = "Veuillez remplir tout les champs obligatoires indiqués par *";
            throw new IllegalStateException(message) ;
        }
        if (optionalequipe.isEmpty() == false) {
            String message = String.format ("Un compte est déja associé au mail %s", Email);
            throw new BindException(message) ;

        }
        this.equipeRepository.save(equipe);
    }

    public Equipe findById(int id){
        Optional<Equipe> optionalequipe = this.equipeRepository.findById(id);
        if (optionalequipe.isEmpty()){
            String message = String.format ("Aucune equipe n'a l'id %s", id);
            throw new IllegalArgumentException(message) ;
        }
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
        Optional<Equipe> optionalequipe = this.equipeRepository.findById(id);
        if (optionalequipe.isEmpty()){
            String message = String.format ("Aucune equipe n'a l'id %s", id);
            throw new IllegalArgumentException(message) ;
        }
        this.equipeRepository.deleteById(id);

    }

    public void update(int ideq, RoleEnum libelle) {
        Optional<Equipe> optionalequipe = this.equipeRepository.findById(ideq);
        if (optionalequipe.isEmpty()){
            String message = String.format ("Aucune equipe n'a l'id %s", ideq);
            throw new IllegalArgumentException(message) ;
        }
        this.equipeDAO.update(ideq, libelle);

    }
}
