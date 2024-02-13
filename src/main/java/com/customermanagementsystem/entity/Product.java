package com.customermanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Product {

    private Long id;

    private String name;

    private Double purchasePrice;

    private Double priceForCash;

    private Double priceForForwardSale;

    private Double priceForWithTransportation;

    private Double stockAmount;

    @ManyToOne
    private Dealer dealer;



}
