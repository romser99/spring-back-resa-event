package fr.solutec.re.entites;

import javax.persistence.*;

@Entity
@Table(name = "equipe")
public class Equipe extends Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    public Role role ;

    public Equipe () {
    }

    public Equipe(String prenom, String nom, String email, String telephone, String password, int id, Role role) {
        super(prenom, nom, email, telephone, password);
        this.id = id;
        this.role = role;
    }

    public Equipe(int id, Role role) {
        this.id = id;
        this.role = role;
    }

        public int getId() {
        return id;
    }

        public void setId(int id) {
        this.id = id;
    }

        public Role getRole() {
        return role;
    }

        public void setRole(Role role) {
        this.role = role;
    }
}
