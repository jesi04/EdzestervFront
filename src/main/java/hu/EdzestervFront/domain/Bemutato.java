package hu.EdzestervFront.domain;

public class Bemutato {
    private int id;
    private int feladatid;
    private String fajlNeve;
    private String fajlTipusa;

    public Bemutato(int id, int feladatid, String fajlNeve, String fajlTipusa) {
        this.id = id;
        this.feladatid = feladatid;
        this.fajlNeve = fajlNeve;
        this.fajlTipusa = fajlTipusa;
    }

    public Bemutato() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFeladatid() {
        return feladatid;
    }

    public void setFeladatid(int feladatid) {
        this.feladatid = feladatid;
    }

    public String getFajlNeve() {
        return fajlNeve;
    }

    public void setFajlNeve(String fajlNeve) {
        this.fajlNeve = fajlNeve;
    }

    public String getFajlTipusa() {
        return fajlTipusa;
    }

    public void setFajlTipusa(String fajlTipusa) {
        this.fajlTipusa = fajlTipusa;
    }
}
