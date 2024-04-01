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
public class ProductRequest {

    @NotNull(message = "Ürün adı kısmı boş geçilemez.")
    private String name;

    @NotNull(message = "Ürün alış fiyat kısmı boş geçilemez.")
    private Double purchasePrice;

    @NotNull(message = "Ürün satış fiyat kısmı boş geçilemez.")
    private Double priceForCash;

    @NotNull(message = "Ürün vadeli fiyat kısmı boş geçilemez.")
    private Double priceForForwardSale;

    @NotNull(message = "Ürün nakliyeli fiyat kısmı boş geçilemez.")
    private Double priceForWithTransportation;

    @NotNull(message = "Ürün stok kısmı boş geçilemez.")
    private Double stockAmountAsLiter;

    private Long dealerId;
}
