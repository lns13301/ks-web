package com.gyuhan.app.controller;

import com.gyuhan.app.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final PersonRepository personRepository;

    public IndexController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public String index() {
        return "resume";
    }
}
