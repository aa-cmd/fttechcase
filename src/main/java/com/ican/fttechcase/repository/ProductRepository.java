package com.ican.fttechcase.repository;

import com.ican.fttechcase.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(
            value = "SELECT product_id FROM fttechdb.tbl_product WHERE product_name= ?1",
            nativeQuery = true
    )
    Long getProductIdByName(String productName);

    @Query(
            value = "SELECT product_id FROM fttechdb.tbl_product WHERE expiration_date < ?1",
            nativeQuery = true
    )
    List<Product> findExpiredProducts(LocalDateTime actualDate);

    @Query(
            value = "SELECT product_id FROM fttechdb.tbl_product WHERE (expiration_date >= ?1) OR (expiration_date = null)",
            nativeQuery = true
    )
    List<Product> findNonExpiredProducts(LocalDateTime actualDate);
}
