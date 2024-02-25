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
public class FuelPompRequestToUpdate {

    @NotNull(message = "Numerator boş bırakılamaz.")
    private Double newNumerator;
}
