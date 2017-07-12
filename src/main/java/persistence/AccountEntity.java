package persistence;


import lombok.Data;

import javax.persistence.*;

/**
 * Created by Vladimir on 09.07.2017.
 */
@Data
@Entity
@Table(name = "tb_account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="accout_seq")
    @SequenceGenerator(
            initialValue = 100,
            name="accout_seq",
            sequenceName="accout_seq",
            allocationSize=20
    )
    @Column(name = "acc_id")
    private Integer accId;

    @Column(name = "fin_account")
    private String finAccount;

    @Column(name = "account_class")
    private String accountClass;

    @Column(name = "ccy")
    private String ccy;

    //user_id

    //branch_id
    @OneToOne
    @JoinColumn(name="branch_id")
    BranchEntity branchEntity;

}
