package fr.solutec.re.service;

import fr.solutec.re.dao.AdresseDAO;
import fr.solutec.re.entites.Adresse;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdresseService {
    private AdresseDAO adresseDAO;

    public AdresseService(AdresseDAO adresseDAO) {
        this.adresseDAO = adresseDAO;
    }

    public Adresse create(Adresse adresse) {
        System.out.println("[service]Création d'une nouvelle adresse");
        return this.adresseDAO.create(adresse);
    }

    public Set<Adresse> readAll() {
        System.out.println("[service]Lecture des adresses");

        return this.adresseDAO.readAll();
    }
}
