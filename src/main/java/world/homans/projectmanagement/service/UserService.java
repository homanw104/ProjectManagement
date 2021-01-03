package world.homans.projectmanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import world.homans.projectmanagement.entity.User;
import world.homans.projectmanagement.repository.UserRepository;

import java.util.Optional;

/**
 * 用户表增删改查服务
 * author: Homan
 * since: 12/31/2020
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 添加用户
     * @param user 用户对象
     * @return 用户对象
     */
    @PostMapping()
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    /**
     * 通过uid删除用户
     * @param uid 用户uid
     */
    @DeleteMapping("/{uid}")
    public void deleteUser(@PathVariable("uid") Long uid) {
        userRepository.deleteById(uid);
    }

    /**
     * 修改用户信息
     * @param uid 用户uid
     * @param user 用户对象
     * @return 用户对象
     */
    @PutMapping("/{uid}")
    public User updateUser(@PathVariable("uid") Long uid, @RequestBody User user) {
        user.setUid(uid);
        return userRepository.saveAndFlush(user);
    }

    /**
     * 获取特定用户信息
     * @param uid 用户uid
     * @return 用户对象 如果用户不存在，返回null
     */
    @GetMapping("/{uid}")
    public User getUser(@PathVariable("uid") Long uid) {
        Optional<User> optional = userRepository.findById(uid);
        return optional.orElse(null);
    }

    /**
     * 获取用户列表
     * @param pageNum 页号
     * @param pageSize 单页条目数
     * @return Page对象
     */
    @GetMapping("/list")
    public Page<User> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return userRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }
}
