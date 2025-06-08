package productservices.productservice.dtos.fakestore;

import lombok.Getter;
import lombok.Setter;
import productservices.productservice.models.Product;

@Getter
@Setter
public class FakeStoreCreateProductRequestDto {
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public static FakeStoreCreateProductRequestDto fromProduct(Product product) {
        FakeStoreCreateProductRequestDto dto=new FakeStoreCreateProductRequestDto();
        dto.title=product.getTitle();
        dto.description=product.getDescription();
        dto.category=product.getCategoryName();
        dto.price=product.getPrice();
        dto.image=product.getImageUrl();
        return dto;
    }
}
//this Dto is create to map request body coming via postman and request body of 3rd party