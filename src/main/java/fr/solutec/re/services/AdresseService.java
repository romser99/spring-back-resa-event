package fr.solutec.re.services;

import fr.solutec.re.DAO.AdresseDAO;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Lieu;
import fr.solutec.re.repository.AdresseRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AdresseService {
    private AdresseRepository adresseRepository;
    public AdresseService(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    public Adresse create (Adresse adresse) {
        System.out.println("[Service] Création nouvelle adresse");
        return this.adresseRepository.save(adresse);
    }
    public Iterable<Adresse> readAll () {
        System.out.println("[Service] Lecture des adresses");
        Iterable<Adresse> iterableAdresse = this.adresseRepository.findAll();
        if(IterableUtils.size(iterableAdresse) == 0) {
            String message = String.format("Il n'existe aucune adresse dans la base de données");
            throw new IllegalArgumentException(message);
        }
        return this.adresseRepository.findAll();
    }

    public Adresse read (int id) {
        System.out.println("[Service] Lecture de l'adresse");
        Optional<Adresse> optionalAdresse = this.adresseRepository.findById(id);
        if(optionalAdresse.isEmpty()) {
            String message = String.format("Aucune adresse n'a cet ID %s", id);
            throw new IllegalArgumentException(message);
        }
        return optionalAdresse.get();
    }
}
