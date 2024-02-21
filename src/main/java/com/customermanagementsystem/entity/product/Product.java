package com.customermanagementsystem.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double purchasePrice;

    private Double priceForCash;

    private Double priceForForwardSale;

    private Double priceForWithTransportation;

    private Double stockAmountAsLiter;

    @ManyToOne
    private Dealer dealer;



}
