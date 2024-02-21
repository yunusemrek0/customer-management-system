package com.customermanagementsystem.entity.dealer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    private Long id;

    @NotNull
    private String name;

    private Double purchasePrice;

    private Double priceForCash;

    private Double priceForForwardSale;

    private Double priceForWithTransportation;

    private Double stockAmount;

    @ManyToOne
    private Dealer dealer;



}
