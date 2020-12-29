package world.homans.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.homans.projectmanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByName(String name);
}
