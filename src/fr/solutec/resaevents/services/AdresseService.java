package fr.solutec.resaevents.services;

import fr.solutec.resaevents.dao.AdresseDAO;
import fr.solutec.resaevents.entites.Adresse;

import java.sql.SQLException;
import java.util.List;

public class AdresseService {

    // creation d'une instance/objet de la classe
    AdresseDAO adresseDAO = new AdresseDAO();
    public void create(Adresse adresse) throws SQLException {
        // appel de la methode create dans AdresseDAO
        if (adresse.getRegion().isEmpty() || adresse.getRegion().isBlank()) {
            adresse.setRegion("Ile de France");
        }
        this.adresseDAO.create(adresse);
    }

    public List<Adresse> read() {
        return this.adresseDAO.read();
    }
}
