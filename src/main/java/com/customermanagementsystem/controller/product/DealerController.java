package com.customermanagementsystem.controller.product;

import com.customermanagementsystem.payload.request.product.DealerRequest;
import com.customermanagementsystem.payload.response.product.DealerResponse;
import com.customermanagementsystem.service.product.DealerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/dealer")
@RequiredArgsConstructor
public class DealerController {

    private final DealerService dealerService;



    @PostMapping("/save")
    public ResponseEntity<String> saveDealer(@Valid @RequestBody DealerRequest dealerRequest){
        return ResponseEntity.ok(dealerService.saveDealer(dealerRequest));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<DealerResponse>> getAll(){
        return ResponseEntity.ok(dealerService.getAll());
    }
}
