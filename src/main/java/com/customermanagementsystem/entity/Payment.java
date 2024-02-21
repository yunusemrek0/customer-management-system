package com.customermanagementsystem.entity;

import com.customermanagementsystem.entity.dealer.Dealer;
import com.customermanagementsystem.entity.enums.TypeOfPayment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    private String description;

    private Double total;

    @ManyToOne
    private Dealer dealer;

    @Enumerated(EnumType.STRING)
    private TypeOfPayment typeOfPayment;


}
