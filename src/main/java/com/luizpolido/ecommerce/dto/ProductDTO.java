package com.luizpolido.ecommerce.dto;


import com.luizpolido.ecommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Setter(AccessLevel.NONE)
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    @Size(min = 3 , max = 80 , message = "Name requires 3-80 characters")
    @NotBlank
    private String name;

    @Size(min = 10 , message = "Description requires at least 10 characters")
    @NotBlank
    private String description;

    @Positive(message = "The price must been positive")
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
