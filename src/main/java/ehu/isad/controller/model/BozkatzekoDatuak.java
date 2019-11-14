package ehu.isad.controller.model;

public class BozkatzekoDatuak {

    private String bandera;
    private String herrialdea;
    private String artista;
    private String abestia;
    private int puntuak;

    public BozkatzekoDatuak(String bandera, String herrialdea, String artista, String abestia) {
        this.bandera = bandera;
        this.herrialdea = herrialdea;
        this.artista = artista;
        this.abestia = abestia;
        puntuak = 0;
    }

    public String getHerrialdea() {
        return herrialdea;
    }
}
