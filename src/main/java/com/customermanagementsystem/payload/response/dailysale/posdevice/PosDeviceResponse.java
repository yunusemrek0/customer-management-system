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
public class PosDeviceResponse {


    private Long id;

    private String name;

    @JsonSerialize(using = LocalDateTimeToDateStringSerializer.class)
    private LocalDateTime creationDate;
}
