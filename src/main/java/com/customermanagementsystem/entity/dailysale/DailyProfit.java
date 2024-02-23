package com.customermanagementsystem.entity.dailysale;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "daily_profit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DailyProfit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    @OneToOne
    private DailySale dailySale;

    private Double profit;

    private Double balance;
}
