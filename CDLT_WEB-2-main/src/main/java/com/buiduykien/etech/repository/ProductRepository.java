package com.buiduykien.etech.repository;

import com.buiduykien.etech.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // TRUY VẤN: Tìm kiếm sản phẩm theo tên hoặc thương hiệu (Phục vụ bộ lọc tìm kiếm)
    List<Product> findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(String name, String brand);

    // TRUY VẤN NÂNG CAO: Lọc sản phẩm có giá biến thể nằm trong khoảng min - max
    @Query("SELECT DISTINCT p FROM Product p JOIN p.variants v WHERE v.price BETWEEN :minPrice AND :maxPrice")
    List<Product> filterByPriceRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);
}
