package com.apinanyogaratnam.restservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class GetDataFromSQL {

    public LinkedList<Languages> readDB(String tableName, String[] columnLabels, Secrets credentials) {
        LinkedList<Languages> databaseData = new LinkedList<>();

        try {
            // get a connection to database
            Connection connection = DriverManager.getConnection(credentials.getUrl(), credentials.getUsername(), credentials.getPassword());

            // create a statement
            Statement statement = connection.createStatement();

            // insert data into database
            String query = String.format("SELECT * FROM %s", tableName);
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int year = result.getInt("year");

                databaseData.add(new Languages(id, name, year));
            }

            // close connection to server
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseData;
    }
}
