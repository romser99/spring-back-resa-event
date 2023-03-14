package fr.solutec.re.Service;

import fr.solutec.re.DAO.EvenementDAO;
import fr.solutec.re.DAO.TypeDAO;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Evenement;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EvenementService {
    private EvenementDAO evenementDAO;
    private TypeDAO typeDAO;


    public EvenementService(EvenementDAO evenementDAO, TypeDAO typeDAO) {
        this.evenementDAO = evenementDAO;
        this.typeDAO = typeDAO;
    }

    public void create(Evenement evenement) {
        System.out.println("[service]Création d'un nouvel évènement");
        this.evenementDAO.create(evenement);
    }


    public Set<Evenement> readAll() {
        System.out.println("[service]Lecture des évènements");

        return this.evenementDAO.readAll();
    }
}
