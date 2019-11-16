package ehu.isad.controller.model;

import javafx.scene.image.Image;

public class BozkatzekoDatuak {

    private String banderaPath;
    private Image banderaImage;
    private String herrialdea;
    private String artista;
    private String abestia;
    private int puntuak;

    public BozkatzekoDatuak(String bandera, String herrialdea, String artista, String abestia) {
        this.banderaPath = bandera;
        this.banderaImage = new Image(bandera);
        this.herrialdea = herrialdea;
        this.artista = artista;
        this.abestia = abestia;
        puntuak = 0;
    }

    public BozkatzekoDatuak(String banderaPath, String herrialdea, String artista, String abestia, int puntuak) {
        this.banderaPath = banderaPath;
        this.banderaImage = new Image(banderaPath);
        this.herrialdea = herrialdea;
        this.artista = artista;
        this.abestia = abestia;
        this.puntuak = puntuak;
    }

    public BozkatzekoDatuak(String banderaPath, String herrialdea, int puntuak) {
        this.banderaPath = banderaPath;
        this.banderaImage = new Image(banderaPath);
        this.herrialdea = herrialdea;
        this.artista = null;
        this.abestia = null;
        this.puntuak = puntuak;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public String getBanderaPath() {
        return banderaPath;
    }

    public Image getBanderaImage() {
        return banderaImage;
    }

    public String getArtista() {
        return artista;
    }

    public String getAbestia() {
        return abestia;
    }

    public int getPuntuak() {
        return puntuak;
    }

    public void setBanderaPath(String banderaPath) {
        this.banderaPath = banderaPath;
    }

    public void setBanderaImage(Image banderaImage) {
        this.banderaImage = banderaImage;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setAbestia(String abestia) {
        this.abestia = abestia;
    }

    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }
}
