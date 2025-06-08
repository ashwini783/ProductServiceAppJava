package productservices.productservice.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import productservices.productservice.dtos.fakestore.FakeStoreCreateProductRequestDto;
import productservices.productservice.dtos.fakestore.FakeStoreCreateProductResponseDto;
import productservices.productservice.dtos.fakestore.FakeStoreGetProductResponseDto;
import productservices.productservice.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service("fakeStoreProductService")
//@Primary
public class ProductServiceFakeStoreImpl implements ProductService {


    private RestTemplate restTemplate;   //to call third party APIs's

    //bean of the RestTemplate class by default doesn't exist, we have to create bean of RestTemplate class so that spring can anywhere autowire it
    public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto requestDto = new FakeStoreCreateProductRequestDto();

        requestDto.setTitle(product.getTitle());
        requestDto.setDescription(product.getDescription());
        requestDto.setCategory(product.getCategoryName());
        requestDto.setImage(product.getImageUrl());
        requestDto.setPrice(product.getPrice());
        FakeStoreCreateProductResponseDto responseDto = restTemplate.postForObject("https://fakestoreapi.com/products", requestDto, FakeStoreCreateProductResponseDto.class);
        return responseDto.toProduct(responseDto);
//         Product product1=new Product();
//         product1.setTitle(responseDto.getId());
//         product1.setDescription(responseDto.getDescription());
//         product1.setCategoryName(responseDto.getCategory());
//         product1.setImageUrl(responseDto.getImage());
//         product1.setDescription(product.getDescription());
//         product1.setPrice(responseDto.getPrice());
//         return product1;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreGetProductResponseDto[] response = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreGetProductResponseDto[].class);
        List<FakeStoreGetProductResponseDto> responseDtos = Stream.of(response).toList();

        List<Product> products = new ArrayList<>();
        for (FakeStoreGetProductResponseDto fakeStoreGetProductResponseDto : responseDtos) {
            products.add(fakeStoreGetProductResponseDto.toProduct());
        }


        return products;
    }

    @Override
    public Product partialUpdateProduct(Long productId, Product product) {
        HttpEntity<FakeStoreCreateProductRequestDto> requestEntity=new HttpEntity<>(FakeStoreCreateProductRequestDto.fromProduct(product)) ;
        ResponseEntity<FakeStoreGetProductResponseDto> responseEntity = restTemplate.exchange("https://fakestoreapi.com/products" + productId,HttpMethod.PATCH,requestEntity, FakeStoreGetProductResponseDto.class);
       return responseEntity.getBody().toProduct();
    }

}
