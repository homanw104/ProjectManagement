package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import world.homans.projectmanagement.entity.Gender;
import world.homans.projectmanagement.entity.Profile;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.service.ProfileService;
import world.homans.projectmanagement.service.UserService;

import java.util.Date;

/**
 * 用户个人信息及表单提交控制
 */
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
     * @return 用户信息显示界面
     */
    @GetMapping("/profile")
    public String profile(@CookieValue(value = "uid", defaultValue = "-1") Long uid, Model model) {
        User user = userService.getUser(uid);
        if (user == null) return "redirect:/login";

        /* 获取用户信息对象，如不存在则新建并存储 */
        Profile profile = profileService.getProfile(uid);
        if (profile == null) {
            profile = new Profile(uid);
            profileService.saveProfile(profile);
        }

        model.addAttribute("user", user);
        model.addAttribute("profile", profile);
        return "profile";
    }

    /**
     * 修改个人信息
     * @param uid  读取用户端储存的 uid ，默认值 -1
     * @param model 与页面绑定的对象集合
     * @return 修改个人信息显示界面
     */
    @GetMapping("/profile/edit")
    public String profileEdit(@CookieValue(value = "uid", defaultValue = "-1") Long uid, Model model) {
        User user = userService.getUser(uid);
        if (user == null) return "redirect:/login";

        /* 获取用户信息对象，如不存在则新建 */
        Profile profile = profileService.getProfile(uid);
        if (profile == null) profile = new Profile();

        model.addAttribute("user", user);
        model.addAttribute("profile", profile);
        return "profile-edit";
    }

    /**
     * 个人信息修改表单提交
     * @param profile 与界面绑定的个人信息对象
     * @param gender 性别选择器的数据
     * @return 个人信息显示界面
     */
    @PostMapping("/profile/edit")
    public String profileUpdate(@ModelAttribute Profile profile,
                                @RequestParam("profile-gender") String gender) {
        Long uid = profile.getUid();

        /* 通过 gender 字符串设置用户性别 */
        switch (gender) {
            case "0": profile.setGender(Gender.FEMALE); break;
            case "1": profile.setGender(Gender.MALE); break;
            case "2": profile.setGender(Gender.UNKNOWN); break;
        }

        /* 设置并存储更改时间 */
        User user = userService.getUser(profile.getUid());
        user.setMtime(new Date());
        userService.updateUser(uid, user);

        /* 更新 profile 对象到数据库 */
        profileService.updateProfile(uid, profile);

        return "redirect:/profile?result=Success";
    }
}
