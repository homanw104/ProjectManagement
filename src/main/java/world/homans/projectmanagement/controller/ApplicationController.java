package world.homans.projectmanagement.controller;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import world.homans.projectmanagement.entity.Project;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

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

    /*
    @PostMapping("/application")
    @ResponseBody
    public String application(@RequestParam("file") MultipartFile file,
                              @ModelAttribute Project project,
                              HttpServletRequest request, Model model) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = "/temp";
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + "/" + fileName);
        out.write(file);
        out.flush();
        out.close();
        return "redirect:/management";
    }
    */
}
