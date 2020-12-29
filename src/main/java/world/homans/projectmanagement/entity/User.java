package world.homans.projectmanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements Serializable {

    /**
     * User ID
     */
    @Id
    @GeneratedValue
    private long uid = -1;

    /**
     * 0 - Not activated, 1 - Activated
     */
    @Column
    private int status = 1;

    /**
     * 0 - Admin, 1 - Student, 2 - Tutor, 3 - Assessor
     */
    @Column
    private int role = 1;

    /**
     * User name
     */
    @Column
    private String name = "N/A";

    /**
     * Encrypted password
     */
    @Column
    private String password = "N/A";

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
