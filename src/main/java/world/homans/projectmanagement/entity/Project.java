package world.homans.projectmanagement.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.*;
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
    private long pid = -1;

    /**
     * ACTIVATED, DEACTIVATED
     */
    @Column
    private Status status = Status.ACTIVATED;

    /**
     * Project name
     */
    @Column
    private String name = "N/A";

    /**
     * Project Profile
     */
    @Column
    private String profile = "N/A";

    /**
     * Project Status（In progress/reviewed/approved）
     */
    @Column
    private String state = "progress";

    /**
     * Project point（？如何把数据类型改成数字）
     */
    @Id
    private String point = "-1";

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

    /**
     * fileurl
     */
    @Column
    private String fileurl = "N/A";
}
