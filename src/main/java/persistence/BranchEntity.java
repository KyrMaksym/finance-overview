package persistence;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Vladimir on 09.07.2017.
 */
@Data
@Entity
@Table(name = "tb_branch")
public class BranchEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="branch_seq")
    @SequenceGenerator(
            initialValue = 1,
            name="branch_seq",
            sequenceName="branch_seq",
            allocationSize=20
    )
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    String name;
}
