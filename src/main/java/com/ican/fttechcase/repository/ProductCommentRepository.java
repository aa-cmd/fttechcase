package com.ican.fttechcase.repository;

import com.ican.fttechcase.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {
    @Query(
            value = "SELECT * FROM fttechdb.tbl_comment WHERE product_id= ?1 AND (comment_date BETWEEN ?2 AND ?3)",
            nativeQuery = true
        )
    List<ProductComment> getCommentsBtwDatesByProductId(Long productId, LocalDateTime startDate, LocalDateTime endDate);

    @Query(
            value = "SELECT * FROM fttechdb.tbl_comment WHERE user_id= ?1 AND (comment_date BETWEEN ?2 AND ?3)",
            nativeQuery = true
    )
    List<ProductComment> getCommentsBtwDatesByUserId(Long userId, LocalDateTime startDate, LocalDateTime endDate);
}
