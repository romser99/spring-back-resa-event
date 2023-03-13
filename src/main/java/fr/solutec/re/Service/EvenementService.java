package fr.solutec.re.Service;

import fr.solutec.re.DAO.EvenementDAO;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Evenement;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EvenementService {
    private EvenementDAO evenementDAO;

    public EvenementService(EvenementDAO evenementDAO) {
        this.evenementDAO = evenementDAO;
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
