package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import world.homans.projectmanagement.entity.Profile;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.service.ProfileService;
import world.homans.projectmanagement.service.UserService;

@Controller
public class ProfileController {

    final ProfileService profileService;
    final UserService userService;

    public ProfileController(ProfileService profileService,UserService userService){
        this.profileService = profileService;
        this.userService = userService;
    }

    /**
     * 显示用户信息
     * @param uid  读取用户端储存的 uid ，默认值 -1
     * @param model 与页面绑定的对象集合
     * @return 申请界面
     */
    @GetMapping("/profile")
    public String profile(@CookieValue(value = "uid", defaultValue = "-1") Long uid, Model model){
        User user = userService.getUser(uid);
        if (user == null) return "redirect:/login";

        Profile profile = profileService.getProfile(uid);
        model.addAttribute("user", user);
        model.addAttribute("profile", profile);
        return "profile";
    }
}
