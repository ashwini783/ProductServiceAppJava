package productservices.productservice.services;

import org.springframework.stereotype.Service;
import productservices.productservice.models.Product;

import java.util.List;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService {
    @Override
    public Product createProduct(Product product) {
     return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product partialUpdateProduct(Long productId,Product product) {
        return null;
    }


}
