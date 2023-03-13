package fr.solutec.resaevent.services;

import fr.solutec.resaevent.dao.AdresseDAO;
import fr.solutec.resaevent.entites.Adresse;

import java.util.List;

public class AdresseService {

    /* CREATION D'UNE INSTANCE/OBJET DE LA CLASSE
     AdresseDAO type d'objet
     adresseDAO objet de l'instance
     new AdresseDAO() creation de l'instance
   */

    AdresseDAO adresseDAO = new AdresseDAO();

    ///CREATE
    public void create(Adresse adresse) {
        //Appel de la méthode create qui est dans AdresseDAO
        if (adresse.getRegion().isEmpty() || adresse.getRegion().isBlank()) {
            adresse.setRegion("Ile-de-France");
        }
        this.adresseDAO.create(adresse);
    }

    public List<Adresse> read() {
        return this.adresseDAO.read();
    }

    public List<Adresse> getOne(int id) {
        return this.adresseDAO.getOne(id);
    }
}



