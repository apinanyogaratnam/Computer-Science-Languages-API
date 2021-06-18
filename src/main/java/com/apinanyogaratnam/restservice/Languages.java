package com.apinanyogaratnam.restservice;

import java.util.concurrent.atomic.AtomicLong;

public class Languages {

    private String name;
    private int year;
    private final long id;

    public Languages(long id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
