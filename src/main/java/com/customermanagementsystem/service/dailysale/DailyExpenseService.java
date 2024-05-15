package com.customermanagementsystem.service.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyExpense;
import com.customermanagementsystem.payload.mapper.dailysale.DailyExpenseMapper;
import com.customermanagementsystem.payload.request.dailysale.DailyExpenseRequest;
import com.customermanagementsystem.payload.response.dailysale.DailyExpenseResponse;
import com.customermanagementsystem.repository.dailysale.DailyExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DailyExpenseService {

    private final DailyExpenseRepository dailyExpenseRepository;
    private final DailyExpenseMapper dailyExpenseMapper;

    public String saveDailyExpense(DailyExpenseRequest dailyExpenseRequest) {

        DailyExpense dailyExpenseToSave = dailyExpenseMapper.mapDailyExpenseRequestToDailyExpense(dailyExpenseRequest);
        dailyExpenseRepository.save(dailyExpenseToSave);

        return "GÜNLÜK GİDER BAŞARILI BİR ŞEKİLDE KAYDEDİLDİ.";
    }

    public List<DailyExpenseResponse> getAll() {
        return dailyExpenseRepository.findAll()
                .stream()
                .map(dailyExpenseMapper::mapDailyExpenseToDailyExpenseResponse)
                .collect(Collectors.toList());
    }
}
