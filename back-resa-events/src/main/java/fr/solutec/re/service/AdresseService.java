package fr.solutec.re.service;

import fr.solutec.re.dao.AdresseDAO;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Lieu;
import fr.solutec.re.repositories.AdresseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AdresseService {
    private AdresseDAO adresseDAO;

    private AdresseRepository adresseRepository;

    public AdresseService(AdresseDAO adresseDAO, AdresseRepository adresseRepository) {
        this.adresseDAO = adresseDAO;
        this.adresseRepository = adresseRepository;
    }

    public Adresse create(Adresse adresse) {

        return this.adresseDAO.create(adresse);
    }

    public Adresse read(int id) {
        Optional<Adresse> optionalAdresse = this.adresseRepository.findById(id); // peut-être qu'il n'y a pas de lieu correspondant
        //// gestion de l'erreur
        if(optionalAdresse.isEmpty()) {
            String message = String.format("Aucune Adresse n'a l'id %s", id);
            throw new IllegalArgumentException();
        }
        return optionalAdresse.get();
    }
}
