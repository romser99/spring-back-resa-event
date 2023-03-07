package fr.solutec.resaevent.entites;
// classe abstraite est unz classe qu'on ne peut pas instancier (pas de neww possible)
// Il faut hériter de la classe pour l'instancier
public abstract class Personne {
    private String prenom ;
    private String nom ;
    private String email ;
    private String telephone ;
    private String password;
    private Role role ;

    public Personne( String prenom, String nom, String email, String telephone, String password, Role role) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.role = role;
    }

    public Personne() {

    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
