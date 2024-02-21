package com.customermanagementsystem.entity;

import com.customermanagementsystem.entity.enums.TypeOfPayment;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class Payment {

    private Long id;

    private LocalDateTime dateTime;

    private String description;

    private Double total;

    @ManyToOne
    private Dealer dealer;

    @Enumerated(EnumType.STRING)
    private TypeOfPayment typeOfPayment;


}
