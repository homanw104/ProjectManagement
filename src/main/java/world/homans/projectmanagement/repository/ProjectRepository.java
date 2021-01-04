package world.homans.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.homans.projectmanagement.entity.Project;

import java.util.ArrayList;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    public ArrayList<Project> findAll();
    public ArrayList<Project> findAllByTeammatesContains(String uid);
    public ArrayList<Project> findAllByTutorsContains(String uid);
}
