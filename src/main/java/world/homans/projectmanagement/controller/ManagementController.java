package world.homans.projectmanagement.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import world.homans.projectmanagement.entity.Project;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.service.ProjectService;
import world.homans.projectmanagement.service.UserService;

@Controller
public class ManagementController {

    final ProjectService projectService;
    final UserService userService;

    public ManagementController(UserService userService,ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    /**
     * 项目管理信息显示
     * @param uid 读取的用户端储存的 uid , 默认值 -1
     * @param model 与界面绑定的对象集合
     * @return 申请界面
     */
    @GetMapping("/management")
    public String management(@CookieValue(value = "uid", defaultValue = "-1") Long uid, Model model){
        User user = userService.getUser(uid);
        model.addAttribute("user",user);
        Project project = new Project();
        model.addAttribute("project",project);
        return "management";
    }

}
