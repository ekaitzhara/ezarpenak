package ehu.isad.controller.db;


import ehu.isad.controller.model.BozkatzekoDatuak;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrdezkaritzaDBKud {
    // Singleton patroia
    private static OrdezkaritzaDBKud instantzia = new OrdezkaritzaDBKud();

    public static OrdezkaritzaDBKud getInstantzia() {
        return instantzia;
    }

    private OrdezkaritzaDBKud() {

    }

    public List<BozkatzekoDatuak> emanBozkatzekoDatuak() {
        List<BozkatzekoDatuak> emaitza = new ArrayList<>();

        DBKudeatzaile dbKud = DBKudeatzaile.getInstantzia();
        String query = "SELECT h.bandera, h.izena, o.artista, o.abestia FROM Herrialde h, Ordezkaritza o WHERE h.izena=o.herrialdea AND o.urtea=strftime('%Y','now')";
        ResultSet rs = dbKud.execSQL(query);

        try {
            while (rs.next()) {
                String bandera = rs.getString("bandera") + ".png";
                String herrialdea = rs.getString("izena");
                String artista = rs.getString("artista");
                String abestia = rs.getString("abestia");

                emaitza.add(new BozkatzekoDatuak(bandera, herrialdea, artista, abestia));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return emaitza;
    }


    public void botoakEguneratu(String botoLortuHerrialde, int puntuKop) {

        DBKudeatzaile dbKud = DBKudeatzaile.getInstantzia();
        String query = "UPDATE Ordezkaritza SET puntuak=puntuak + '"+ puntuKop +"' WHERE herrialdea='"+ botoLortuHerrialde +"' AND urtea=YEAR(NOW());";
        dbKud.execSQL(query);
    }

    public List<BozkatzekoDatuak> emanTop3() {
        List<BozkatzekoDatuak> emaitza = new ArrayList<>();

        DBKudeatzaile dbKud = DBKudeatzaile.getInstantzia();
        String query = "SELECT h.bandera, o.herrialdea, o.puntuak FROM Herrialde h, Ordezkaritza o WHERE h.izena=o.herrialdea AND o.urtea=YEAR(NOW())" +
                "ORDER BY puntuak DESC LIMIT 3;";
        ResultSet rs = dbKud.execSQL(query);

        try {
            while (rs.next()) {
                String bandera = rs.getString("bandera") + ".png";
                String herrialdea = rs.getString("herrialdea");
                int puntuak = rs.getInt("puntuak");

                emaitza.add(new BozkatzekoDatuak(bandera, herrialdea, puntuak));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return emaitza;
    }

}
