package ehu.isad.controller.model;

public class Herrialde {

    private String izena;
    private String bandera;
    private String tv;


    public Herrialde(String izena, String bandera, String tv) {
        this.izena = izena;
        this.bandera = bandera;
        this.tv = tv;
    }

    public Herrialde(String izena) {
        this.izena = izena;
        this.bandera = null;
        this.tv = null;
    }

    public String getIzena() {
        return izena;
    }

    public String getBandera() {
        return bandera;
    }

    public String getTv() {
        return tv;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    @Override
    public String toString() {
        return this.izena;
    }
}
