package com.customermanagementsystem.service.fueltank;

import com.customermanagementsystem.payload.mapper.fueltank.FuelTankMapper;
import com.customermanagementsystem.payload.response.fueltank.FuelTankResponse;
import com.customermanagementsystem.repository.fueltank.FuelTankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuelTankService {

    private final FuelTankRepository fuelTankRepository;
    private final FuelTankMapper fuelTankMapper;

    public List<FuelTankResponse> getAll() {
        return fuelTankRepository.findAll()
                .stream()
                .map(fuelTankMapper::mapFuelTankToResponse)
                .collect(Collectors.toList());
    }
}
