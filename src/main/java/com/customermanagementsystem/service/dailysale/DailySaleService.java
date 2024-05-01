package com.customermanagementsystem.service.dailysale;

import com.customermanagementsystem.entity.customer.CustomerPayment;
import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import com.customermanagementsystem.entity.dailysale.DailyExpense;
import com.customermanagementsystem.entity.dailysale.DailyFuelOilSale;
import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.entity.dailysale.posdevice.PosDeviceSale;
import com.customermanagementsystem.entity.employee.EmployeeExpense;
import com.customermanagementsystem.payload.mapper.dailysale.DailySaleMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.dailysale.DailySaleRequest;
import com.customermanagementsystem.payload.response.dailysale.DailySaleResponse;
import com.customermanagementsystem.repository.dailysale.DailySaleRepository;
import com.customermanagementsystem.service.helper.dailysale.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DailySaleService {

    private final DailySaleRepository dailySaleRepository;
    private final ForwardSaleHelperForDailySale forwardSaleHelper;
    private final CustomerPaymentHelperForDailySale paymentHelper;
    private final EmployeeExpenseHelperForDailySale employeeExpenseHelper;
    private final PosDeviceSaleHelperForDailySale posDeviceSaleHelper;
    private final DailySaleMapper dailySaleMapper;
    private final DailyFuelOilSaleHelperForDailySale fuelOilSaleHelper;
    private final DailyProfitHelper dailyProfitHelper;
    private final DailyExpenseHelperForDailySale dailyExpenseHelper;

    @Transactional
    public String saveDailySale(DailySaleRequest dailySaleRequest) {



        List<DailyFuelOilSale> dailyFuelOilSales = fuelOilSaleHelper.getByDailySaleIsNull();
        double totalFuelOilSale = fuelOilSaleHelper.totalFuelOilSales(dailyFuelOilSales);
        double totalFuelOilSaleAsPurchasePrice = fuelOilSaleHelper.totalFuelOilSalesAsPurchasePrice(dailyFuelOilSales);

        List<ForwardSale> forwardSales = forwardSaleHelper.getByDailySaleIsNull();
        double totalForwardSalesForCashPrice = forwardSaleHelper.totalSaleAsCash(forwardSales);
        double totalForwardSalesForForwardPrice = forwardSaleHelper.totalSaleAsForward(forwardSales);

        List<CustomerPayment> customerPayments = paymentHelper.getByDailySaleNull();
        double totalCustomerPaymentsWithCashOrBankTransfer = paymentHelper.totalCustomerPaymentForCashOrBankTransfer(customerPayments);
        double totalCustomerPaymentsWithCreditCard = paymentHelper.totalCustomerPaymentForCreditCard(customerPayments);

        List<EmployeeExpense> employeeExpenses = employeeExpenseHelper.getByDailySaleIsNull();
        double totalEmployeeExpense = employeeExpenseHelper.totalEmployeeExpense(employeeExpenses);

        List<PosDeviceSale> posDeviceSales = posDeviceSaleHelper.getByDailySaleIsNull();
        double totalPosDeviceSale = posDeviceSaleHelper.totalPosDeviceSale(posDeviceSales);

        List<DailyExpense> dailyExpenses = dailyExpenseHelper.getByDailySaleIsNull();
        double totalDailyExpense = dailyExpenseHelper.totalDailyExpense(dailyExpenses);



        DailySale dailySaleToSave = dailySaleMapper.mapDailySaleRequestToDailySale(dailySaleRequest);
        dailySaleToSave.setDailyFuelOilSales(dailyFuelOilSales);
        dailySaleToSave.setTotalFuelOilSales(totalFuelOilSale);
        dailySaleToSave.setTotalFuelOilSalesAsPurchasePrice(totalFuelOilSaleAsPurchasePrice);

        dailySaleToSave.setForwardSales(forwardSales);
        dailySaleToSave.setTotalForwardSalesForCashPrice(totalForwardSalesForCashPrice);
        dailySaleToSave.setTotalForwardSalesForForwardPrice(totalForwardSalesForForwardPrice);

        dailySaleToSave.setCustomerPayments(customerPayments);
        dailySaleToSave.setTotalCustomerPaymentsWithCreditCard(totalCustomerPaymentsWithCreditCard);
        dailySaleToSave.setTotalCustomerPaymentsWithCash(totalCustomerPaymentsWithCashOrBankTransfer);

        dailySaleToSave.setEmployeeExpenses(employeeExpenses);
        dailySaleToSave.setTotalEmployeeExpense(totalEmployeeExpense);

        dailySaleToSave.setPosDeviceSales(posDeviceSales);
        dailySaleToSave.setTotalPosDeviceSale(totalPosDeviceSale);

        dailySaleToSave.setDailyExpenses(dailyExpenses);
        dailySaleToSave.setTotalExpenses(totalDailyExpense);

        dailySaleToSave.setBalance(balanceCalculator(dailySaleToSave));

        DailySale savedDailySale = dailySaleRepository.save(dailySaleToSave);

        //dailyProfitHelper.dailyProfitCreator(savedDailySale);
        fuelOilSaleHelper.saveDailySaleForFuelOilSales(dailyFuelOilSales,savedDailySale);
        forwardSaleHelper.saveDailySaleForForwardSale(forwardSales,savedDailySale);
        paymentHelper.saveDailySaleForCustomerPayment(customerPayments,savedDailySale);
        employeeExpenseHelper.saveDailySaleForEmployeeExpense(employeeExpenses,savedDailySale);
        posDeviceSaleHelper.saveDailySaleFoPosDeviceSale(posDeviceSales,savedDailySale);
        dailyExpenseHelper.saveDailySaleForDailyExpense(dailyExpenses,savedDailySale);
        dailyProfitHelper.dailyProfitCreator(savedDailySale);




        return SuccessMessages.DAILY_SALE_SAVE;
    }

    private double balanceCalculator(DailySale dailySale){

        return
            (dailySale.getTotalPosDeviceSale()+dailySale.getTotalCash()+dailySale.getBankTransferTotal()+dailySale.getTotalEmployeeExpense()+dailySale.getTotalExpenses())-

            (dailySale.getTotalCustomerPaymentsWithCash()+dailySale.getTotalCustomerPaymentsWithCreditCard())-

            (dailySale.getTotalFuelOilSales() - dailySale.getTotalForwardSalesForForwardPrice());

    }



    public List<DailySaleResponse> getAll() {

        return dailySaleRepository.findAll()
                .stream()
                .map(dailySaleMapper::mapDailySaleToDailySaleResponse)
                .collect(Collectors.toList());
    }
}
