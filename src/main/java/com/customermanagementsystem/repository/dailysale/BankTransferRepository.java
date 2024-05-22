package com.customermanagementsystem.repository.dailysale;

import com.customermanagementsystem.entity.dailysale.BankTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankTransferRepository extends JpaRepository<BankTransfer,Long> {

    List<BankTransfer> getByDailySaleIsNull();
}
