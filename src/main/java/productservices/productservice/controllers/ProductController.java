package productservices.productservice.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import productservices.productservice.dtos.ErrorResponseDto;
import productservices.productservice.dtos.products.*;
import productservices.productservice.models.Product;
import productservices.productservice.services.ProductService;

import java.util.ArrayList;
import java.util.List;

//RestController special annotation that make a class able to receive request from dispatcher servlet
@RestController
@RequestMapping("/products")
public class ProductController {
  private ProductService productService;

//  @Value("fakeStoreProductService")
//  private String productServiceType;

  public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
      this.productService = productService;
  }

//    @PostMapping("/products/")
    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
      Product product= productService.createProduct(createProductRequestDto.toProduct());
      return CreateProductResponseDto.fromProduct(product);
    }

    @GetMapping("")
    public GetAllProductsResponseDto getAllProducts() {
       List<Product> products=productService.getAllProducts();
       GetAllProductsResponseDto response = new GetAllProductsResponseDto();
       List<GetProductDto> getProductResponseDtos=new ArrayList<>();

       for(Product product:products){
           getProductResponseDtos.add(GetProductDto.from(product));
       }
         response.setProducts(getProductResponseDtos);
       return response;
    }

    @GetMapping("/{id}")
    public void getSingleProduct(@PathVariable("id") Long id) {

    }

    @DeleteMapping( "/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

    }

    @PatchMapping("/id")
    public PatchProductResponseDto updateProduct(@PathVariable("id") Long productId, @RequestBody CreateProductDto productDto) {  //patch
          Product product=productService.partialUpdateProduct(productId,productDto.toProduct());

          PatchProductResponseDto response=new PatchProductResponseDto();
          response.setProduct(GetProductDto.from(product));
          return response;
    }
    public void replaceProduct() {   //put

    }

//    @ExceptionHandler(RuntimeException.class)
//    public ErrorResponseDto handleException(RuntimeException e) {
//        ErrorResponseDto dto=new ErrorResponseDto();
//        dto.setMessage(e.getMessage());
//        dto.setStatus("ERROR");
//        return dto;
//    }
}

//controller advices gave additional filtration that may change the controller response,