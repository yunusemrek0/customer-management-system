package com.customermanagementsystem.controller.product;

import com.customermanagementsystem.payload.request.product.ProductRequest;
import com.customermanagementsystem.payload.response.product.ProductResponse;
import com.customermanagementsystem.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(@Valid @RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(productService.saveProduct(productRequest));
    }


    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@Valid @RequestBody ProductRequest productRequest,
                                                @PathVariable Long id){
        return ResponseEntity.ok(productService.updateProduct(productRequest,id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<ProductResponse>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getById(id));
    }
}
