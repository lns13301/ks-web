package com.gyuhan.app.controller;

import com.gyuhan.app.entity.Interests;
import com.gyuhan.app.entity.Person;
import com.gyuhan.app.entity.SocialMedia;
import com.gyuhan.app.repository.InterestsRepository;
import com.gyuhan.app.repository.PersonRepository;
import com.gyuhan.app.repository.SocialMediaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final PersonRepository personRepository;
    private final SocialMediaRepository socialMediaRepository;
    private final InterestsRepository interestsRepository;

    public IndexController(PersonRepository personRepository, SocialMediaRepository socialMediaRepository, InterestsRepository interestsRepository) {
        this.personRepository = personRepository;
        this.socialMediaRepository = socialMediaRepository;
        this.interestsRepository = interestsRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        Person person = personRepository.findAll().stream().findFirst().orElse(null);
        SocialMedia socialMedia = socialMediaRepository.findAll().stream().findFirst().orElse(null);
        Interests interests = interestsRepository.findAll().stream().findFirst().orElse(null);

        model.addAttribute("person", person);
        model.addAttribute("socialMedial", socialMedia);
        model.addAttribute("interests", interests);

        return "resume";
    }
}
