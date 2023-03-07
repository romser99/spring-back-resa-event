package fr.solutec.resaevent.entites;

import fr.solutec.resaevent.enums.RoleEnum;

public class Role {
    private int id ;
    private RoleEnum libelle ;

    public Role(int id, RoleEnum libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleEnum getLibelle() {
        return libelle;
    }

    public void setLibelle(RoleEnum libelle) {
        this.libelle = libelle;
    }
}
