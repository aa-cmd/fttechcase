package com.ican.fttechcase.controller;

import com.ican.fttechcase.model.Product;
import com.ican.fttechcase.model.ProductComment;
import com.ican.fttechcase.model.User;
import com.ican.fttechcase.repository.ProductCommentRepository;
import com.ican.fttechcase.repository.ProductRepository;
import com.ican.fttechcase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductCommentRepository productCommentRepository;

    @PostMapping(value = "/saveProduct")
    public void saveProduct(@RequestBody Product product) {
        System.out.println("product is :" + product);
        productRepository.save(product);
    }


    @GetMapping("/getComments/{productName}")
    public List<ProductComment> getComments(@PathVariable String productName) {
        Optional<Long> optProductId = Optional.ofNullable(productRepository.getProductIdByName(productName));
        if (optProductId.isPresent()) {
            Optional<Product> product = productRepository.findById(optProductId.get());
            return product.get().getComments();
        } else {
            return null;
        }
    }

    @GetMapping("/getCommentsBtwDatesByProductId/{productId}/{startDate}/{endDate}")
    public List<ProductComment> getCommentsBtwDatesByProductId(@PathVariable Long productId,
                                                                 @PathVariable
                                                                 @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
                                                                 LocalDateTime startDate,
                                                                 @PathVariable
                                                                   @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
                                                                   LocalDateTime endDate) {
        Optional<Product> optProduct = productRepository.findById(productId);
        return optProduct.map(product -> productCommentRepository.getCommentsBtwDatesByProductId(productId,
                startDate, endDate)).orElse(null);
    }


    @GetMapping("/getCommentsByUserId/{userId}")
    public List<ProductComment> getCommentsByUserId(@PathVariable Long userId) {
        Optional<User> optUser = userRepository.findById(userId);
        return optUser.map(User::getComments).orElse(null);
    }


    @GetMapping("/getCommentsBtwDatesByUserId/{userId}/{startDate}/{endDate}")
    public List<ProductComment> getCommentsBtwDatesByUserId(@PathVariable Long userId,
                                                            @PathVariable
                                                            @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
                                                            LocalDateTime startDate,
                                                            @PathVariable
                                                                @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
                                                                LocalDateTime endDate) {
        Optional<User> optUser = userRepository.findById(userId);
        return optUser.map(user -> productCommentRepository.getCommentsBtwDatesByUserId(userId,
                startDate, endDate)).orElse(null);
    }

    @GetMapping("/getExpiredProducts")
    public List<Product> getExpiredProducts(){
        LocalDateTime actualDate = LocalDateTime.now();
        return productRepository.findExpiredProducts(actualDate);

    }

    @GetMapping("getNonExpiredProducts")
    public List<Product> getNonExpiredProducts(){
        LocalDateTime actualDate = LocalDateTime.now();
        return productRepository.findNonExpiredProducts(actualDate);
    }
}
