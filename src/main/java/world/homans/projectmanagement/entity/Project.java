package world.homans.projectmanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "project")

public class Project implements Serializable {

    /**
     * 项目编号 Project ID (自动生成)
     */
    @Id
    @GeneratedValue
    private long pid = -1;

    /**
     * 项目状态 DEACTIVATED=0, ACTIVATED=1
     */
    @Column
    private Status status = Status.ACTIVATED;

    /**
     * 项目进度 DRAFT=0, INIT_REVIEWING=1, INIT_REVIEWED=2, MIDTERM_REVIEWING=3,
     * MIDTERM_REVIEWED=4, FINAL_REVIEWING=5, FINAL_REVIEWED=6, TERMINATED=7
     */
    @Column
    private Progress progress = Progress.DRAFT;

    /**
     * 项目评分 Project Score
     */
    @Column
    private int score = -1;

    /**
     * 项目名字 Project Name
     */
    @Column
    private String name = "N/A";

    /**
     * 项目简介 Project Profile
     */
    @Column
    private String profile = "";

    /**
     * 导师列表 Tutors (e.g. "20180001")
     */
    @Column
    private String tutors = "";

    /**
     * 组员列表 Teammates (e.g. "10195555888,10185555999")
     */
    @Column
    private String teammates = "";

    /**
     * 文件存储位置 File URL
     */
    @Column
    private String fileUrl = "";

    /**
     * Tutor's comment
     */
    @Column
    private String comment = "";

    /**
     * Creation time
     */
    @Column
    private Date ctime = new Date();

    /**
     * Modification time
     */
    @Column
    private Date mtime = new Date();
}
