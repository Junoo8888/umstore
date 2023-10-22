package umdev.umshop.service;

import umdev.umshop.domain.Product;
import umdev.umshop.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ProductServiceTest {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @Test
    @Rollback(value = false)
    public void saveProductTest() throws Exception{
        //given
        Product product = new Product();
        product.setName("책1");
        product.setStock(10);
        product.setPrice(10000);

        //when
        Long saveId = productService.saveProduct(product);

        //then
        Assertions.assertThat(product.getId()).isEqualTo(saveId);
    }

    @Test
    public void 상품조회() throws Exception{
        //given

        //when

        //then
    }

}
