package com.customermanagementsystem.payload.request.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {

    @NotNull(message = "Müşteri adı kısmı boş geçilemez.")
    private String name;

    private String mobilePhone;

    private String address;

    private String description;

    private String ssn;

    private String taxOffice;

    private String taxNo;

    @NotNull(message = "Bakiye kısmı boş geçilemez.")
    private Double balance;
}
