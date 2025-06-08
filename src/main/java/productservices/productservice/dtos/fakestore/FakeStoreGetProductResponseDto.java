package productservices.productservice.dtos.fakestore;

import lombok.Getter;
import lombok.Setter;
import productservices.productservice.models.Product;

@Getter
@Setter
public class FakeStoreGetProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public Product toProduct(){
        Product product1=new Product();
        product1.setId(this.getId());
        product1.setTitle(this.getTitle());
        product1.setDescription(this.getDescription());
        product1.setCategoryName(this.getCategory());
        product1.setImageUrl(this.getImage());
        product1.setDescription(this.getDescription());
        product1.setPrice(this.getPrice());
        return product1;
    }
}
