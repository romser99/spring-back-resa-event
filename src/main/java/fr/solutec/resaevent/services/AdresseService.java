package fr.solutec.resaevent.services;

import fr.solutec.resaevent.dao.AdresseDAO;
import fr.solutec.resaevent.entites.Adresse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AdresseService {

    /* CREATION D'UNE INSTANCE/OBJET DE LA CLASSE
     AdresseDAO type d'objet
     adresseDAO objet de l'instance
     new AdresseDAO() creation de l'instance */

    private AdresseDAO adresseDAO;
    public AdresseService(AdresseDAO adresseDAO) {
        this.adresseDAO = adresseDAO;
    }
    public Adresse create(Adresse adresse){
        //Appel de la méthode create qui est dans AdresseDAO
        if (adresse.getRegion() == null) {
            adresse.setRegion("Ile-de-France");
        }
        if (adresse.getPays() == null) {
            adresse.setPays("France");
        }
        return this.adresseDAO.create(adresse);
    }
    public Set<Adresse> readAll() {
        return this.adresseDAO.readAll();
    }
}

/*
    public List<Adresse> read() {
        return this.adresseDAO.read();
    }

    public List<Adresse> getOne(int id) {
        return this.adresseDAO.getOne(id);
    }
}
*/

