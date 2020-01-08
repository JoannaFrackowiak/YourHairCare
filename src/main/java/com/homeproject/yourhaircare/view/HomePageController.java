package com.homeproject.yourhaircare.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/home-page")
    public String goToHomepage() {
        return "home-page";
    }

    @GetMapping("/thanks")
    public String goToThanks() {
        return "thanks";
    }

}
