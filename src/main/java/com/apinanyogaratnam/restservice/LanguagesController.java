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

    @GetMapping("")
    public LinkedList<Languages> languages(String name) {
        GetDataFromSQL data = new GetDataFromSQL();

        String tableName = "languages";
        String[] columnLabels = {"id", "name", "year"};

        return data.readDB(tableName, columnLabels, credentials);
    }
}
