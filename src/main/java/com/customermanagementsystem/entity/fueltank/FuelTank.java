package com.customermanagementsystem.entity.fueltank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "fuel_tank")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuelTank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double amountInside;
}
