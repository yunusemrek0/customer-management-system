package com.customermanagementsystem.service.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@RequiredArgsConstructor
public class MapperHelper {



    public Double formatDoubleValue(Double value) {
        if (value != null) {
            BigDecimal bigDecimal = BigDecimal.valueOf(value);
            bigDecimal = bigDecimal.setScale(3, RoundingMode.HALF_UP);
            return bigDecimal.doubleValue();
        }
        return null;
    }
}
