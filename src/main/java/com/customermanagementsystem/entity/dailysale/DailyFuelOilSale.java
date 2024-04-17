package com.customermanagementsystem.entity.dailysale;

import com.customermanagementsystem.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "daily_fuel_oil_sale")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DailyFuelOilSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    @OneToOne
    private Product product;

    
    private Double amount;

    @ManyToOne
    private DailySale dailySale;
}
