package com.apinanyogaratnam.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class LanguagesController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("")
    public LinkedList<Languages> languages(@RequestParam(value = "name", defaultValue = "World") String name) {
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
