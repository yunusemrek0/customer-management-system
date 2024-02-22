package com.customermanagementsystem.payload.request.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DealerRequest {


    @NotNull(message = "Bayii adı kısmı boş geçilemez.")
    private String name;

    @NotNull(message = "Bakiye kısmı boş geçilemez.")
    private Double balance;
}
