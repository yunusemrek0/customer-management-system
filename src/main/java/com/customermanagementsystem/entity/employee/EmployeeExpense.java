package com.customermanagementsystem.entity.employee;


import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class EmployeeExpense {

    private Long id;

    private LocalDateTime dateTime;

    @ManyToOne
    private Employee employee;

    private Double total;

    private Boolean isTransferred;
}
