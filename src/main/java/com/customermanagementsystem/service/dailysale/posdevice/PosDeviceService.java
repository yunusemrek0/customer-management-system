package com.customermanagementsystem.service.dailysale.posdevice;

import com.customermanagementsystem.payload.mapper.dailysale.posdevice.PosDeviceMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.dailysale.posdevice.PosDeviceRequest;
import com.customermanagementsystem.payload.response.dailysale.posdevice.PosDeviceResponse;
import com.customermanagementsystem.repository.dailysale.posdevice.PosDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PosDeviceService {

    private final PosDeviceRepository posDeviceRepository;
    private final PosDeviceMapper posDeviceMapper;

    public String savePosDevice(PosDeviceRequest posDeviceRequest) {
        posDeviceRepository.save(
                posDeviceMapper.mapPosDeviceRequestToPosDevice(posDeviceRequest)
        );

        return SuccessMessages.POS_DEVICE_SAVE;
    }

    public List<PosDeviceResponse> getAll() {
        return posDeviceRepository.findAll()
                .stream()
                .map(posDeviceMapper::mapPosDeviceToPosDeviceResponse)
                .collect(Collectors.toList());
    }
}
