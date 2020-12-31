package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String hello(Model model) {
        model.addAttribute("name", "Homan");
        return "login";     // Refer to `src/main/resources/templates/login.html`
    }
}
