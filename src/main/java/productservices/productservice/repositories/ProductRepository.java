package productservices.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import productservices.productservice.models.Category;
import productservices.productservice.models.Product;

public interface ProductRepository extends JpaRepository<Category,Long> {

}
