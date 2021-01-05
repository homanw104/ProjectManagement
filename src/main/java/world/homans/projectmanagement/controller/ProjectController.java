package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import world.homans.projectmanagement.entity.Progress;
import world.homans.projectmanagement.entity.Project;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.service.ProjectService;
import world.homans.projectmanagement.service.UserService;

import java.io.File;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@Controller
public class ProjectController {

    final UserService userService;
    final ProjectService projectService;

    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    /**
     * 修改界面显示
     * @param uid 读取的用户端储存的 uid ，默认值 -1
     * @param pid 要修改的项目 pid
     * @param model 与界面绑定的对象集合
     * @return 如找到 project 返回修改界面，否则返回管理界面
     */
    @GetMapping("/project/{pid}")
    public String editProject(@CookieValue(value = "uid", defaultValue = "-1") Long uid,
                              @PathVariable(value = "pid") Long pid, Model model) {
        User user = userService.getUser(uid);
        if (user == null) return "redirect:/login";

        Project project = projectService.getProject(pid);
        if (project == null) return "redirect:/management?result=ProjectNotFound";

        model.addAttribute("user", user);
        model.addAttribute("project", project);
        return "project-edit";
    }

    /**
     * 修改表单提交
     * @param file 上传的文件
     * @param pid 要修改的项目 pid
     * @param project 与界面绑定的项目对象
     * @return 如成功返回管理界面，否则返回修改界面
     */
    @PostMapping("/project/{pid}")
    public String updateProject(@RequestParam("file") MultipartFile file,
                                @PathVariable("pid") Long pid,
                                @ModelAttribute Project project) {
        if (projectService.getProject(pid) == null)
            return "redirect:/management?result=ProjectNotFound";

        if (file.isEmpty()) {
            return "redirect:/project/" + pid.toString() + "?result=EmptyFile";
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
                    return "redirect:/project/" + pid.toString() + "?result=FailedToCreateDir";

            /* 保存文件 */
            File destFile = new File(filePath + file.getOriginalFilename());
            file.transferTo(destFile);

            /* 保存文件路径并保存项目信息 */
            project.setFileUrl(destFile.getAbsolutePath());
            Project baseProject = projectService.getProject(pid);
            baseProject.setName(project.getName());
            baseProject.setProfile(project.getProfile());
            projectService.saveProject(baseProject);
            return "redirect:/management?result=UpdateSuccess";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/management?result=Failed";
    }

    /**
     * 评论表单提交
     * @param pid 项目编号 pid
     * @return 管理界面
     */
    @PostMapping("/comment/{pid}")
    public String commentProject(@PathVariable(value = "pid") Long pid,
                                 @RequestParam(value = "project-comment") String comment) {
        if (projectService.getProject(pid) == null)
            return "redirect:/management?result=ProjectNotFound";

        Project baseProject = projectService.getProject(pid);
        baseProject.setComment(comment);
        projectService.updateProject(pid, baseProject);
        return "redirect:/management?result=CommentSuccess";
    }

    /**
     * 评分表单提交
     * @param pid 项目编号 pid
     * @return 管理界面
     */
    @PostMapping("/evaluate/{pid}")
    public String evaluateProject(@PathVariable(value = "pid") Long pid,
                                  @RequestParam(value = "project-score") String score) {
        if (projectService.getProject(pid) == null)
            return "redirect:/management?result=ProjectNotFound";

        Project baseProject = projectService.getProject(pid);
        try {
            int newScore = Integer.parseInt(score);
            baseProject.setScore(newScore);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "redirect:/management?result=ScoreNonNumeric";
        }
        projectService.updateProject(pid, baseProject);
        return "redirect:/management?result=EvaluateSuccess";
    }

    /**
     * 审批进入下一阶段
     * @param pid 项目 pid
     * @return 管理界面
     */
    @GetMapping("/approve/{pid}")
    public String approveProject(@PathVariable(value = "pid") Long pid) {
        Project project = projectService.getProject(pid);
        if (project == null) return "redirect:/management?result=ProjectNotFound";

        switch (project.getProgress()) {
            case DRAFT: case INIT_REVIEWING: project.setProgress(Progress.INIT_REVIEWED); break;
            case INIT_REVIEWED: case MIDTERM_REVIEWING: project.setProgress(Progress.MIDTERM_REVIEWED); break;
            case MIDTERM_REVIEWED: case FINAL_REVIEWING: project.setProgress(Progress.FINAL_REVIEWED); break;
            case TERMINATED: project.setProgress(Progress.DRAFT); break;
        }
        projectService.updateProject(project.getPid(), project);
        return "redirect:/management?result=ApproveSuccess";
    }

    /**
     * 拒绝项目
     * @param pid 项目 pid
     * @return 管理界面
     */
    @GetMapping("/reject/{pid}")
    public String rejectProject(@PathVariable(value = "pid") Long pid) {
        Project project = projectService.getProject(pid);
        if (project == null) return "redirect:/management?result=ProjectNotFound";

        project.setProgress(Progress.TERMINATED);
        projectService.updateProject(pid, project);
        return "redirect:/management?result=ProjectRejected";
    }

    /**
     * 删除项目
     * @param pid 项目 pid
     * @return 管理界面
     */
    @GetMapping("/delete/{pid}")
    public String deleteProject(@PathVariable(value = "pid") Long pid) {
        if (projectService.getProject(pid) == null)
            return "redirect:/management?result=ProjectNotFound";
        projectService.deleteProject(pid);
        return "redirect:/management?result=DeleteSuccess";
    }
}
