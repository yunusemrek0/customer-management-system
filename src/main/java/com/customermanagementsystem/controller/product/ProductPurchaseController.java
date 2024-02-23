package com.customermanagementsystem.controller.product;

import com.customermanagementsystem.payload.request.product.ProductPurchaseRequest;
import com.customermanagementsystem.payload.response.customer.ForwardSaleResponse;
import com.customermanagementsystem.payload.response.product.ProductPurchaseResponse;
import com.customermanagementsystem.service.product.ProductPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/productPurchase")
@RequiredArgsConstructor
public class ProductPurchaseController {

    private final ProductPurchaseService productPurchaseService;


    @PostMapping("/save")
    public ResponseEntity<String> saveProductPurchase(@Valid @RequestBody
                                                      ProductPurchaseRequest productPurchaseRequest){

        return ResponseEntity.ok(productPurchaseService.saveProductPurchase(productPurchaseRequest));
    }


    @GetMapping("/getByDealer/{dealerId}")
    public ResponseEntity<List<ProductPurchaseResponse>> getByDealer(@PathVariable Long dealerId){
        return ResponseEntity.ok(productPurchaseService.getByDealer(dealerId));
    }

    @GetMapping("/getByProduct/{productId}")
    public ResponseEntity<List<ProductPurchaseResponse>> getByProduct(@PathVariable Long productId){
        return ResponseEntity.ok(productPurchaseService.getByProduct(productId));
    }
}
