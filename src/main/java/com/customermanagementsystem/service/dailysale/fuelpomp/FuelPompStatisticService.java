package com.customermanagementsystem.service.dailysale.fuelpomp;

import com.customermanagementsystem.payload.mapper.dailysale.fuelpomp.FuelPompStatisticMapper;
import com.customermanagementsystem.payload.response.dailysale.fuelpomp.FuelPompStatisticResponse;
import com.customermanagementsystem.repository.dailysale.fuelpomp.FuelPompStatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuelPompStatisticService {

    private final FuelPompStatisticRepository fuelPompStatisticRepository;
    private final FuelPompStatisticMapper fuelPompStatisticMapper;

    public List<FuelPompStatisticResponse> getAll() {

        return fuelPompStatisticRepository.getByDailySaleIsNull()
                .stream()
                .map(fuelPompStatisticMapper::mapFuelPompStatisticToFuelPompStatisticResponse)
                .collect(Collectors.toList());
    }
}
