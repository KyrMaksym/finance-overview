package persistence;

import config.JpaConfig;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vladimir on 09.07.2017*/
@Data
@Entity
@Table(name = "tb_role", schema = JpaConfig.SCHEMA)
public class RoleEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="role_seq")
    @SequenceGenerator(
            initialValue = 1,
            name="role_seq",
            sequenceName="role_seq",
            allocationSize=20
    )
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "roleEntity")
    private List<UserEntity> userEntityList;

}
