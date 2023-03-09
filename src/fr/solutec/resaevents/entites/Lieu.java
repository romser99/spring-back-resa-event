package fr.solutec.resaevents.entites;

public class Lieu extends Adresse {
    int id;

    String nom;

    public Lieu() {
    }

    public Lieu(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Lieu(int id, int numero, String rue, int codePostal, String ville, String region, String pays, int id1, String nom) {
        super(id, numero, rue, codePostal, ville, region, pays);
        this.id = id1;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
