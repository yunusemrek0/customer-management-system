package com.customermanagementsystem.entity.employee;

import com.customermanagementsystem.entity.dailysale.DailySale;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    @ManyToOne
    private Employee employee;

    private Double total;

    @ManyToOne
    private DailySale dailySale;

}
