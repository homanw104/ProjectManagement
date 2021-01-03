package world.homans.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.homans.projectmanagement.entity.Role;
import world.homans.projectmanagement.entity.User;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByName(String name);
    public ArrayList<User> findAll();
    public ArrayList<User> findAllByRole(Role role);
}
