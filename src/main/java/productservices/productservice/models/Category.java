package productservices.productservice.models;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.*;
@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
    private String description;
    @OneToMany
    private List<Product> featuredProducts;
    @OneToMany(mappedBy = "category")  //category attribute of the product class already represented this, no need to anything
    private List<Product> allProducts;
}
