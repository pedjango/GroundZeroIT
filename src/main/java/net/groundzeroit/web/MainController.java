package net.groundzeroit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/services")
    public String services() {
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    /*
    @PostMapping("/contact/sendEmail")
    public String sendEmail() {
        EmailServiceImpl esi = new EmailServiceImpl();
        esi.sendMessage();
        return "redirect:/";
    }
    */

    @GetMapping("/impressum")
    public String impressum() {
        return "impressum";
    }
}
