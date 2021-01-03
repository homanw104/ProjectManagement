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
     * User ID
     */
    @Id
    private long uid = -1;

    /**
     * User Gender
     */
    @Column
    private Gender gender = Gender.MALE;

    /**
     * User Grade
     */
    @Column
    private String year = "N/A";

    /**
     * User School
     */
    @Column
    private String school = "N/A";

    /**
     * User Major
     */
    @Column
    private String major = "N/A";

    /**
     * User Position
     */
    @Column
    private String position = "N/A";

    /**
     * User mobile
     */
    @Column
    private String mobile = "N/A";

    /**
     * User Email
     */
    @Column
    private String email = "N/A";

}
