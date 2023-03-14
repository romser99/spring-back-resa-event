package fr.solutec.re.services;

import fr.solutec.re.DAO.AdresseDAO;
import fr.solutec.re.entites.Adresse;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdresseService {
    private AdresseDAO adresseDAO;
    public AdresseService(AdresseDAO adresseDAO) {
        this.adresseDAO = adresseDAO;
    }

    public Adresse create (Adresse adresse) {
        System.out.println("[Service] Création nouvelle adresse");
        return this.adresseDAO.create(adresse);
    }

    public Set<Adresse> readAll () {
        return this.adresseDAO.readAll();
    }
}
