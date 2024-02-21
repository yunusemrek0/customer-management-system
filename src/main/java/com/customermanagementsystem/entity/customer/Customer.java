package com.customermanagementsystem.entity.customer;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer {


    private Long id;

    private String name;

    private String mobilePhone;

    private String address;

    private String description;

    private String ssn;

    private String taxOffice;

    private String taxNo;

    private Double balance;

    @OneToMany(mappedBy = "customer")
    private CashProceed cashProceed;
}
