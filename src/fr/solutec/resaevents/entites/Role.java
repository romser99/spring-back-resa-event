package fr.solutec.resaevents.entites;

import fr.solutec.resaevents.enums.RoleEnum;

public class Role {
    // portee type nom
    private int id;
    private RoleEnum libelle;

    public Role() {
    }

    public Role(int id, RoleEnum libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    // definir des methodes
    // pour une methode, une signature : def nom
    public void setLibelle(RoleEnum libelle) {
        this.libelle = libelle;
    }
    public RoleEnum getLibelle() {
        return this.libelle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

}
