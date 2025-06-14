package productservices.productservice.dtos.products;

import lombok.Getter;
import lombok.Setter;
import productservices.productservice.models.Product;

@Getter
@Setter
public class CreateProductResponseDto {
    private Long id;;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    public static CreateProductResponseDto fromProduct(Product product) {
        CreateProductResponseDto responseDto = new CreateProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());
        return responseDto;
    }
}
