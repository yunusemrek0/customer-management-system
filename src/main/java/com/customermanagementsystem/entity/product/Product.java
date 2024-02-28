package com.customermanagementsystem.entity.product;

import com.customermanagementsystem.entity.dailysale.fuelpomp.FuelPompStatistic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "product")
    private List<FuelPompStatistic> fuelPompStatistics;


}
