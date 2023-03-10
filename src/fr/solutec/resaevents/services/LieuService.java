package fr.solutec.resaevents.services;

import fr.solutec.resaevents.dao.LieuDAO;
import fr.solutec.resaevents.entites.Adresse;
import fr.solutec.resaevents.entites.Lieu;

import java.util.List;

public class LieuService {

    LieuDAO lieuDAO = new LieuDAO();
    public void create(Lieu lieu) {
        this.lieuDAO.create(lieu);
    }

    public List<Lieu> read(int lieuid) {
        return this.lieuDAO.read(lieuid);
    }

    public List<Lieu> readlieu() {
        return this.lieuDAO.readlieu();
    }

    public void update(int lieuid, int adresseid) { this.lieuDAO.update(lieuid, adresseid);
    }
}
