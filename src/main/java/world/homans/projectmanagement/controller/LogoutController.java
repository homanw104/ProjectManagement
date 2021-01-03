package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import world.homans.projectmanagement.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogoutController {

    final UserService userService;

    public LogoutController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 登出按钮
     *
     */
    @GetMapping("/logout")
    public String logout(@CookieValue(value = "uid", defaultValue = "-1") Long uid, HttpServletResponse response){
        Cookie cookie = new Cookie("uid", "-1");
        response.addCookie(cookie);
        return "redirect:";
    }

}
