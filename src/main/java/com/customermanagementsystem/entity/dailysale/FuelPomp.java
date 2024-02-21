package com.customermanagementsystem.entity.dailysale;

import com.customermanagementsystem.entity.dealer.Product;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class FuelPomp {

    private Long id;

    private String name;

    private Double oldNumerator;

    private Double newNumerator;

    private LocalDateTime updateDateTime;

    @ManyToOne
    private Product product;

    private Boolean isTransferred;
}
