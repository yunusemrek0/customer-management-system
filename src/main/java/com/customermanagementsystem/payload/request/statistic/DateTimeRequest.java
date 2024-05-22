package com.customermanagementsystem.payload.request.statistic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DateTimeRequest {

    private String startDate;

    private String endDate;
}
