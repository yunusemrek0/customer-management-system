package com.customermanagementsystem.service.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyExpense;
import com.customermanagementsystem.payload.mapper.dailysale.DailyExpenseMapper;
import com.customermanagementsystem.payload.request.dailysale.DailyExpenseRequest;
import com.customermanagementsystem.payload.request.statistic.DateTimeRequest;
import com.customermanagementsystem.payload.response.dailysale.DailyExpenseResponse;
import com.customermanagementsystem.repository.dailysale.DailyExpenseRepository;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DailyExpenseService {

    private final DailyExpenseRepository dailyExpenseRepository;
    private final DailyExpenseMapper dailyExpenseMapper;
    private final DateTimeTranslator dateTimeTranslator;
    public String saveDailyExpense(DailyExpenseRequest dailyExpenseRequest) {

        DailyExpense dailyExpenseToSave = dailyExpenseMapper.mapDailyExpenseRequestToDailyExpense(dailyExpenseRequest);
        dailyExpenseRepository.save(dailyExpenseToSave);

        return "GÜNLÜK GİDER BAŞARILI BİR ŞEKİLDE KAYDEDİLDİ.";
    }

    public List<DailyExpenseResponse> getAll() {
        return dailyExpenseRepository.getByDailySaleIsNull()
                .stream()
                .map(dailyExpenseMapper::mapDailyExpenseToDailyExpenseResponse)
                .collect(Collectors.toList());

    }

    public Double findTotalByDateBetween(DateTimeRequest dateTimeRequest) {
        Double total =  dailyExpenseRepository.findTotalExpenseBetweenDate(
                dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getStartDate()),
                dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getEndDate())
        );

        if (total == null) return 0.0;
        return total;
    }

    public String deleteById(Long id) {
        dailyExpenseRepository.deleteById(id);
        return null;
    }

    public List<DailyExpenseResponse> getAllNull() {
        return dailyExpenseRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(DailyExpense::getDateTime).reversed())
                .map(dailyExpenseMapper::mapDailyExpenseToDailyExpenseResponse)
                .collect(Collectors.toList());
    }
}
