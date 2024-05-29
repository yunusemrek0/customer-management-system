package com.customermanagementsystem.payload.request.customer;

import com.customermanagementsystem.payload.request.customer.abstraction.AbstractCustomerMovementRequest;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ForwardSaleRequest extends AbstractCustomerMovementRequest {

    @NotNull(message = "Lütfen geçerli bir ürün seçin.")//******
    private Long productId;

    @NotNull(message = "Birim fiyat boş bırakılamaz.")//******
    private Double unitPrice;

    @NotNull(message = "Miktar boş bırakılamaz.")//******
    private Double amount;




}
