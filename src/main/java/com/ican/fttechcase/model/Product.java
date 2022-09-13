package com.ican.fttechcase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Table(name = "tbl_product")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
//    @SequenceGenerator(
//            name = "product_sequence",
//            sequenceName = "product_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "product_sequence"
//    )
    private Long productId;
    private String productName;
    private Double price;
    private LocalDateTime expirationDate;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "productId"
    )
    private List<ProductComment> comments;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "user_product_map",
            joinColumns = @JoinColumn(
                    name = "product_id",
                    referencedColumnName = "productId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "userId"
            )
    )
    private List<User> users;

    public void addUsers(User user) {
        if (users == null) users = new ArrayList<>();
        users.add(user);
    }
}
