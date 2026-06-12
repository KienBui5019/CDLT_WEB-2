package com.buiduykien.etech.service.admin;

import com.buiduykien.etech.entity.Product;
import java.util.List;

public interface AdminProductService {
    List<Product> getAllProducts();          // TRUY VẤN
    Product getProductById(Long id);         // TRUY VẤN
    Product createProduct(Product product);   // THÊM
    Product updateProduct(Long id, Product productDetails); // SỬA
    void deleteProduct(Long id);             // XÓA
}
