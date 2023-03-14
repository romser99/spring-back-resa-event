package fr.solutec.re.entites;

public class Adresse {
    private int id;
    private int numero;
    private String rue;

    public Adresse() {
    }

    public Adresse(int id, int numero, String rue) {
        this.id = id;
        this.numero = numero;
        this.rue = rue;
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
}
