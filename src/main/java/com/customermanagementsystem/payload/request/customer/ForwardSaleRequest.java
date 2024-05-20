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
public class ForwardSaleRequest {

    @NotNull(message = "Lütfen geçerli bir ürün seçin.")
    private Long productId;

    @NotNull(message = "Birim fiyat boş bırakılamaz.")
    private Double unitPrice;

    @NotNull(message = "Miktar boş bırakılamaz.")
    private Double amount;

    @NotNull(message = "Lütfen geçerli bir müşteri seçin.")
    private Long customerId;

    private String description;


}
