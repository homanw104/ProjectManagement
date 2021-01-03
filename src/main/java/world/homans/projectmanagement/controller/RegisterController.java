package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import world.homans.projectmanagement.entity.Status;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class RegisterController {

    final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 注册界面显示
     * @param model 与该界面绑定的对象集合
     * @return 如 cookie 不存在或失效则显示登录界面，否则返回主页面
     */
    @GetMapping("/register")
    public String register(@CookieValue(value = "uid", defaultValue = "-1") Long uid, Model model) {
        User user = userService.getUser(uid);
        if (user == null) {
            model.addAttribute("user", new User());
            return "register";
        } else {
            return "redirect:";
        }
    }

    /**
     * 注册表单提交
     * @param user 与该界面绑定的用户对象
     * @param response 返回客户端的 http 对象
     * @return 系统主界面
     */
    @PostMapping("/register")
    public String register(@ModelAttribute User user, HttpServletResponse response) {
        // TODO 对提交内容进行校验

        /* 设置 mtime ctime 及默认值 */
        user.setStatus(Status.ACTIVATED);
        user.setCtime(new Date());
        user.setMtime(new Date());

        /* 储存 user 对象到数据库 */
        userService.saveUser(user);

        /* 储存 uid Cookie 到用户端 */
        Cookie cookie = new Cookie("uid", String.valueOf(user.getUid()));
        response.addCookie(cookie);
        return "redirect:";
    }
}
