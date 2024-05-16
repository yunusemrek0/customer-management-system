package com.customermanagementsystem.entity.expense;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "typeOfExpense")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeOfExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double balance;
}
