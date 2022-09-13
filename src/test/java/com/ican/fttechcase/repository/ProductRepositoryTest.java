package com.ican.fttechcase.repository;

import com.ican.fttechcase.model.Product;
import com.ican.fttechcase.model.ProductComment;
import com.ican.fttechcase.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    ProductComment commentA = ProductComment.builder()
            .comment("Comment A")
            .commentDate(LocalDateTime.of(2017, Month.DECEMBER, 17, 15, 45))
            .build();

    ProductComment commentB = ProductComment.builder()
            .comment("Comment B")
            .commentDate(LocalDateTime.of(2018, Month.JULY, 12, 14, 30))
            .build();


    ProductComment commentC = ProductComment.builder()
            .comment("Comment C")
            .commentDate(LocalDateTime.of(2001, Month.OCTOBER, 16, 10, 11))
            .build();

    ProductComment commentD = ProductComment.builder()
            .comment("Comment D")
            .commentDate(LocalDateTime.of(2003, Month.MARCH, 9, 22, 30))
            .build();

    ProductComment commentE = ProductComment.builder()
            .comment("Comment E")
            .commentDate(LocalDateTime.of(2001, Month.OCTOBER, 16, 10, 11))
            .build();

    ProductComment commentF = ProductComment.builder()
            .comment("Comment F")
            .commentDate(LocalDateTime.of(2003, Month.MARCH, 9, 22, 30))
            .build();

//    @Test
//    public void saveUser() {
//        User userA = User.builder()
//                .name("Cevdet")
//                .surName("Kara")
//                .comments(Arrays.asList(commentC, commentD))
//                .email("cevdet@example.com")
//                .phone("123456789")
//                .build();
//        userRepository.save(userA);
//    }
//
//    @Test
//    public void saveProduct() {
//        Product product = Product.builder()
//                .productName("melon")
//                .price(12.00)
//                .expirationDate(LocalDateTime.of(2016, Month.JULY, 15, 12, 30))
//                .comments(Arrays.asList(commentA, commentB))
//                .build();
//
//        productRepository.save(product);
//    }



    @Test
    public void saveCommentWithUserAndProduct(){

        Product product1 = Product.builder()
                .productId(15L)
                .productName("melon")
                .price(12.00)
                .comments(Arrays.asList(commentA, commentB))
                .expirationDate(LocalDateTime.of(2016, Month.JULY, 15, 12, 30))
                .build();

        User user1 = User.builder()
                .userId(25L)
                .name("Kerim")
                .surName("Sera")
                .comments(Arrays.asList(commentA, commentB))
                .email("kerim@example.com")
                .phone("123456789")
                .build();

        product1.addUsers(user1);
        productRepository.save(product1);

        Product product2 = Product.builder()
                .productId(17L)
                .productName("onion")
                .price(18.00)
                .comments(Arrays.asList(commentC, commentD))
                .expirationDate(LocalDateTime.of(2014, Month.JUNE, 08, 14, 30))
                .build();

        User user2 = User.builder()
                .userId(32L)
                .name("Cevdet")
                .surName("Ozturk")
                .comments(Arrays.asList(commentC, commentD))
                .email("cevdet@example.com")
                .phone("555555555")
                .build();

        product2.addUsers(user2);
        productRepository.save(product2);

    }
}