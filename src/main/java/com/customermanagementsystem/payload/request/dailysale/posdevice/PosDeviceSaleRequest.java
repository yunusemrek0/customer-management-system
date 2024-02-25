package com.customermanagementsystem.payload.request.dailysale.posdevice;

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
public class PosDeviceSaleRequest {



    @NotNull(message = "Toplam kısmı boş bırakılamaz.")
    @DecimalMin(value = "0.00",message = "Toplam 0'dan küçük olamaz.")
    private Double total;

    @NotNull(message = "Lütfen geçerli bir pos cihazi seçiniz.")
    private Long posDeviceId;
}
