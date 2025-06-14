package productservices.productservice.dtos.products;

import lombok.Getter;
import lombok.Setter;
import productservices.productservice.models.Category;
import productservices.productservice.models.Product;
@Getter
@Setter
public class CreateProductDto {
    private Long id;;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;

    public static CreateProductDto fromProduct(Product product) {
        CreateProductDto responseDto = new CreateProductDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());
        return responseDto;
    }
    public Product toProduct(){
        Product product= new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        Category category= new Category();
        category.setName(this.categoryName);
        product.setCategory(category);
        return product;

    }
}
