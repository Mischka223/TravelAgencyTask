package com.softserve.travelAgency.controllers.secutityController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/page")
    public String getLoginPage(){
        return "securityLoginPage/loginPage";
    }
    @GetMapping("/success")
    public String getSuccessPage(){
        return "securityLoginPage/success";
    }
}
