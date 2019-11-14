package ehu.isad.controller.db;

import ehu.isad.controller.model.Herrialde;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HerrialdeDBKud {

    // Singleton patroia
    private static HerrialdeDBKud instantzia = new HerrialdeDBKud();

    public static HerrialdeDBKud getInstantzia() {
        return instantzia;
    }

    private HerrialdeDBKud() {

    }

    public List<Herrialde> lortuHerrialdeak() {
        List<Herrialde> emaitza = new ArrayList<>();

        DBKudeatzaile dbKud = DBKudeatzaile.getInstantzia();
        String query = "SELECT izena, bandera, tv FROM Herrialde";
        ResultSet rs = dbKud.execSQL(query);

        try {
            while (rs.next()) {
                String izen = rs.getString("izena");
                String banderaH = rs.getString("bandera");
                String tv_H = rs.getString("tv");

                emaitza.add(new Herrialde(izen, banderaH, tv_H));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return emaitza;
    }


}
