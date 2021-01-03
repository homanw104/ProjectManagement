package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {

    final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 登陆界面显示
     * @param model 与该界面绑定的用户对象
     * @return 登陆界面
     */
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // TODO 登录表单提交
    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpServletResponse response) {
        // TODO 对提交内容进行校验

        /* 从数据库提取用户uid */
        userService.getUser(user.getUid());

        /* 储存uid Cookie 到用户端 */
        Cookie cookie = new Cookie("uid", String.valueOf(user.getUid()));
        response.addCookie(cookie);
        return "redirect:";
    }
}
