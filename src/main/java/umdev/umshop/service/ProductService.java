package umdev.umshop.service;

import umdev.umshop.domain.Product;
import umdev.umshop.dto.ProductDto;
import umdev.umshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Long saveProduct(Product product){
        productRepository.save(product);
        return product.getId();
    }

    public void updateProduct(Long id, ProductDto productDto){
        Product product = productRepository.findOne(id);
        product.setName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        System.out.println("product =>" + product);
    }

    public List<Product> findProducts(){
        return productRepository.findAll();
    }

    public Product findOne(Long productId){
        return productRepository.findOne(productId);
    }
}
