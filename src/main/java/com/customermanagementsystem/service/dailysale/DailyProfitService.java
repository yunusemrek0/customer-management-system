package com.customermanagementsystem.service.dailysale;

import com.customermanagementsystem.payload.mapper.dailysale.DailyProfitMapper;
import com.customermanagementsystem.payload.request.statistic.DateTimeRequest;
import com.customermanagementsystem.payload.response.dailysale.DailyProfitResponse;
import com.customermanagementsystem.repository.dailysale.DailyProfitRepository;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DailyProfitService {

    private final DailyProfitRepository dailyProfitRepository;
    private final DailyProfitMapper dailyProfitMapper;
    private final DateTimeTranslator dateTimeTranslator;



    public List<DailyProfitResponse> getAll() {
        return dailyProfitRepository.findAll()
                .stream()
                .map(dailyProfitMapper::mapDailyProfitToDailyProfitResponse)
                .collect(Collectors.toList());
    }

    public Double totalProfitBetweenDate(DateTimeRequest dateTimeRequest) {
        return dailyProfitRepository.findTotalExpenseBetweenDate(
                dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getStartDate()),
                dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getEndDate())
        );
    }
}
