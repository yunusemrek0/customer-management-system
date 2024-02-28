package com.customermanagementsystem.entity.customer;

import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.entity.enums.TypeOfCustomerPayment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    private Double total;

    private String description;

    @Enumerated(EnumType.STRING)
    private TypeOfCustomerPayment typeOfCustomerPayment;


    @ManyToOne
    private DailySale dailySale;


}
