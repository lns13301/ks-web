package com.gyuhan.app.controller;

import com.gyuhan.app.entity.*;
import com.gyuhan.app.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private final PersonRepository personRepository;
    private final SocialMediaRepository socialMediaRepository;
    private final InterestsRepository interestsRepository;
    private final SkillRepository skillRepository;
    private final WorkRepository workRepository;

    public IndexController(PersonRepository personRepository, SocialMediaRepository socialMediaRepository, InterestsRepository interestsRepository, SkillRepository skillRepository, WorkRepository workRepository) {
        this.personRepository = personRepository;
        this.socialMediaRepository = socialMediaRepository;
        this.interestsRepository = interestsRepository;
        this.skillRepository = skillRepository;
        this.workRepository = workRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        Person person = personRepository.findAll().stream().findFirst().orElse(null);
        SocialMedia socialMedia = socialMediaRepository.findAll().stream().findFirst().orElse(null);
        Interests interests = interestsRepository.findAll().stream().findFirst().orElse(null);
        List<Skill> skills = skillRepository.findAll();
        List<Work> works = workRepository.findAll();

        model.addAttribute("person", person);
        model.addAttribute("socialMedia", socialMedia);
        model.addAttribute("interests", interests);
        model.addAttribute("skills", skills);
        model.addAttribute("works", works);

        return "resume";
    }
}
