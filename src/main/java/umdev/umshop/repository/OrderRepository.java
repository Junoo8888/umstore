package umdev.umshop.repository;

import umdev.umshop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order){
        em.persist(order);
    }

    public List<Order> findOrders(){
        return em.createQuery("select o from Order", Order.class)
                .getResultList();
    }
}
