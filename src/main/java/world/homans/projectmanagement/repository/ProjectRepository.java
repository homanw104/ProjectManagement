package world.homans.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.homans.projectmanagement.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    public Project findByName(String name);
}
