package fr.solutec.re.service;

import fr.solutec.re.dao.SalleDAO;
import fr.solutec.re.entites.Salle;
import fr.solutec.re.repositories.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SalleService {

    private SalleRepository salleRepository;
    private SalleDAO salleDAO;

    public SalleService(SalleDAO salleDAO) {
        this.salleDAO = salleDAO;
    }

    public void create(Salle salle) {
        System.out.println("[service]Création d'un nouvel évènement");
        this.salleDAO.create(salle);
    }


    public Set<Salle> readAll() {
        System.out.println("[service]Lecture des évènements");
        return this.salleDAO.readAll();
    }

    /*
    public int idById(int id) {
        return this.salleRepository.findById(id).getId();
    }

     */


}