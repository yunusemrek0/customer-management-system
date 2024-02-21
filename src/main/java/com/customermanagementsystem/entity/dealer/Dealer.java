package com.customermanagementsystem.entity.dealer;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Dealer {

    private Long id;

    private String name;

    private Double balance;

    @OneToMany(mappedBy = "dealer")
    private List<Product> products;
}
