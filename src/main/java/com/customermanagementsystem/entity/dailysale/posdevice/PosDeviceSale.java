package com.customermanagementsystem.entity.dailysale.posdevice;

import com.customermanagementsystem.entity.dailysale.DailySale;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pos_device_sale")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PosDeviceSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    private Double total;

    @ManyToOne
    private PosDevice posDevice;

    private Boolean isTransferred;

    @ManyToOne
    private DailySale dailySale;
}
