package com.customermanagementsystem.controller.statistic;

import com.customermanagementsystem.payload.request.statistic.DateTimeRequest;
import com.customermanagementsystem.payload.response.customer.ForwardSaleResponse;
import com.customermanagementsystem.payload.response.dailysale.DailyFuelOilSaleResponse;
import com.customermanagementsystem.payload.response.dailysale.posdevice.PosDeviceSaleResponse;
import com.customermanagementsystem.payload.response.product.ProductPurchaseResponse;
import com.customermanagementsystem.service.customer.ForwardSaleService;
import com.customermanagementsystem.service.dailysale.DailyExpenseService;
import com.customermanagementsystem.service.dailysale.DailyFuelOilSaleService;
import com.customermanagementsystem.service.dailysale.DailyProfitService;
import com.customermanagementsystem.service.dailysale.DailySaleService;
import com.customermanagementsystem.service.dailysale.posdevice.PosDeviceSaleService;
import com.customermanagementsystem.service.expense.ExpenseService;
import com.customermanagementsystem.service.product.ProductPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/statistic")
@RequiredArgsConstructor
public class StatisticController {

    private final DailyFuelOilSaleService dailyFuelOilSaleService;
    private final ForwardSaleService forwardSaleService;
    private final DailySaleService dailySaleService;
    private final PosDeviceSaleService posDeviceSaleService;
    private final ExpenseService expenseService;
    private final DailyExpenseService dailyExpenseService;
    private final ProductPurchaseService productPurchaseService;
    private final DailyProfitService dailyProfitService;

    @GetMapping("/fuelOilSaleBetweenDate")
    public ResponseEntity<List<DailyFuelOilSaleResponse>> fuelOilSaleBetweenDate(@RequestBody DateTimeRequest dateTimeRequest){
        return ResponseEntity.ok(dailyFuelOilSaleService.fuelOilSaleBetweenDate(dateTimeRequest));
    }

    @GetMapping("/forwardSaleBetweenDate")
    public ResponseEntity<Double> forwardSaleTotalBetweenDate(@RequestBody DateTimeRequest dateTimeRequest){
        return ResponseEntity.ok(forwardSaleService.forwardSaleTotalBetweenDate(dateTimeRequest));
    }

    @GetMapping("/reportZTotalBetweenDate")
    public ResponseEntity<Double> reportZTotalBetweenDate(@RequestBody DateTimeRequest dateTimeRequest){
        return ResponseEntity.ok(dailySaleService.reportZTotalBetweenDate(dateTimeRequest));
    }

    @GetMapping("/posDeviceSaleBetweenDate")
    public ResponseEntity<List<PosDeviceSaleResponse>> posDeviceSaleBetweenDate(@RequestBody DateTimeRequest dateTimeRequest){
        return ResponseEntity.ok(posDeviceSaleService.posDeviceSaleBetweenDate(dateTimeRequest));
    }

    @GetMapping("/totalExpenses")
    public Double totalExpenses(@RequestBody DateTimeRequest dateTimeRequest){
        return expenseService.findTotalByDateBetween(dateTimeRequest) +
                dailyExpenseService.findTotalByDateBetween(dateTimeRequest);

    }

    @GetMapping("/productPurchaseBetweenDate")
    public ResponseEntity<List<ProductPurchaseResponse>> productPurchaseBetweenDate(@RequestBody DateTimeRequest dateTimeRequest){
        return ResponseEntity.ok(productPurchaseService.productPurchaseBetweenDate(dateTimeRequest));
    }

    @GetMapping("/totalProfit")
    public ResponseEntity<Double> totalProfitBetweenDate(@RequestBody DateTimeRequest dateTimeRequest){
        return ResponseEntity.ok(dailyProfitService.totalProfitBetweenDate(dateTimeRequest));
    }

    @GetMapping("/adBlueAndVehicleMatic")
    public ResponseEntity<List<ForwardSaleResponse>> adBlueAndVehicleMatic(@RequestBody DateTimeRequest dateTimeRequest){
        return ResponseEntity.ok(forwardSaleService.adBlueAndVehicleMatic(dateTimeRequest));
    }


}
