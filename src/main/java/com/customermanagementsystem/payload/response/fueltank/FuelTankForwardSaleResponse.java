package com.customermanagementsystem.payload.response.fueltank;

import com.customermanagementsystem.entity.customer.Customer;
import com.customermanagementsystem.entity.fueltank.FuelTank;
import com.customermanagementsystem.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FuelTankForwardSaleResponse {

    private Long id;

    private LocalDateTime dateTime;

    private String customerName;

    private String productName;

    private Double amount;

    private Double unitPrice;

    private Double total;
}
