package ehu.isad.controller.model;

import java.sql.Date;

public class Ordezkaritza {

    private String artistaIzena;
    private String herrialdeIzena;
    private Date urtea;
    private String abestiarenIzena;
    private int puntuak;

    public Ordezkaritza(String artistaIzena, String herrialdeIzena, Date urtea, String abestiarenIzena, int puntuak) {
        this.artistaIzena = artistaIzena;
        this.herrialdeIzena = herrialdeIzena;
        this.urtea = urtea;
        this.abestiarenIzena = abestiarenIzena;
        this.puntuak = puntuak;
    }

    @Override
    public String toString() {
        return this.abestiarenIzena;
    }
}
