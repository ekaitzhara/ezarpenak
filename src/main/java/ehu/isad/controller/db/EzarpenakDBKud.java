package ehu.isad.controller.db;

import ehu.isad.controller.model.Ezarpena;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EzarpenakDBKud {

    // Singleton patroia
    private static EzarpenakDBKud instantzia = new EzarpenakDBKud();

    public static EzarpenakDBKud getInstantzia() {
        return instantzia;
    }

    private EzarpenakDBKud () {

    }

    public List<Ezarpena> lortuEzarpenak() {
        List<Ezarpena> emaitza = new ArrayList<>();

        DBKudeatzaile dbKud = DBKudeatzaile.getInstantzia();
        String query = "SELECT userid, `key`, value FROM properties";
        ResultSet rs = dbKud.execSQL(query);

        try {
            while (rs.next()) {
                Integer erabId = rs.getInt("userid");
                String key = rs.getString("key");
                String value = rs.getString("value");

                emaitza.add(new Ezarpena(erabId, key, value));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return emaitza;
    }
}
