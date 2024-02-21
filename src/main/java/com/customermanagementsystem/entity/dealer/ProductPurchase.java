package com.customermanagementsystem.entity.dealer;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class ProductPurchase {

    private Long id;

    private LocalDateTime dateTime;

    @ManyToOne
    private Dealer dealer;

    @ManyToOne
    private Product product;

    private Double purchasePrice;

    private Double amount;

    private Double total;
}
