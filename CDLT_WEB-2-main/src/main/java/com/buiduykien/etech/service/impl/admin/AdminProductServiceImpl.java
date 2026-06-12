package com.buiduykien.etech.service.impl.admin;

import com.buiduykien.etech.entity.Product;
import com.buiduykien.etech.exception.ResourceNotFoundException;
import com.buiduykien.etech.repository.ProductRepository;
import com.buiduykien.etech.service.admin.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AdminProductServiceImpl implements AdminProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sản phẩm có ID: " + id));
    }

    @Override
    @Transactional
    public Product createProduct(Product product) {
        // Đảm bảo thiết lập mối quan hệ 2 chiều cho các biến thể trước khi lưu
        if (product.getVariants() != null) {
            product.getVariants().forEach(variant -> variant.setProduct(product));
        }
        return productRepository.save(product); // THÊM MỚI
    }

    @Override
    @Transactional
    public Product updateProduct(Long id, Product productDetails) {
        Product existingProduct = getProductById(id);
        
        // SỬA thông tin cốt lõi
        existingProduct.setName(productDetails.getName());
        existingProduct.setBrand(productDetails.getBrand());
        existingProduct.setDescription(productDetails.getDescription());
        
        return productRepository.save(existingProduct);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product); // XÓA
    }
}
