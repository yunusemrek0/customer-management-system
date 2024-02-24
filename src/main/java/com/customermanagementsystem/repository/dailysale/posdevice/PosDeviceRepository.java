package com.customermanagementsystem.repository.dailysale.posdevice;

import com.customermanagementsystem.entity.dailysale.posdevice.PosDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosDeviceRepository extends JpaRepository<PosDevice,Long> {
}
