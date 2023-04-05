package fr.solutec.resaevent.services;
import fr.solutec.resaevent.entites.Salle;
import fr.solutec.resaevent.repository.SalleRepository;
import org.springframework.stereotype.Service;

@Service
public class SalleService {
    private SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public void save(Salle salle) {
        System.out.println("[service]Création d'un nouvel évènement");
        this.salleRepository.save(salle);
    }

    public Iterable<Salle> findAll() {
        System.out.println("[service]Lecture des évènements");
        return this.salleRepository.findAll();
    }
}
