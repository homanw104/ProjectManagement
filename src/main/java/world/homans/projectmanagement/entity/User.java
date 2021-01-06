package world.homans.projectmanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

    /**
     * 用户 User ID
     */
    @Id
    private long uid = -1;

    /**
     * 账户激活状态 DEACTIVATED=0, ACTIVATED=1
     */
    @Column
    private Status status = Status.ACTIVATED;

    /**
     * 用户角色 ADMIN=0, STUDENT=1, TUTOR=2, ASSESSOR=3
     */
    @Column
    private Role role = Role.STUDENT;

    /**
     * 用户姓名 User name
     */
    @Column
    private String name = "N/A";

    /**
     * 密码 Password
     */
    @Column
    private String password = "N/A";

    /**
     * 创建时间 Date of Creation
     */
    @Column
    private Date ctime = new Date();

    /**
     * 修改时间 Date of Modification
     */
    @Column
    private Date mtime = new Date();

    /**
     * 获得创建日期
     * @return 创建日期字符串
     */
    public String getCreationTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy 年 M 月");
        return format.format(ctime);
    }

    /**
     * 获得修改日期
     * @return 修改日期字符串
     */
    public String getModificationTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy 年 M 月");
        return format.format(mtime);
    }
}
