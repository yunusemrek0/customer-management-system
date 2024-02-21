package com.customermanagementsystem.payload.response.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {


    private Long id;

    private String name;

    private String mobilePhone;

    private String address;

    private String description;

    private String ssn;

    private String taxOffice;

    private String taxNo;

    private Double balance;
}
