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


    public LinkedList<String[]> readDB(String tableName, String[] columnLabels, Secrets credentials) {
        LinkedList<String[]> databaseData = new LinkedList<>();

        try {
            // get a connection to database
            Connection connection = DriverManager.getConnection(credentials.getUrl(), credentials.getUsername(), credentials.getPassword());

            // create a statement
            Statement statement = connection.createStatement();

            // insert data into database
            String query = String.format("SELECT * FROM %s", tableName);
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                String[] rowContents = new String[columnLabels.length];

                for (int i=0; i<columnLabels.length; i++) {
                    rowContents[i] = result.getString(columnLabels[i]);
                }

                databaseData.add(rowContents);
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
        LinkedList<Languages> languages = new LinkedList<>();
        languages.add(new Languages(counter.incrementAndGet(), "Java", 1995));
        languages.add(new Languages(counter.incrementAndGet(), "C", 1972));
        languages.add(new Languages(counter.incrementAndGet(), "C++", 1985));
        languages.add(new Languages(counter.incrementAndGet(), "Ruby", 1995));
        languages.add(new Languages(counter.incrementAndGet(), "Python", 1989));
        languages.add(new Languages(counter.incrementAndGet(), "JavaScript", 1995));
        languages.add(new Languages(counter.incrementAndGet(), "HTML", 1993));
        languages.add(new Languages(counter.incrementAndGet(), "CSS", 1996));
        languages.add(new Languages(counter.incrementAndGet(), "GO", 2009));
        return languages;
    }
}
