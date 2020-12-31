package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import world.homans.projectmanagement.repository.UserRepository;

@Controller
public class LoginController {

    UserRepository userRepository;

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
}
