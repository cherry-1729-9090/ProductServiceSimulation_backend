package com.example.fsphc.Controllers;

import com.example.productservice_dc_05.models.products;
import com.example.productservice_dc_05.service.FakeStoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class product_controller {

    private static final Logger logger = Logger.getLogger(product_controller.class.getName());

    @Autowired
    FakeStoreProductService service;

    public product_controller(FakeStoreProductService service){
        this.service = service;
    }

    @GetMapping("/products/{id}")
    public products getProductById(@PathVariable("id") Long id){
        logger.info("Fetching product with id: " + id);
        Optional<products> product = service.getProductById(id);
        if(product.isPresent()){
            return product.get();
        } else {
            logger.warning("Product not found with id: " + id);
            return null; // Alternatively, throw an exception or return a ResponseEntity with a 404 status
        }
    }

    @GetMapping("/products")
    public ArrayList<products> getAllProducts(){
        logger.info("Fetching all products");
        return service.getAllProducts();
    }

    @PostMapping("/products")
    public products createProduct(@RequestBody products newProduct){
        logger.info("Creating new product: " + newProduct.getName());
        return service.createProduct(newProduct);
    }

    @PutMapping("/products/{id}")
    public products updateProduct(@PathVariable("id") Long id, @RequestBody products updatedProduct){
        logger.info("Updating product with id: " + id);
        return service.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        logger.info("Deleting product with id: " + id);
        if(service.deleteProduct(id)){
            return "Product deleted successfully.";
        } else {
            logger.warning("Failed to delete product with id: " + id);
            return "Product not found.";
        }
    }

    @GetMapping("/products/category/{category}")
    public ArrayList<products> getProductsByCategory(@PathVariable("category") String category){
        logger.info("Fetching products in category: " + category);
        return service.getProductsByCategory(category);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        logger.severe("An error occurred: " + e.getMessage());
        return e.getMessage();
    }
}
