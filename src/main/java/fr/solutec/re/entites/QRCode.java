package fr.solutec.re.entites;

public class QRCode {
    private int id;

    private String url;

    public QRCode() {
    }

    public QRCode(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

