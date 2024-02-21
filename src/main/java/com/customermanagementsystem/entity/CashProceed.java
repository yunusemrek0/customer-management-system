package com.customermanagementsystem.entity;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class CashProceed {

    private Long id;

    @ManyToOne
    private Customer customer;

    private LocalDateTime dateTime;

    private Double total;

    private String description;

    private Boolean isTransferred;


}
