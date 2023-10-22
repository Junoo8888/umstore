package umdev.umshop.service;

import umdev.umshop.domain.Cart;
import umdev.umshop.domain.CartProduct;
import umdev.umshop.domain.Member;
import umdev.umshop.domain.Product;
import umdev.umshop.repository.CartRepository;
import umdev.umshop.repository.MemberRepository;
import umdev.umshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;


    public Long addCart(String memberId, Long productId, int quantity){

        // 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Product product = productRepository.findOne(productId);

        //카트 상품 생성
        CartProduct cartProduct = CartProduct.createCartProduct(product, quantity);

        //카트 생성
        Cart cart = Cart.createCart(member, cartProduct);

        //카트 저장
        cartRepository.save(cart);

        return cart.getId();
    }

    public List<Cart> findCarts(String memberId){
        return cartRepository.findCarts(memberId);
    }

}
