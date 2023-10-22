package umdev.umshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Cart {

    @Id @GeneratedValue
    @Column(name = "cart_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartProduct> cartProducts = new ArrayList<>();

    // == 연관관계 편의 메서드 ==//
    public void addCartProduct(CartProduct cartProduct){
        cartProducts.add(cartProduct);
        cartProduct.setCart(this);
    }


    /**
     * 생성 메서드
     * */
    public static Cart createCart(Member member, CartProduct... cartProducts){
        Cart cart = new Cart();
        cart.setMember(member);
        for (CartProduct cartProduct : cartProducts) {
            cart.addCartProduct(cartProduct);
        }
        return cart;
    }


}
