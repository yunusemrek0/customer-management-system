package com.customermanagementsystem.entity.dealer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_purchase")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    @ManyToOne
    private Dealer dealer;

    @ManyToOne
    private Product product;

    private Double purchasePrice;

    private Double amount;

    private Double total;
}
