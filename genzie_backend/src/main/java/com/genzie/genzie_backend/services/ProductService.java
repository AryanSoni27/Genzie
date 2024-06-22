package com.genzie.genzie_backend.services;

import com.genzie.genzie_backend.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product saveOrUpdateProduct(Product product);
    void deleteProduct(Long id);
}
