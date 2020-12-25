package net.groundzeroit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @Autowired
    private JavaMailSender mailSender;

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

    @PostMapping("/contact")
    public String submitContactForm(HttpServletRequest request) {
        String subject = request.getParameter("subject");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String content = request.getParameter("message");

        SimpleMailMessage message = new SimpleMailMessage();
        // message.setFrom(email);
        message.setTo("pedjamilakovic1@gmail.com");
        message.setSubject(subject);

        String text = name.concat(" ".concat(surname).concat(" has sent you a message!\n\n"))
                + content.concat("\n\n") + "Name: " + name.concat(" ".concat(surname))
                + "\nEmail: ".concat(email);
        message.setText(text);

        SimpleMailMessage reply = new SimpleMailMessage();
        reply.setTo(email);
        reply.setSubject("Re: ".concat(subject));
        reply.setText("Hi, " + name +
                "!\n\nThis is a confirmation of your email and we will be contacting you shortly." +
                "\n\nKind regards, \nThe Ground Zero IT Team"
        );

        // To us
        mailSender.send(message);

        // To the person who contacted us
        mailSender.send(reply);

        return "redirect:/thanks";
    }

    @GetMapping("/impressum")
    public String impressum() {
        return "impressum";
    }

    @GetMapping("/thanks")
    public String thanks() {
        return "thanks";
    }
}
