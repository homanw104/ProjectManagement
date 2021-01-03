package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.service.UserService;

@Controller
public class ApplicationController {

    final UserService userService;

    public ApplicationController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 申请界面显示
     * @param uid 读取的用户端储存的 uid ，默认值 -1
     * @param model 与界面绑定的对象集合
     * @return 申请界面
     */
    @GetMapping("/application")
    public String application(@CookieValue(value = "uid", defaultValue = "-1") Long uid, Model model) {
        User user = userService.getUser(uid);
        model.addAttribute("user", user);
        return "application";
    }
}
