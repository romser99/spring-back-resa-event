package fr.solutec.resaevents.services;

import fr.solutec.resaevents.entites.Type;
public class TypeService {
    public Type create(Type type) {
        Type TypeACreer = new Type();
        TypeACreer.setNom(type.getNom());
        TypeACreer.setId(TypeACreer.getId());
        return TypeACreer;
    }

    public void display(Type TypeACreer) {
        System.out.println("Le type " + TypeACreer.getNom() + " a l'id " + TypeACreer.getId());
    }
}
