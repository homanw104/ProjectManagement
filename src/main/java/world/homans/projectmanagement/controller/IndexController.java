package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.service.UserService;

/**
 * 主页跳转控制
 */
@Controller
public class IndexController {

    final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 主界面显示
     * @param uid 读取的用户端储存的 uid ，默认值 -1
     * @param model 与界面绑定的对象集合
     * @return 如 cookie 不存在或失效则重定向至 login ，否则根据 user.getRole() 返回对应主页面
     */
    @GetMapping("")
    public String index(@CookieValue(value = "uid", defaultValue = "-1") Long uid, Model model) {
        User user = userService.getUser(uid);
        if (user == null) return "redirect:/login";

        model.addAttribute("user", user);
        switch (user.getRole()) {
            case ADMIN: return "index/index-admin";
            case STUDENT: return "index/index-student";
            case TUTOR: return "index/index-tutor";
            case ASSESSOR: return "index/index-assessor";
            default: return "redirect:/login";
        }
    }
}
