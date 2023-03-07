package fr.solutec.resaevent.entites;

public class Equipe extends Personne{
    private int id;

    public Equipe () {
    }

    public Equipe (int id) {
        this.id=id;
    }

    public Equipe(String prenom, String nom, String email, String telephone, String password, Role role, int id) {
        super(prenom, nom, email, telephone, password, role);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
