package world.homans.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.homans.projectmanagement.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    public Profile findById(long uid);
}
