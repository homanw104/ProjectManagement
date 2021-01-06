package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import world.homans.projectmanagement.entity.Project;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.service.ProjectService;
import world.homans.projectmanagement.service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class ApplicationController {

    final UserService userService;
    final ProjectService projectService;

    public ApplicationController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
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
        if (user == null) return "redirect:/login";

        Project project = new Project();
        ArrayList<User> students = userService.listStudents();
        ArrayList<User> tutors = userService.listTutors();
        model.addAttribute("user", user);
        model.addAttribute("project", project);
        model.addAttribute("students", students);
        model.addAttribute("tutors", tutors);
        return "application";
    }

    /**
     * 申请表单提交
     * @param file 上传的文件
     * @param project 与界面绑定的项目对象
     * @return 如成功返回管理界面，否则返回申请界面
     */
    @PostMapping("/application")
    public String application(@RequestParam("file") MultipartFile file,
                              @ModelAttribute Project project) {
        if (file.isEmpty()) {
            return "application";
        } else try {
            /* 生成文件路径 */
            String osName = System.getProperty("os.name");
            String filePath;
            if (osName.startsWith("Windows")) {
                filePath = "D:/Cache/Project/";
            } else {
                filePath = "/home/cache/";
            }
            File fileDir = new File(filePath);
            if (!fileDir.exists())
                if (!fileDir.mkdirs())
                    return "redirect:/application?result=FailedToCreateDir";

            /* 保存文件 */
            File destFile = new File(filePath + file.getOriginalFilename());
            file.transferTo(destFile);

            /* 保存文件路径并保存项目信息 */
            project.setFileUrl(destFile.getAbsolutePath());
            projectService.saveProject(project);
            return "redirect:/management?result=Success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/application?result=Failed";
    }
}
