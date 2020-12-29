package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;
}
