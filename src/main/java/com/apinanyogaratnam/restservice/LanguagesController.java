package com.apinanyogaratnam.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class LanguagesController {

    private final AtomicLong counter = new AtomicLong();

    Secrets credentials = new Secrets("apinan", "admin", "jdbc:postgresql://localhost/apinanyogaratnam");


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

    @GetMapping("")
    public LinkedList<Languages> languages(String name) {

        String tableName = "languages";
        String[] columnLabels = {"id", "name", "year"};
        return readDB(tableName, columnLabels, credentials);
    }
}
