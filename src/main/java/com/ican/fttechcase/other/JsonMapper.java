package com.ican.fttechcase.other;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JsonMapper {
    private Long userId;
    private String userName;
    private String userSurName;
    private String userEmail;
    private String userPhone;

    private Long productId;
    private String productName;
    private Double productPrice;
    private String productExpirationDate;

    private String comment;
    private String commentDate;
}
