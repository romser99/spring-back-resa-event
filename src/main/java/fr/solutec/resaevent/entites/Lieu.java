package fr.solutec.resaevent.entites;

public class Lieu {
    private int id;
    private String nom;
    private int idAdresse;
    private Adresse adresse;

    public Lieu(){}

    public Lieu(int id, String nom, int idAdresse, Adresse adresse) {
        this.id = id;
        this.nom = nom;
        this.idAdresse = idAdresse;
        this.adresse = adresse;
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

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }
    public int getIdAdresse() {
        return idAdresse;
    }
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    public Adresse getAdresse() {
        return adresse;
    }

}
