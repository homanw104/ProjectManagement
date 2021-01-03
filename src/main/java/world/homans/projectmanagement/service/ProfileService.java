package world.homans.projectmanagement.service;


import org.springframework.stereotype.Service;
import world.homans.projectmanagement.entity.Profile;
import world.homans.projectmanagement.repository.ProfileRepository;
import world.homans.projectmanagement.repository.UserRepository;


/**
 * 用户个人信息增删改查服务
 * author：Temper
 * since：01/03/2021
 */
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    /**
     *
     */
}
