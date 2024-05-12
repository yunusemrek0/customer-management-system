package com.customermanagementsystem.repository.customer;

import com.customermanagementsystem.entity.customer.forwardsale.LateCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LateChargeRepository extends JpaRepository<LateCharge,Long> {

    List<LateCharge> getByCustomerId(Long customerId);
}
