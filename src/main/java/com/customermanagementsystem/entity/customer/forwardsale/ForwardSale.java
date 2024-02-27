package com.customermanagementsystem.entity.customer.forwardsale;

import com.customermanagementsystem.entity.customer.Customer;
import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "forward_sale")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForwardSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    @ManyToOne
    private Product product;

    private Double unitPrice;

    private Double amount;

    private Double total;

    @ManyToOne
    private Customer customer;


    @ManyToOne
    private DailySale dailySale;
}
