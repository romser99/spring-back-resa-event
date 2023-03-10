package fr.solutec.resaevents.services;

import fr.solutec.resaevents.entites.Client;
import fr.solutec.resaevents.entites.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeService {
    /*public Type create(Type type) {
        Type TypeACreer = new Type();
        TypeACreer.setNom(type.getNom());
        TypeACreer.setId(TypeACreer.getId());
        return TypeACreer;
    }

    public void display(Type TypeACreer) {
        System.out.println("Le type " + TypeACreer.getNom() + " a l'id " + TypeACreer.getId());
    } */

    public Type create(Type type) {
        int id = (int)(Math.random() * 50 + 1);
        type.setId(id);
        return new Type(type.getId(), type.getNom());
    }

    public List<Type> list() {
        List<Type> types = new ArrayList<>();
        for (int i = 0; i < 10; i++ ) {
            Type type = new Type();
            type.setNom("Nom" + i);
        }
        return types;
    }

    public void display(Type type) {
        System.out.println("le Type " + type.getNom() + " a l'id " + type.getId());
    }

    public Type read(String nom) {
        List<Type> types = this.list();
        Type type;
        type = this.filter(types, nom);
        return type;
    }

    private Type filter(List<Type> types, String nom) {
        return types.stream().filter(type -> type.getNom().equals(nom)).findFirst().get();
    }

    public void delete(int id) { // potentiellement supp
    }
}


