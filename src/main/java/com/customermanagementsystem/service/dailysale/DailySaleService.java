package com.customermanagementsystem.service.dailysale;

import com.customermanagementsystem.entity.customer.CustomerPayment;
import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import com.customermanagementsystem.entity.dailysale.*;
import com.customermanagementsystem.entity.dailysale.posdevice.PosDeviceSale;
import com.customermanagementsystem.entity.employee.EmployeeExpense;
import com.customermanagementsystem.entity.employee.EmployeePayment;
import com.customermanagementsystem.entity.fueltank.FuelTankFill;
import com.customermanagementsystem.entity.fueltank.FuelTankSale;
import com.customermanagementsystem.payload.mapper.dailysale.DailySaleMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.dailysale.DailySaleBalanceRequest;
import com.customermanagementsystem.payload.request.dailysale.DailySaleRequest;
import com.customermanagementsystem.payload.request.statistic.DateTimeRequest;
import com.customermanagementsystem.payload.response.dailysale.DailySaleResponse;
import com.customermanagementsystem.repository.dailysale.DailySaleRepository;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
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
    private final MapperHelper mapperHelper;
    private final EmployeePaymentHelperForDailySale employeePaymentHelper;
    private final FuelTankFillHelperForDailySale fuelTankFillHelper;
    private final FuelTankSaleHelperForDailySale fuelTankSaleHelper;
    private final DateTimeTranslator dateTimeTranslator;
    private final CashAndBankHelperForDailySale cashAndBankHelper;


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

        List<EmployeePayment> employeePayments = employeePaymentHelper.getByDailySaleIsNull();
        double totalEmployeePayment = employeePaymentHelper.totalEmployeePayment(employeePayments);

        List<FuelTankFill> fuelTankFills = fuelTankFillHelper.getByDailySaleIsNull();
        double totalFuelTankFill = fuelTankFillHelper.totalFuelTankFill(fuelTankFills);

        List<FuelTankSale> fuelTankSales = fuelTankSaleHelper.getByDailySaleIsNull();
        double totalFuelTankSale = fuelTankSaleHelper.totalFuelTankSale(fuelTankSales);

        List<BankTransfer> bankTransfers = cashAndBankHelper.getByDailySaleIsNullBank();
        double totalBankTransfer = cashAndBankHelper.totalBankTransfer(bankTransfers);

        List<CashDelivery> cashDeliveries = cashAndBankHelper.getByDailySaleIsNullCash();
        double totalCash = cashAndBankHelper.totalCashDelivery(cashDeliveries);




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

        dailySaleToSave.setEmployeePayments(employeePayments);
        dailySaleToSave.setTotalEmployeePayment(totalEmployeePayment);

        dailySaleToSave.setFuelTankFills(fuelTankFills);
        dailySaleToSave.setTotalFuelTankFill(totalFuelTankFill);

        dailySaleToSave.setFuelTankSales(fuelTankSales);
        dailySaleToSave.setTotalFuelTankSale(totalFuelTankSale);

        dailySaleToSave.setCashDeliveries(cashDeliveries);
        dailySaleToSave.setTotalCash(totalCash);

        dailySaleToSave.setBankTransfers(bankTransfers);
        dailySaleToSave.setBankTransferTotal(totalBankTransfer);

        dailySaleToSave.setBalance(balanceCalculator(dailySaleToSave));
        dailySaleToSave.setTotalIncome(totalIncomeCalculator(dailySaleToSave));

        DailySale savedDailySale = dailySaleRepository.save(dailySaleToSave);


        fuelOilSaleHelper.saveDailySaleForFuelOilSales(dailyFuelOilSales,savedDailySale);
        forwardSaleHelper.saveDailySaleForForwardSale(forwardSales,savedDailySale);
        paymentHelper.saveDailySaleForCustomerPayment(customerPayments,savedDailySale);
        employeeExpenseHelper.saveDailySaleForEmployeeExpense(employeeExpenses,savedDailySale);
        posDeviceSaleHelper.saveDailySaleFoPosDeviceSale(posDeviceSales,savedDailySale);
        dailyExpenseHelper.saveDailySaleForDailyExpense(dailyExpenses,savedDailySale);
        dailyProfitHelper.dailyProfitCreator(savedDailySale);
        employeePaymentHelper.saveDailySaleForEmployeePayment(employeePayments,savedDailySale);
        fuelTankFillHelper.saveDailySaleForFuelTankFill(fuelTankFills,savedDailySale);
        fuelTankSaleHelper.saveDailySaleForFuelTankSale(fuelTankSales,savedDailySale);
        cashAndBankHelper.saveDailySaleForBankTransfer(bankTransfers,savedDailySale);
        cashAndBankHelper.saveDailySaleForCashDelivery(cashDeliveries,savedDailySale);




        return SuccessMessages.DAILY_SALE_SAVE;
    }

    private double balanceCalculator(DailySale dailySale){

        return
            (dailySale.getTotalPosDeviceSale()+dailySale.getTotalCash()+dailySale.getBankTransferTotal()+dailySale.getTotalEmployeeExpense()+dailySale.getTotalExpenses() + dailySale.getTotalFuelTankSale())-

            (dailySale.getTotalCustomerPaymentsWithCash()+dailySale.getTotalCustomerPaymentsWithCreditCard() + dailySale.getTotalEmployeePayment())-

            (dailySale.getTotalFuelOilSales() - dailySale.getTotalForwardSalesForForwardPrice() - dailySale.getTotalFuelTankFill());

    }

    private double totalIncomeCalculator(DailySale dailySale){
        return  dailySale.getTotalExpenses()+
                dailySale.getTotalCash()+
                dailySale.getTotalPosDeviceSale()+
                dailySale.getTotalEmployeeExpense()+
                dailySale.getTotalFuelTankSale()+
                dailySale.getBankTransferTotal();
    }



    public List<DailySaleResponse> getAll() {

        return dailySaleRepository.findAll()
                .stream()
                .map(dailySaleMapper::mapDailySaleToDailySaleResponse)
                .collect(Collectors.toList());
    }

    public Double findBalanceBeforeSave() {

        List<DailyFuelOilSale> dailyFuelOilSales = fuelOilSaleHelper.getByDailySaleIsNull();
        double totalFuelOilSale = fuelOilSaleHelper.totalFuelOilSales(dailyFuelOilSales);

        List<ForwardSale> forwardSales = forwardSaleHelper.getByDailySaleIsNull();
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

        List<EmployeePayment> employeePayments = employeePaymentHelper.getByDailySaleIsNull();
        double totalEmployeePayment = employeePaymentHelper.totalEmployeePayment(employeePayments);

        List<FuelTankFill> fuelTankFills = fuelTankFillHelper.getByDailySaleIsNull();
        double totalFuelTankFill = fuelTankFillHelper.totalFuelTankFill(fuelTankFills);

        List<FuelTankSale> fuelTankSales = fuelTankSaleHelper.getByDailySaleIsNull();
        double totalFuelTankSale = fuelTankSaleHelper.totalFuelTankSale(fuelTankSales);

        List<BankTransfer> bankTransfers = cashAndBankHelper.getByDailySaleIsNullBank();
        double totalBankTransfer = cashAndBankHelper.totalBankTransfer(bankTransfers);

        List<CashDelivery> cashDeliveries = cashAndBankHelper.getByDailySaleIsNullCash();
        double totalCash = cashAndBankHelper.totalCashDelivery(cashDeliveries);

        return mapperHelper.formatDoubleValue(
                (totalPosDeviceSale+ totalCash + totalBankTransfer + totalEmployeeExpense +totalDailyExpense  + totalFuelTankSale ) -
                        (totalCustomerPaymentsWithCashOrBankTransfer + totalCustomerPaymentsWithCreditCard +totalEmployeePayment ) -
                        (totalFuelOilSale - totalForwardSalesForForwardPrice - totalFuelTankFill)
        );
    }

    public Double reportZTotalBetweenDate(DateTimeRequest dateTimeRequest) {
        return dailySaleRepository.findTotalReportZBetweenDate(
                dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getStartDate()),
                dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getEndDate())
        );
    }
}
