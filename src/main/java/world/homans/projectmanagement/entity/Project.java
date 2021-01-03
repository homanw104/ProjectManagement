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
     * Project ID
     */
    @Id
    @GeneratedValue
    private long pid = -1;

    /**
     * ACTIVATED, DEACTIVATED
     */
    @Column
    private Status status = Status.ACTIVATED;

    /**
     * DRAFT, INIT_REVIEWING, INIT_REVIEWED, MIDTERM_REVIEWING,
     * MIDTERM_REVIEWED, FINAL_REVIEWING, FINAL_REVIEWED, TERMINATED
     */
    @Column
    private Progress progress = Progress.DRAFT;

    /**
     * Project score
     */
    @Column
    private int score = -1;

    /**
     * Project name
     */
    @Column
    private String name = "N/A";

    /**
     * Project profile
     */
    @Column
    private String profile = "";

    /**
     * Tutor (e.g. "20180001")
     */
    @Column
    private String tutors = "";

    /**
     * Teammate (e.g. "10195555888,10185555999")
     */
    @Column
    private String teammates = "";

    /**
     * File url
     */
    @Column
    private String fileUrl = "";

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
