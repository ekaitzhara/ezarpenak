package ehu.isad.controller.model;

public class Artista {

    private String izenArtistikoa;
    private int partaideKop;

    public Artista(String izenArtistikoa, int partaideKop) {
        this.izenArtistikoa = izenArtistikoa;
        this.partaideKop = partaideKop;
    }

    public String getIzenArtistikoa() {
        return izenArtistikoa;
    }
}
