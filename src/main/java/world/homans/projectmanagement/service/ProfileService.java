package world.homans.projectmanagement.service;

import org.springframework.stereotype.Service;
import world.homans.projectmanagement.entity.Profile;
import world.homans.projectmanagement.repository.ProfileRepository;

import java.util.Optional;

/**
 * 用户个人信息增删改查服务
 * author：Temper, Homan
 * since：01/03/2021
 */
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    /**
     * 添加用户个人信息
     * @param profile 用户个人信息对象
     */
    public void saveProfile(Profile profile) {
        profileRepository.save(profile);
    }

    /**
     * 通过 uid 删除用户个人信息
     * @param uid 用户 uid
     */
    public void deleteProfile(Long uid) {
        profileRepository.deleteById(uid);
    }

    /**
     * 修改用户个人信息
     * @param uid 被更新的用户 uid
     * @param profile 新的用户个人信息对象
     */
    public void updateProfile(Long uid, Profile profile) {
        profile.setUid(uid);
        profileRepository.saveAndFlush(profile);
    }
    /**
     * 获取特定用户信息
     * @param uid 用户 uid
     * @return 如果项目不存在，返回 null, 否则返回项目列表
     */
    public Profile getProfile(Long uid) {
        Optional<Profile> optional = profileRepository.findById(uid);
        return optional.orElse(null);
    }
}
