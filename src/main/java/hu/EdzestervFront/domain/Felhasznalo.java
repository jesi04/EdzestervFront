package hu.EdzestervFront.domain;

import java.util.Date;

public class Felhasznalo {

    private int id;
    private String email;
    private String nev;
    private Date szuldat;
    private int magassag;
    private String megjegyzes;

    public Felhasznalo(int id, String email, String nev, Date szuldat, int magassag, String megjegyzes) {
        this.id = id;
        this.email = email;
        this.nev = nev;
        this.szuldat = szuldat;
        this.magassag = magassag;
        this.megjegyzes = megjegyzes;
    }

    public Felhasznalo(int id, String email, String nev) {
        this.id = id;
        this.email = email;
        this.nev = nev;
    }

    public Felhasznalo(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public Felhasznalo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Date getSzuldat() {
        return szuldat;
    }

    public void setSzuldat(Date szuldat) {
        this.szuldat = szuldat;
    }

    public int getMagassag() {
        return magassag;
    }

    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }
}
