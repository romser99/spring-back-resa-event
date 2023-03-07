package fr.solutec.resaevents.entites;

// on ne peut pas faire de new dessus, pas instanciée
public abstract class Personne {

    private String nom;
    private String prenom;
    private String mdp;
    private String mail;
    private String telephone;

    public Personne() {
    }

    public Personne(String nom, String prenom, String mdp, String mail, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.mail = mail;
        this.telephone = telephone;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return this.nom;
    }
    public void setPrenom(String prenom) {
        this.nom = prenom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public String getMdp() {
        return this.mdp;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getMail() {
        return this.mail;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getTelephone() {
        return this.telephone;
    }


}
