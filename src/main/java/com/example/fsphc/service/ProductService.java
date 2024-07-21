package com.example.fsphc.service;

import com.example.productservice_dc_05.models.products;

import java.util.ArrayList;

public interface ProductService {
    public products getProductById(Long id);
    public ArrayList<products> getAllProducts();
}
