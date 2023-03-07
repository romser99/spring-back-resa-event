package fr.solutec.resaevents.entites;

public class Equipe extends Personne {
    private int id;

    public Equipe() {
    }

    public Equipe(int id) {
        this.id = id;
    }

    //constructeur au dessus (super) comme parent
    public Equipe(String nom, String prenom, String mdp, String mail, String telephone, int id) {
        super(nom, prenom, mdp, mail, telephone);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
