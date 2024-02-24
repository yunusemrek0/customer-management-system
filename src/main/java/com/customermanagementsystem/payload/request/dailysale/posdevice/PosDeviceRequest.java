package com.customermanagementsystem.payload.request.dailysale.posdevice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PosDeviceRequest {

    @NotNull(message = "Pos cihaz isim kısmı boş bırakılamaz.")
    private String name;

}
