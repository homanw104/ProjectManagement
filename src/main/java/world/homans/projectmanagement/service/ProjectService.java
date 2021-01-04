package world.homans.projectmanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import world.homans.projectmanagement.entity.Project;
import world.homans.projectmanagement.repository.ProjectRepository;

import java.util.Optional;

/**
 * 项目表增删改查服务
 * author: Temper
 * since: 01/03/2021
 */
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * 添加项目
     * @param project 项目对象
     */
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    /**
     * 通过 pid 删除项目
     * @param pid 项目 pid
     */
    public void updateProject(Long pid) {
        projectRepository.deleteById(pid);
    }

    /**
     * 修改项目信息
     * @param pid 被更新的项目 pid
     * @param project 新的项目对象
     */
    public void updateProject(Long pid, Project project) {
        project.setPid(pid);
        projectRepository.saveAndFlush(project);
    }

    /**
     * 获取特定项目信息
     * @param pid 项目 pid
     * @return 如果项目不存在，返回 null，否则返回项目对象
     */
    public Project getProject(Long pid) {
        Optional<Project> optional = projectRepository.findById(pid);
        return optional.orElse(null);
    }

    /**
     * 获取项目列表
     * @param pageNum 页号
     * @param pageSize 单页条目数
     * @return Page对象
     */
    public Page<Project> pageQuery(int pageNum, int pageSize){
        return projectRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }
}
