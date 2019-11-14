package ehu.isad.controller.db;

import ehu.isad.controller.model.Herrialde;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BozkaketaDBKud {

    // Singleton patroia
    private static BozkaketaDBKud instantzia = new BozkaketaDBKud();

    public static BozkaketaDBKud getInstantzia() {
        return instantzia;
    }

    private BozkaketaDBKud() {

    }

    public boolean bozkatuDu(String herrialdea) {

        DBKudeatzaile dbKud = DBKudeatzaile.getInstantzia();
        String query = "SELECT * FROM Bozkaketa WHERE bozkatuDu=" + herrialdea + " AND urtea=YEAR(NOW());";
        ResultSet rs = dbKud.execSQL(query);

        if (rs == null) {
            return true;
        } else {
            return false;
        }
    }

    public void bozkaketaBerria(String botoEmanHerrialde, String botoLortuHerrialde, int puntuKop) {

        DBKudeatzaile dbKud = DBKudeatzaile.getInstantzia();
        String query = "INSERT INTO Bozkaketa SET bozkatuDu=" +botoEmanHerrialde+ ", bozkatuaIzanDa=" +botoLortuHerrialde +
                ", puntuak=" +puntuKop+", urtea=YEAR(NOW());";
        dbKud.execSQL(query);

    }


}
