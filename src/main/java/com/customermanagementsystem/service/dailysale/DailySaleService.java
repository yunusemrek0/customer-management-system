package com.customermanagementsystem.service.dailysale;

import com.customermanagementsystem.entity.customer.CustomerPayment;
import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import com.customermanagementsystem.entity.dailysale.fuelpomp.FuelPompStatistic;
import com.customermanagementsystem.entity.dailysale.posdevice.PosDeviceSale;
import com.customermanagementsystem.entity.employee.EmployeeExpense;
import com.customermanagementsystem.payload.request.dailysale.DailySaleRequest;
import com.customermanagementsystem.repository.dailysale.DailySaleRepository;
import com.customermanagementsystem.service.helper.dailysale.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public String saveDailySale(DailySaleRequest dailySaleRequest) {

        List<FuelPompStatistic> fuelPompStatistics = fuelPompStatisticHelper.fuelPompStatisticCalculator();

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


        return null;
    }
}
