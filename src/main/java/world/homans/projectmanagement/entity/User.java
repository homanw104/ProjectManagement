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
     * ACTIVATED, DEACTIVATED
     */
    @Column
    private Status status = Status.ACTIVATED;

    /**
     * ADMIN, STUDENT, TUTOR, ASSESSOR
     */
    @Column
    private Role role = Role.STUDENT;

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
