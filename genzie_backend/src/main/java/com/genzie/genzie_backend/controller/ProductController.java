package com.genzie.genzie_backend.controller;

import com.genzie.genzie_backend.model.Product;
import com.genzie.genzie_backend.services.WebScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private WebScrapingService webScrapingService;

    @GetMapping("/api/products")
    public List<Product> getAllProducts() throws IOException {
        // Fetch products from various platforms
        List<Product> amazonProducts = webScrapingService.fetchProductsFromAmazon();
        // Similarly, fetch from other platforms

        // Combine all products
        List<Product> allProducts = new ArrayList<>();
        allProducts.addAll(amazonProducts);
        // Add products from other platforms

        return allProducts;
    }
}
