package umdev.umshop.api;

import umdev.umshop.domain.Cart;
import umdev.umshop.domain.Product;
import umdev.umshop.dto.CartDto;
import umdev.umshop.dto.MemberDto;
import umdev.umshop.service.CartService;
import umdev.umshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CartApiController {

    private final CartService cartService;
    private final ProductService productService;

    /// 빈 CartDto 넘김
    @PostMapping("/api/addCart/{productId}/quantity")
    public CartDto addCart(@RequestBody MemberDto memberDto,
                           @PathVariable Long productId,
                           @PathVariable int quantity){

        Product product = productService.findOne(productId);
        Long cartId = cartService.addCart(memberDto.getMemberId(), productId, quantity);

        return new CartDto();
    }
/*
    @GetMapping("/api/myCart/{memberId}")
    public List<CartDto> myCart(@PathVariable String memberId){
        List<Cart> carts = cartService.findCarts(memberId);
        List<CartDto> findCart = carts.stream()
                .map( c -> new CartDto(c))
                .collect(Collectors.toList());
        return findCart;
    }*/
}