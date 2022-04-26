package hu.EdzestervFront.domain;

import java.util.Date;

public class Edzesterv {
    private int id;
    private String email;
    private String nev;
    private Date szuldat;
    private String felhasznaloMegjegyzes;
    private int celId;
    private int felhasznaloid;
    private int elerendoSuly;
    private Date kezdes;
    private Date vege;
    private String celMegjegyzes;

    public Edzesterv() {
    }

    public Edzesterv(int id, String email, String nev, Date szuldat, String felhasznaloMegjegyzes, int celId, int felhasznaloid, int elerendoSuly, Date kezdes, Date vege, String celMegjegyzes) {
        this.id = id;
        this.email = email;
        this.nev = nev;
        this.szuldat = szuldat;
        this.felhasznaloMegjegyzes = felhasznaloMegjegyzes;
        this.celId = celId;
        this.felhasznaloid = felhasznaloid;
        this.elerendoSuly = elerendoSuly;
        this.kezdes = kezdes;
        this.vege = vege;
        this.celMegjegyzes = celMegjegyzes;
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

    public String getFelhasznaloMegjegyzes() {
        return felhasznaloMegjegyzes;
    }

    public void setFelhasznaloMegjegyzes(String felhasznaloMegjegyzes) {
        this.felhasznaloMegjegyzes = felhasznaloMegjegyzes;
    }

    public int getCelId() {
        return celId;
    }

    public void setCelId(int celId) {
        this.celId = celId;
    }

    public int getFelhasznaloid() {
        return felhasznaloid;
    }

    public void setFelhasznaloid(int felhasznaloid) {
        this.felhasznaloid = felhasznaloid;
    }

    public int getElerendoSuly() {
        return elerendoSuly;
    }

    public void setElerendoSuly(int elerendoSuly) {
        this.elerendoSuly = elerendoSuly;
    }

    public Date getKezdes() {
        return kezdes;
    }

    public void setKezdes(Date kezdes) {
        this.kezdes = kezdes;
    }

    public Date getVege() {
        return vege;
    }

    public void setVege(Date vege) {
        this.vege = vege;
    }

    public String getCelMegjegyzes() {
        return celMegjegyzes;
    }

    public void setCelMegjegyzes(String celMegjegyzes) {
        this.celMegjegyzes = celMegjegyzes;
    }

    @Override
    public String toString() {
        return "Edzesterv{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nev='" + nev + '\'' +
                ", szuldat=" + szuldat +
                ", megjegyzes='" + felhasznaloMegjegyzes + '\'' +
                ", celId=" + celId +
                ", felhasznaloid=" + felhasznaloid +
                ", elerendoSuly=" + elerendoSuly +
                ", kezdes=" + kezdes +
                ", vege=" + vege +
                ", celMegjegyzes='" + celMegjegyzes + '\'' +
                '}';
    }
}
