package com.customermanagementsystem.entity.fueltank;

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
@Table(name = "fuel_tank_sale")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuelTankSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    @ManyToOne
    private FuelTank fuelTank;

    @ManyToOne
    private Product product;

    private Double amount;

    private Double unitPrice;

    private Double total;

    @ManyToOne
    private DailySale dailySale;
}
