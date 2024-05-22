package com.customermanagementsystem.repository.customer;

import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ForwardSaleRepository extends JpaRepository<ForwardSale,Long> {

    List<ForwardSale> getByCustomerId(Long customerId);

    List<ForwardSale> getByDailySaleIsNull();

    @Query("SELECT SUM(f.total) FROM ForwardSale f WHERE f.dateTime > :startDate AND f.dateTime < :endDate")
    Double findTotalForwardSaleBetweenDate(LocalDateTime startDate,LocalDateTime endDate);

    @Query("SELECT f.customer.id, f.customer.name, SUM(f.amount), SUM(f.total) " +
            "FROM ForwardSale f " +
            "WHERE f.dateTime > :startDate AND f.dateTime < :endDate AND f.customer.id IN(121,129) " +
            "GROUP BY f.customer.id, f.customer.name")
    List<Object[]> findAdBlueAndVehicleMatic(LocalDateTime startDate, LocalDateTime endDate);
}
