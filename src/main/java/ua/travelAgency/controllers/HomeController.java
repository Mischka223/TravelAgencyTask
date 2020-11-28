package ua.travelAgency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(Model model){

        String hello_world = "hello world";
        model.addAttribute("hello", hello_world);
        return "home/homePage";
    }
}
