package persistence;

import config.JpaConfig;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Vladimir on 09.07.2017
 */
@Data
@Entity
@Table(name = "tb_users", schema = JpaConfig.SCHEMA)
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
    @SequenceGenerator(
            name="user_seq",
            sequenceName="user_seq",
            allocationSize=20
    )
    @Column(name = "id")
    private Integer id;

    @Column(name="user_login", columnDefinition = "varchar2(200)")
    private String login;

    @Column(name="user_name", columnDefinition = "varchar2(200)")
    private String name;

    @ManyToOne
    //@OrderBy("id")
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;
}