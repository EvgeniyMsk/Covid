package covid.controller;

import covid.entity.CovidInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CovidController {

    @GetMapping("/covid")
    public String greeting(@ModelAttribute("covidinfo") CovidInfo covidInfo, Principal principal, Model model) {
        model.addAttribute("otd", principal.getName().substring(3));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        model.addAttribute("date", dateFormat.format(new Date()));
        return "covid";
    }

    @GetMapping("/users")
    public String users() {
        return "users";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String auth() {
        return "login";
    }
}
