package com.example.fsphc.Controllers;

import com.example.productservice_dc_05.models.products;
import com.example.productservice_dc_05.service.FakeStoreProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class product_controller {
    FakeStoreProductService service;
    public product_controller(FakeStoreProductService service){
        this.service = service;
    }
    @GetMapping("/products/{id}")
    public products getProductById(@RequestAttribute("id") Long id){
        return service.getProductById(id);
    }
    @GetMapping("/products")
    public ArrayList<products> getAllProducts(){
        return service.getAllProducts();
    }
}
