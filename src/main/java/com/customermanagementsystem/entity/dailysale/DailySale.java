package com.customermanagementsystem.entity.dailysale;

import com.customermanagementsystem.entity.customer.CustomerPayment;
import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import com.customermanagementsystem.entity.dailysale.posdevice.PosDeviceSale;
import com.customermanagementsystem.entity.employee.EmployeeExpense;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "daily_sale")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DailySale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    private Double reportZ;

    @OneToMany(mappedBy = "dailySale")
    private List<DailyFuelOilSale> dailyFuelOilSales;

    private Double totalFuelOilSales;

    private Double totalFuelOilSalesAsPurchasePrice;

    private Double totalCash;

    private Double bankTransferTotal;


    @OneToMany(mappedBy = "dailySale")
    private List<ForwardSale> forwardSales;

    private Double totalForwardSalesForCashPrice;

    private Double totalForwardSalesForForwardPrice;


    @OneToMany(mappedBy = "dailySale")
    private List<CustomerPayment> customerPayments;

    private Double totalCustomerPaymentsWithCash;

    private Double totalCustomerPaymentsWithCreditCard;

    @OneToMany(mappedBy = "dailySale")
    private List<EmployeeExpense> employeeExpenses;

    private Double totalEmployeeExpense;

    @OneToMany(mappedBy = "dailySale")
    private List<PosDeviceSale> posDeviceSales;

    private Double totalPosDeviceSale;

    private Double balance;

    private Double totalIncome;
}
