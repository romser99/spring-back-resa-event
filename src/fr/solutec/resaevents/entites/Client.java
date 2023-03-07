package fr.solutec.resaevents.entites;

public class Client extends Personne {
    private int id;

    public Client(int id) {
        this.id = id;
    }

    public Client(String nom, String prenom, String mdp, String mail, String telephone, int id) {
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
