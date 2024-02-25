package com.customermanagementsystem.payload.request.dailysale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuelPompRequestToSave {

    @NotNull(message = "İsim kısmı boş bırakılamaz.")
    private String name;

    @NotNull(message = "Numerator kısmı boş bırakılamaz.")
    private Double oldNumerator;

    @NotNull(message = "Lütfen geçerli bir ürün seçiniz.")
    private Long productId;
}
