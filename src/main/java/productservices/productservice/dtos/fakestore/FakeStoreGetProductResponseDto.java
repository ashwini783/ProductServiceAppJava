package productservices.productservice.dtos.fakestore;

import lombok.Getter;
import lombok.Setter;
import productservices.productservice.models.Category;
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
        Category category=new Category();
        category.setName(this.getCategory());
        product1.setCategory(category);
        product1.setImageUrl(this.getImage());
        product1.setDescription(this.getDescription());
        product1.setPrice(this.getPrice());
        return product1;
    }
}
