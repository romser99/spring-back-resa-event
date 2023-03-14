package fr.solutec.re.services;

import fr.solutec.re.dao.EquipeDAO;
import fr.solutec.re.entites.Equipe;
import org.springframework.stereotype.Service;

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

    public Set<Equipe> readALL(){

        return this.equipeDAO.readALL();

    }
}
