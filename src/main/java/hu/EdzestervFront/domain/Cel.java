package hu.EdzestervFront.domain;

import javax.persistence.ManyToOne;
import java.util.Date;

public class Cel {

    private int id;
    private int felhasznaloid;
    private Felhasznalo felhasznalo;
    private int elerendoSuly;
    private Date kezdes;
    private Date vege;
    private String megjegyzes;

    public Cel(int id, int felhasznaloid, Felhasznalo felhasznalo, int elerendoSuly, Date kezdes, Date vege, String megjegyzes) {
        this.id = id;
        this.felhasznaloid = felhasznaloid;
        this.felhasznalo = felhasznalo;
        this.elerendoSuly = elerendoSuly;
        this.kezdes = kezdes;
        this.vege = vege;
        this.megjegyzes = megjegyzes;
    }

    public Cel(int id, int elerendoSuly, String megjegyzes) {
        this.id = id;
        this.elerendoSuly = elerendoSuly;
        this.megjegyzes = megjegyzes;
    }

    public Cel(int id, int elerendoSuly) {
        this.id = id;
        this.elerendoSuly = elerendoSuly;
    }

    public Cel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFelhasznaloid() {
        return felhasznaloid;
    }

    public void setFelhasznaloid(int felhasznaloid) {
        this.felhasznaloid = felhasznaloid;
    }

    public Felhasznalo getFelhasznalo() {
        return felhasznalo;
    }

    public void setFelhasznalo(Felhasznalo felhasznalo) {
        this.felhasznalo = felhasznalo;
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

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }
}
