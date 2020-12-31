package world.homans.projectmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import world.homans.projectmanagement.entity.Role;
import world.homans.projectmanagement.entity.Status;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.repository.UserRepository;

import java.util.Date;

@Controller
public class RegisterController {

    private final UserRepository userRepository;

    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/register")
    public String register(Model model) {
        User newUser = new User(
                10195101563L,
                Status.ACTIVATED,
                Role.STUDENT,
                "林颂家",
                "lsjlsj",
                new Date(),
                new Date()
        );
        userRepository.save(newUser);
        return "register";
    }
}
