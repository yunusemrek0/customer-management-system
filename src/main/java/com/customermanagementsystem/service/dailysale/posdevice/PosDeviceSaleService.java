package com.customermanagementsystem.service.dailysale.posdevice;

import com.customermanagementsystem.entity.dailysale.posdevice.PosDevice;
import com.customermanagementsystem.entity.dailysale.posdevice.PosDeviceSale;
import com.customermanagementsystem.payload.mapper.dailysale.posdevice.PosDeviceSaleMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.dailysale.posdevice.PosDeviceSaleRequest;
import com.customermanagementsystem.payload.request.statistic.DateTimeRequest;
import com.customermanagementsystem.payload.response.dailysale.DailyFuelOilSaleResponse;
import com.customermanagementsystem.payload.response.dailysale.posdevice.PosDeviceSaleResponse;
import com.customermanagementsystem.repository.dailysale.posdevice.PosDeviceSaleRepository;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.PosDeviceHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PosDeviceSaleService {
    
    private final PosDeviceSaleRepository posDeviceSaleRepository;
    private final PosDeviceSaleMapper posDeviceSaleMapper;
    private final PosDeviceHelper posDeviceHelper;
    private final DateTimeTranslator dateTimeTranslator;

    public String savePosDeviceSale(PosDeviceSaleRequest posDeviceSaleRequest) {
        
        PosDevice posDevice = posDeviceHelper.isExistById(posDeviceSaleRequest.getPosDeviceId());
        
        PosDeviceSale posDeviceSaleToSave = posDeviceSaleMapper.mapPosDeviceSaleRequestToPosDeviceSale(posDeviceSaleRequest);
        posDeviceSaleToSave.setPosDevice(posDevice);
        
        posDeviceSaleRepository.save(posDeviceSaleToSave);
        
        return SuccessMessages.POS_DEVICE_SALE_SAVE;
    }

    public List<PosDeviceSaleResponse> findByDateTime(String startDateTime, String endDateTime) {



        return posDeviceSaleRepository.findByDateTimeBetween(dateTimeTranslator.parseLocalDateTime(startDateTime),
                                                             dateTimeTranslator.parseLocalDateTime(endDateTime))
                .stream()
                .map(posDeviceSaleMapper::mapPosDeviceSaleToPosDeviceSaleResponse)
                .collect(Collectors.toList());
    }

    public List<PosDeviceSaleResponse> getAll() {
        return posDeviceSaleRepository.getByDailySaleIsNull()
                .stream()
                .map(posDeviceSaleMapper::mapPosDeviceSaleToPosDeviceSaleResponse)
                .collect(Collectors.toList());
    }

    public List<PosDeviceSaleResponse> posDeviceSaleBetweenDate(DateTimeRequest dateTimeRequest) {
        List<Object[]> results = posDeviceSaleRepository.findPosDeviceSalesBetweenDate( dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getStartDate()),
                                                                                        dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getEndDate()));

        List<PosDeviceSaleResponse> responseList = new ArrayList<>();

        for (Object[] result : results) {
            PosDeviceSaleResponse response = new PosDeviceSaleResponse();
            response.setId((Long) result[0]); // Ürün id'sini burada kullanıyoruz.
            response.setPosDeviceName((String) result[1]);
            response.setTotal((Double) result[2]);

            responseList.add(response);
        }

        return responseList;
    }
}
