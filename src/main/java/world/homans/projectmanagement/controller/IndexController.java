package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("")
    public String index(Model model) {
        String username = "username";
        String password = "123345";
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "index";
    }
}
