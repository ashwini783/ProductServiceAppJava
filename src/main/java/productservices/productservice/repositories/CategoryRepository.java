package productservices.productservice.repositories;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

public interface CategoryRepository extends JpaRepository<Product,Long> {

}
