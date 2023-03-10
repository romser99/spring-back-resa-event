package fr.solutec.resaevents.services;

import fr.solutec.resaevents.dao.TypeDAO;
import fr.solutec.resaevents.entites.Client;
import fr.solutec.resaevents.entites.Evenement;
import fr.solutec.resaevents.entites.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeService {
   TypeDAO typeDAO = new TypeDAO();

   public void create(Type type) {
       this.typeDAO.create(type);
   }

    public List<Type> read(int typeid) {
        return this.typeDAO.read(typeid);
    }

}


