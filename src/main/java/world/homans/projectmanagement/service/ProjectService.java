package world.homans.projectmanagement.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import world.homans.projectmanagement.entity.Project;
import world.homans.projectmanagement.repository.ProjectRepository;

import java.security.PrivateKey;
import java.util.Optional;

/**
 * 项目表增删改查服务
 * author: Temper
 * since: 01.03.2021
 */
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {this.projectRepository = projectRepository; }

    /**
     * @param project 项目对象
     * @return 项目对象
     */
    @PostMapping()
    public Project saveProject(@RequestBody Project project) { return projectRepository.save(project); }

    /**
     * 通过pid删除用户
     * @param pid 项目pid
     */
    @DeleteMapping("/{pid}")
    public Project updateProject(@PathVariable("pid") Long pid, @RequestBody Project project){
        project.setPid(pid);
        return projectRepository.saveAndFlush(project);
    }

    /**
     * 获取特定项目信息
     * @param pid 项目pid
     * @return 项目对象 如果项目不存在，返回null
     */
    @GetMapping("/{pid}")
    public Project getProject(@PathVariable("pid") Long pid) {
        Optional<Project> optional = projectRepository.findById(pid);
        return optional.orElse(null);
    }

    /**
     * 获取项目列表
     * @param pageNum 页号
     * @param pageSize 单页条目数
     * @return Page对象
     */
    @GetMapping("/list")
    public Page<Project> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        return projectRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }


}
