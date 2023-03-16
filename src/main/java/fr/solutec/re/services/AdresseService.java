package fr.solutec.re.services;

import fr.solutec.re.DAO.AdresseDAO;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.repository.AdresseRepository;
import org.springframework.stereotype.Service;

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
        return this.adresseRepository.findAll();
    }
}
