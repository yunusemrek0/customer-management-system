package com.customermanagementsystem.controller.dailysale.posdevice;

import com.customermanagementsystem.payload.request.dailysale.posdevice.PosDeviceSaleRequest;
import com.customermanagementsystem.payload.response.dailysale.posdevice.PosDeviceSaleResponse;
import com.customermanagementsystem.service.dailysale.posdevice.PosDeviceSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/posDeviceSale")
@RequiredArgsConstructor
public class PosDeviceSaleController {

    private final PosDeviceSaleService posDeviceSaleService;

    @PostMapping("/save")
    public ResponseEntity<String> savePosDeviceSale(@Valid @RequestBody PosDeviceSaleRequest posDeviceSaleRequest){

        return ResponseEntity.ok(posDeviceSaleService.savePosDeviceSale(posDeviceSaleRequest));
    }


    @GetMapping("/findByDateTimes")
    public ResponseEntity<List<PosDeviceSaleResponse>> getByDateTimes(
            @RequestParam("startDateTime") String startDateTime,
            @RequestParam("endDateTime") String endDateTime
            ){

        return ResponseEntity.ok(posDeviceSaleService.findByDateTime(startDateTime,endDateTime));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PosDeviceSaleResponse>> getAll(){
        return ResponseEntity.ok(posDeviceSaleService.getAll());
    }


}
