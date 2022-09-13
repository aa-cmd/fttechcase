package com.ican.fttechcase.controller;

import com.ican.fttechcase.model.Product;
import com.ican.fttechcase.model.ProductComment;
import com.ican.fttechcase.model.User;
import com.ican.fttechcase.other.JsonMapper;
import com.ican.fttechcase.repository.ProductCommentRepository;
import com.ican.fttechcase.repository.ProductRepository;
import com.ican.fttechcase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductCommentController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCommentRepository productCommentRepository;

    @PostMapping("/saveComment")
    public void saveComment(@RequestBody JsonMapper jsonMapper){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime commentDate = LocalDateTime.parse(jsonMapper.getCommentDate(), formatter);
        List<ProductComment> productComments = new ArrayList<>();

        ProductComment productComment = ProductComment.builder()
                .comment(jsonMapper.getComment())
                .commentDate(commentDate)
                .build();

        Optional<User> user = userRepository.findById(jsonMapper.getUserId());
        if(!user.isPresent()){
            userRepository.save(User.builder()
                    .name(jsonMapper.getUserName())
                    .surName(jsonMapper.getUserSurName())
                    .phone(jsonMapper.getUserPhone())
                    .userEmail(jsonMapper.getUserEmail())
                    .comments(productComments)
                    .build());
        }
        else
        {
            List<ProductComment> productComments1 = user.get().getComments();
            productComments1.add(productComment);
            user.get().setComments(productComments1);
            User user1 = user.get();
            userRepository.save(user1);
        }

        LocalDateTime expirationDate = LocalDateTime.parse(jsonMapper.getProductExpirationDate(), formatter);

        Optional<Product> product = productRepository.findById(jsonMapper.getProductId());
        if(!product.isPresent()){
            productRepository.save(Product.builder()
                    .productName(jsonMapper.getProductName())
                    .price(jsonMapper.getProductPrice())
                    .expirationDate(expirationDate)
                    .comments(productComments)
                    .build());
        }
        else
        {
            List<ProductComment> productComments1 = product.get().getComments();
            productComments1.add(productComment);
            product.get().setComments(productComments1);
            Product product1 = product.get();
            productRepository.save(product1);
        }
    }
}
