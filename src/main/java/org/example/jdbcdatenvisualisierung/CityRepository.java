package org.example.jdbcdatenvisualisierung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CityRepository {

    public List<city_class> getAllCities() throws Exception {

        Connection conn = Database.connect();

        String sql = "SELECT name, population, countrycode FROM city ORDER BY population ASC";





        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<city_class> cities = new ArrayList<>();

        while (rs.next()) {
            String name = rs.getString("name");
            int population = rs.getInt("population");
            String country = rs.getString("countrycode");

            cities.add(new city_class(name, population, country));
        }

        rs.close();
        stmt.close();
        conn.close();

        return cities;
    }
}
