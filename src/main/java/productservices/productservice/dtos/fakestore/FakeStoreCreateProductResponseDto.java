package productservices.productservice.dtos.fakestore;

import lombok.Getter;
import lombok.Setter;
import productservices.productservice.models.Product;

@Getter
@Setter
public class FakeStoreCreateProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public Product toProduct(FakeStoreCreateProductResponseDto responseDto){
        Product product1=new Product();
        product1.setId(responseDto.getId());
        product1.setTitle(responseDto.getTitle());
        product1.setDescription(responseDto.getDescription());
        product1.setCategoryName(responseDto.getCategory());
        product1.setImageUrl(responseDto.getImage());
        product1.setDescription(responseDto.getDescription());
        product1.setPrice(responseDto.getPrice());
        return product1;
    }
}
