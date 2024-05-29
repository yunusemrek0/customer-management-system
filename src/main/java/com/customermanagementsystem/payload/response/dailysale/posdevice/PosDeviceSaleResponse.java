package com.customermanagementsystem.payload.response.dailysale.posdevice;

import com.customermanagementsystem.service.helper.LocalDateTimeToDateStringSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PosDeviceSaleResponse {


    private Long id;

    @JsonSerialize(using = LocalDateTimeToDateStringSerializer.class)
    private LocalDateTime dateTime;

    private Double total;

    private String posDeviceName;
}
