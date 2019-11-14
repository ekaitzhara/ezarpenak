package ehu.isad.controller.db;

import ehu.isad.controller.model.Herrialde;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParteHartzeaDBKud {

    // Singleton patroia
    private static ParteHartzeaDBKud instantzia = new ParteHartzeaDBKud();

    public static ParteHartzeaDBKud getInstantzia() {
        return instantzia;
    }

    private ParteHartzeaDBKud() {

    }



    public List<Herrialde> emanParteHartuHerrialdeak() {
        List<Herrialde> emaitza = new ArrayList<>();

        DBKudeatzaile dbKud = DBKudeatzaile.getInstantzia();
        String query = "SELECT izena FROM ParteHartzea WHERE etorrikoDa='bai' AND urtea=YEAR(NOW());";
        ResultSet rs = dbKud.execSQL(query);

        try {
            while (rs.next()) {
                String izen = rs.getString("izena");

                emaitza.add(new Herrialde(izen));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return emaitza;
    }

}
