package persistence;

import config.JpaConfig;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Vladimir on 09.07.2017.
 */
@Data
@Entity
@Table(name = "tb_transaction", schema = JpaConfig.SCHEMA)
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="trn_seq")
    @SequenceGenerator(
            initialValue = 1,
            name="trn_seq",
            sequenceName="trn_seq",
            allocationSize=20
    )
    @Column(name = "trn_id")
    private Integer trnId;

    @Column(name= "transaction_sum")
    BigDecimal transactionSum;

    @OneToOne
    @JoinColumn(name = "acc_id")
    AccountEntity accountEntity;

    //@OneToOne


}