package com.system.digitalWallet.entity;

import javax.persistence.*;

@Entity
@Table(name="wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "amount", nullable = false)
    private Long amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Wallet(String name, Long amount) {
        this.name = name;
        this.amount = amount;
    }

    public Wallet() {
    }
}
