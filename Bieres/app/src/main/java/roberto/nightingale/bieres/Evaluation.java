package roberto.nightingale.bieres;

public class Evaluation {
    private String nom;
    private String microbrasserie;
    private int etoiles;

    public Evaluation(String nom, String microbrasserie, int etoiles) {
        this.nom = nom;
        this.microbrasserie = microbrasserie;
        this.etoiles = etoiles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMicrobrasserie() {
        return microbrasserie;
    }

    public void setMicrobrasserie(String microbrasserie) {
        this.microbrasserie = microbrasserie;
    }

    public int getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(int etoiles) {
        this.etoiles = etoiles;
    }
}
