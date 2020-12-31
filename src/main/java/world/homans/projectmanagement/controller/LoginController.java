package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.repository.UserRepository;

@Controller
public class LoginController {

    UserRepository userRepository;

    /**
     * 登陆界面显示
     * @param user 与该界面绑定的用户对象
     * @return 登陆界面
     */
    @RequestMapping("/login")
    public String login(@ModelAttribute User user) {
        user = new User();
        return "login";
    }

    // TODO 登录表单提交
}
