package com.customermanagementsystem.controller.dailysale.posdevice;

import com.customermanagementsystem.payload.request.dailysale.posdevice.PosDeviceRequest;
import com.customermanagementsystem.payload.response.dailysale.posdevice.PosDeviceResponse;
import com.customermanagementsystem.service.dailysale.posdevice.PosDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/posDevice")
@RequiredArgsConstructor
public class PosDeviceController {

    private final PosDeviceService posDeviceService;

    @PostMapping("/save")
    public ResponseEntity<String> savePosDevice(@Valid @RequestBody PosDeviceRequest posDeviceRequest){

        return ResponseEntity.ok(posDeviceService.savePosDevice(posDeviceRequest));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<PosDeviceResponse>> getAll(){
        return ResponseEntity.ok(posDeviceService.getAll());
    }
}
