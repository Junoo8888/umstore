package umdev.umshop.api;

import umdev.umshop.domain.Product;
import umdev.umshop.dto.ProductDto;
import umdev.umshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/api/addProduct")
    public ProductDto addProduct(@RequestBody ProductDto productDto){

        Product product = new Product();
        product.setName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());

        Long id = productService.saveProduct(product);
        Product findProduct = productService.findOne(id);

        return new ProductDto(product);
    }

    @GetMapping("/api/updateProduct/{productId}")
    public ProductDto updateProductForm(@PathVariable("productId") Long id){
        Product product = productService.findOne(id);
        return new ProductDto(product);
    }

    @PutMapping("/api/updateProduct/{productId}")
    public ProductDto updateProduct(@PathVariable("productId") Long id,
                                    @RequestBody ProductDto productDto){
        productService.updateProduct(id, productDto);
        Product product = productService.findOne(id);
        return new ProductDto(product);
    }

    @GetMapping("/api/listProduct")
    public List<ProductDto> listProduct(){
        List<Product> products = productService.findProducts();
        List<ProductDto> result = products.stream()
                .map( p -> new ProductDto(p))
                .collect(Collectors.toList());
        return result;
    }

}
