package fr.solutec.re.services;

import fr.solutec.re.dao.LieuDAO;
import fr.solutec.re.entites.Lieu;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service

public class LieuService {

    private LieuDAO lieuDAO ;

    public LieuService(LieuDAO lieuDAO) {
        this.lieuDAO = lieuDAO;
    }

    public void create(Lieu lieu){
        System.out.println("[service]creation d'un nouveau lieu");
        this.lieuDAO.create(lieu);

    }

    public Set<Lieu> readALL(){
        System.out.println("lecture des lieux");
        return this.lieuDAO.readALL();

    }
}
