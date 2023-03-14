package fr.solutec.re.services;

import fr.solutec.re.dao.GestionnaireDAO;
import fr.solutec.re.dao.LieuDAO;
import fr.solutec.re.entites.Gestionnaire;
import fr.solutec.re.entites.Lieu;
import org.springframework.stereotype.Service;

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

    public Set<Gestionnaire> readALL(){

        return this.gestionnaireDAO.readALL();

    }
}
