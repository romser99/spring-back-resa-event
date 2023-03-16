package fr.solutec.re.entites;

import fr.solutec.re.entites.Adresse;
import javax.persistence.*;

@Entity
@Table(name ="adresse")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numero;
    private String rue;
    private int codepostal;
    private String ville;
    private String region;
    private String pays;

    public Adresse () {
    }

    public Adresse(int id, int numero, String rue, int codepostal, String ville, String region, String pays) {
        this.id = id;
        this.numero = numero;
        this.rue = rue;
        this.codepostal = codepostal;
        this.ville = ville;
        this.region = region;
        this.pays = pays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(int codepostal) {
        this.codepostal = codepostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
