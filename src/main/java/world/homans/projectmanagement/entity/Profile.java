package world.homans.projectmanagement.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "profile")
public class Profile implements Serializable {

    /**
     * 用户 User ID
     */
    @Id
    private long uid = -1;

    /**
     * 用户性别 FEMALE=0, MALE=1, UNKNOWN=2
     */
    @Column
    private Gender gender = Gender.UNKNOWN;

    /**
     * 用户年级 User Grade (e.g. "2019级")
     */
    @Column
    private String year = "N/A";

    /**
     * 所属院校 User School (e.g. "软件工程学院")
     */
    @Column
    private String school = "N/A";

    /**
     * 用户专业 User Major (e.g. "软件工程专业")
     */
    @Column
    private String major = "N/A";

    /**
     * 用户职称 User Position (e.g. "副教授")
     */
    @Column
    private String position = "N/A";

    /**
     * 手机号码 Mobile Number
     */
    @Column
    private String mobile = "N/A";

    /**
     * 电子邮箱 User Email
     */
    @Column
    private String email = "N/A";

    /**
     * 只有 uid 的构建方法，用于第一次查看用户信息
     */
    public Profile(Long uid) {
        this.uid = uid;
    }

    /**
     * 无参数构建方法
     */
    public Profile() {}
}
