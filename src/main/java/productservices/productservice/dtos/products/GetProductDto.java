package productservices.productservice.dtos.products;

import lombok.Getter;
import lombok.Setter;
import productservices.productservice.models.Product;
@Getter
@Setter
public class GetProductDto {
    private Long id;;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    public static GetProductDto from(Product product) {
        GetProductDto getProductResponseDto = new GetProductDto();
        getProductResponseDto.setId(product.getId());
        getProductResponseDto.setTitle(product.getTitle());
        getProductResponseDto.setDescription(product.getDescription());
        getProductResponseDto.setPrice(product.getPrice());
        getProductResponseDto.setImageUrl(product.getImageUrl());
        return getProductResponseDto;

    }
}
