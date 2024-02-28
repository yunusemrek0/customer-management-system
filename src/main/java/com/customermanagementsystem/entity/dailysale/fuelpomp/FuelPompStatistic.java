package com.customermanagementsystem.entity.dailysale.fuelpomp;

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
@Table(name = "fuel_pomp_statistic")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuelPompStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;


    @ManyToOne
    private Product product;


    @ManyToOne
    private FuelPomp fuelPomp;


    private Double amountAsLiter;


    private Double total;


    @ManyToOne
    private DailySale dailySale;


}
