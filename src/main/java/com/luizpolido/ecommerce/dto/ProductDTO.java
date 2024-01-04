package com.luizpolido.ecommerce.dto;


import com.luizpolido.ecommerce.entities.Product;
import lombok.*;

@Data
@Setter(AccessLevel.NONE)
@AllArgsConstructor
public class ProductDTO {

    private long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    public ProductDTO(Product product){
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
    }
}
