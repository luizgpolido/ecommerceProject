package com.luizpolido.ecommerce.dto;


import lombok.*;

@Data
@Setter(AccessLevel.NONE)
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
}
