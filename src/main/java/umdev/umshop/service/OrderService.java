package umdev.umshop.service;

import umdev.umshop.domain.Member;
import umdev.umshop.domain.Order;
import umdev.umshop.domain.OrderItem;
import umdev.umshop.domain.Product;
import umdev.umshop.repository.MemberRepository;
import umdev.umshop.repository.OrderRepository;
import umdev.umshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    public Long order(String memberId, Long productId, int count){

        //엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Product product = productRepository.findOne(productId);

        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrder(product, product.getPrice(), count);

        //주문 생성
        Order order = Order.createOrder(member, orderItem);

        //주문 저장
        orderRepository.save(order);

        return order.getId();
    }

    public List<Order> findOrders(){
        return orderRepository.findOrders();
    }
}
