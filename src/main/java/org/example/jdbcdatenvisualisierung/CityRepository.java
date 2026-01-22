package org.example.jdbcdatenvisualisierung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// TODO: Laden aller Städte mit ihrer Einwohnerzahl in einer Collection
//   Die Anzahl pro Gruppe  - die Gruppierung - erfolgt in einer Methode deren Rückgabewert  List<CityGroup>   ist
//   die Gruppendefinition (100000,1000000)  wird über eine INT-Collectin übergeben
//   die Collection muss aufsteigend sortiert sein - wenn nicht -> Exception
//

// TODO: GUI erweitern, sodass auch Grenzen ausgewählt werden können. dh. es muss Checkboxen für die
//    Grenzen geben (20k, 50k, 100k, 1M, 5M, 10M etc.)  und die Diagramme müssen sich entsprechend anpassen
public class CityRepository {



    public List<CityGroup> getAllCities() throws Exception {

        Connection conn = Database.connect();

        String sql =
                "SELECT " +
                        "CASE " +
                        "WHEN population < 100000 THEN '<100k' " +
                        "WHEN population BETWEEN 100000 AND 999999 THEN '100k-1M' " +
                        "ELSE '>1M' END AS population_class, " +
                        "COUNT(*) AS city_count " +
                        "FROM city " +
                        "GROUP BY population_class " +
                        "ORDER BY city_count ASC";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<CityGroup> groups = new ArrayList<>();

        while (rs.next()) {
            String populationClass = rs.getString("population_class");
            int cityCount = rs.getInt("city_count");

            groups.add(new CityGroup(populationClass, cityCount));
        }


        rs.close();
        stmt.close();
        conn.close();

        return groups;
    }
}
