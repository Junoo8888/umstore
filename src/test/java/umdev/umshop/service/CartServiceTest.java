package umdev.umshop.service;

import umdev.umshop.domain.Address;
import umdev.umshop.domain.Cart;
import umdev.umshop.domain.Member;
import umdev.umshop.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class CartServiceTest {

    @Autowired MemberService memberService;
    @Autowired ProductService productService;
    @Autowired CartService cartService;

    @Test
    @Transactional
    @Rollback(value = false)
    public void 상품_장바구니_담기_및_조회() throws Exception{
        //given

        Address address = new Address("서울", "서초", "123");

        Member member = new Member();
        member.setName("kim");
        member.setId("아이디");

        String saveId = memberService.join(member);
        Product product = new Product();
        product.setStock(100);
        product.setPrice(10000);
        product.setName("이것이 자바다");

        Long productId = productService.saveProduct(product);
        Product findProduct = productService.findOne(productId);

        int stock = 10;

        //when
        Long cartId = cartService.addCart(saveId, productId, stock);
        List<Cart> carts = cartService.findCarts(saveId);

        //the
        Assertions.assertThat(carts.size()).isEqualTo(1);


    }

}
