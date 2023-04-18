package com.cydeo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "merchats")
@Data
@NoArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String code;
    private BigDecimal transactionFee;
    private BigDecimal commissionRate;

    private Integer payoutDalyCount;

    @OneToMany (mappedBy = "merchant")// in one to many , ownership belongs to Many side
    private List<Payment> paymentList;

    public Merchant(String name, String code, BigDecimal transactionFee, BigDecimal commissionRate, Integer payoutDalyCount) {
        this.name = name;
        this.code = code;
        this.transactionFee = transactionFee;
        this.commissionRate = commissionRate;
        this.payoutDalyCount = payoutDalyCount;
    }
}
