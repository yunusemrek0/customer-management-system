package com.customermanagementsystem.service.helper;

import com.customermanagementsystem.entity.dailysale.posdevice.PosDevice;
import com.customermanagementsystem.exception.ResourceNotFoundException;
import com.customermanagementsystem.payload.messages.ErrorMessages;
import com.customermanagementsystem.repository.dailysale.posdevice.PosDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PosDeviceHelper {

    private final PosDeviceRepository posDeviceRepository;


    public PosDevice isExistById(Long id){

        return posDeviceRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format(ErrorMessages.POS_DEVICE_NOT_FOUND_ID,id))
        );
    }
}
