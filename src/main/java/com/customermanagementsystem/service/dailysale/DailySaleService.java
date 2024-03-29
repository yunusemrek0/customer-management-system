package com.customermanagementsystem.service.dailysale;

import com.customermanagementsystem.entity.customer.CustomerPayment;
import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.entity.dailysale.fuelpomp.FuelPompStatistic;
import com.customermanagementsystem.entity.dailysale.posdevice.PosDeviceSale;
import com.customermanagementsystem.entity.employee.EmployeeExpense;
import com.customermanagementsystem.payload.mapper.dailysale.DailySaleMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.dailysale.DailySaleRequest;
import com.customermanagementsystem.repository.dailysale.DailySaleRepository;
import com.customermanagementsystem.service.helper.dailysale.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailySaleService {

    private final DailySaleRepository dailySaleRepository;
    private final ForwardSaleHelperForDailySale forwardSaleHelper;
    private final FuelPompStatisticHelperForDailySale fuelPompStatisticHelper;
    private final CustomerPaymentHelperForDailySale paymentHelper;
    private final EmployeeExpenseHelperForDailySale employeeExpenseHelper;
    private final PosDeviceSaleHelperForDailySale posDeviceSaleHelper;
    private final DailySaleMapper dailySaleMapper;

    @Transactional
    public String saveDailySale(DailySaleRequest dailySaleRequest) {


        List<FuelPompStatistic> fuelPompStatistics = fuelPompStatisticHelper.getByDailySaleIsNull();
        double totalFuelPompSales = fuelPompStatisticHelper.totalFuelPompSales(fuelPompStatistics);

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

        DailySale dailySaleToSave = dailySaleMapper.mapDailySaleRequestToDailySale(dailySaleRequest);
        dailySaleToSave.setFuelPompStatistics(fuelPompStatistics);
        dailySaleToSave.setTotalFuelPompSales(totalFuelPompSales);

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

        dailySaleToSave.setBalance(balanceCalculator(dailySaleToSave));

        DailySale savedDailySale = dailySaleRepository.save(dailySaleToSave);

        fuelPompStatisticHelper.saveDailySaleForFuelStatistic(fuelPompStatistics,savedDailySale);
        forwardSaleHelper.saveDailySaleForForwardSale(forwardSales,savedDailySale);
        paymentHelper.saveDailySaleForCustomerPayment(customerPayments,savedDailySale);
        employeeExpenseHelper.saveDailySaleForEmployeeExpense(employeeExpenses,savedDailySale);
        posDeviceSaleHelper.saveDailySaleFoPosDeviceSale(posDeviceSales,savedDailySale);




        return SuccessMessages.DAILY_SALE_SAVE;
    }

    private double balanceCalculator(DailySale dailySale){

        return
            (dailySale.getTotalPosDeviceSale()+dailySale.getTotalCash()+dailySale.getBankTransferTotal()+dailySale.getTotalEmployeeExpense())-

            (dailySale.getTotalCustomerPaymentsWithCash()+dailySale.getTotalCustomerPaymentsWithCreditCard())-

            (dailySale.getTotalFuelPompSales() - dailySale.getTotalForwardSalesForCashPrice());

    }
}
