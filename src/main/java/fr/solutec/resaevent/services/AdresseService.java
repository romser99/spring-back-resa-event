package fr.solutec.resaevent.services;
import fr.solutec.resaevent.entites.Adresse;
import fr.solutec.resaevent.repository.AdresseRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdresseService {

    /* CREATION D'UNE INSTANCE/OBJET DE LA CLASSE
     AdresseDAO type d'objet
     adresseDAO objet de l'instance
     new AdresseDAO() creation de l'instance */

    private AdresseRepository adresseRepository;
    public AdresseService(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }
    //SEARCH
    public Iterable<Adresse> findAll() {
        return this.adresseRepository.findAll();
    }
    //READ
    public Optional<Adresse> findById(int id) {
        return this.adresseRepository.findById(id);
    }
    //CREATE + UPDATE
    public Adresse save(Adresse adresse){
        if (adresse.getRegion() == null) {
            adresse.setRegion("Ile-de-France");
        }
        if (adresse.getPays() == null) {
            adresse.setPays("France");
        }
        return this.adresseRepository.save(adresse);
    }
    public Adresse delete(int id){
        this.adresseRepository.deleteById(id);
        return null;
    }
}