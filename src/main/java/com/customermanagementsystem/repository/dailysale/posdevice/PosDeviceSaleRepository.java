package com.customermanagementsystem.repository.dailysale.posdevice;

import com.customermanagementsystem.entity.dailysale.posdevice.PosDeviceSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PosDeviceSaleRepository extends JpaRepository<PosDeviceSale,Long> {

    List<PosDeviceSale> findByDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
