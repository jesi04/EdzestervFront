package hu.EdzestervFront.domain;

public class Feladat {

    private int id;
    private String nev;
    private int elegetettKcal;
    private String leiras;
    private String megjegyzes;

    public Feladat(int id, String nev, int elegetettKcal, String leiras, String megjegyzes) {
        this.id = id;
        this.nev = nev;
        this.elegetettKcal = elegetettKcal;
        this.leiras = leiras;
        this.megjegyzes = megjegyzes;
    }

    public Feladat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getElegetettKcal() {
        return elegetettKcal;
    }

    public void setElegetettKcal(int elegetettKcal) {
        this.elegetettKcal = elegetettKcal;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }
}
