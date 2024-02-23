package com.customermanagementsystem.payload.request.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPurchaseRequest {


    @NotNull(message = "Lütfen geçerli bir bayii seçiniz")
    private Long dealerId;

    @NotNull(message = "Lütfen geçerli bir ürün seçiniz")
    private Long productId;

    @NotNull(message = "Alış fiyat kısmı bpş geçilemez.")
    @DecimalMin("0.00")
    private Double purchasePrice;

    @NotNull(message = "Miktar kısmı bpş geçilemez.")
    @DecimalMin("0.00")
    private Double amount;

}
