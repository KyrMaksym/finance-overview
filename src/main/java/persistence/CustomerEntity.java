package persistence;

import config.JpaConfig;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vladimir on 13.07.2017.
 */
@Data
@Entity
@Table(name = "tb_customer", schema = JpaConfig.SCHEMA)
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="customer_seq")
    @SequenceGenerator(
            name="customer_seq",
            sequenceName="customer_seq",
            allocationSize=20
    )
    @Column(name = "id")
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @OneToMany(mappedBy = "customerEntity")
    List<AccountEntity> accountEntityList;
}
