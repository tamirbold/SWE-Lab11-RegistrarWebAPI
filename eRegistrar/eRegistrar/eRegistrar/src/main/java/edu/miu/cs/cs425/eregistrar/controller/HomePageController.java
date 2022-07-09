package edu.miu.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping(value = { "/", "/eregistrar", "/eregistrar/home" })
    public String displayHomePage() {
        return "home/index";
    }

    @GetMapping(value = { "/eregistrar/about" })
    public String displayAboutPage() {
        return "home/about";
    }
}
