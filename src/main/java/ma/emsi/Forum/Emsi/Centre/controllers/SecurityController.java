package ma.emsi.Forum.Emsi.Centre.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/login")
    public String showLogin() {return "login";}
}
