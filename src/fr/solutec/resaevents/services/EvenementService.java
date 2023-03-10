package fr.solutec.resaevents.services;

import fr.solutec.resaevents.dao.EvenementDAO;
import fr.solutec.resaevents.entites.Evenement;
import fr.solutec.resaevents.entites.Lieu;
import fr.solutec.resaevents.entites.Type;

import java.util.ArrayList;
import java.util.List;

public class EvenementService {

    EvenementDAO evenementDAO = new EvenementDAO();

    public void create(Evenement evenement) {
        this.evenementDAO.create(evenement);
    }

    public List<Evenement> read(int evenementid) {
        return this.evenementDAO.read(evenementid);
    }

    public List<Evenement> readevt(int idevt) {
        return this.evenementDAO.read(idevt);
    }

    public void update(int evenementid, int typeid) { this.evenementDAO.update(evenementid, typeid);
    }

}

