package com.customermanagementsystem.entity.customer;

import com.customermanagementsystem.entity.dealer.Product;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class ForwardSale {

    private Long id;

    private LocalDateTime dateTime;

    @ManyToOne
    private Product product;

    private Double unitPrice;

    private Double amount;

    private Double total;

    @ManyToOne
    private Customer customer;

    private Boolean isTransferred;
}
