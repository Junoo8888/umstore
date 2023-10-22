package umdev.umshop.repository;

import umdev.umshop.domain.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CartRepository {

    private final EntityManager em;

    public void save(Cart cart){
        em.persist(cart);
    }

    public List<Cart> findAll(){
        return em.createQuery("select c from Cart c", Cart.class)
                .getResultList();
    }

    public List<Cart> findCarts(String memberId) {
        return em.createQuery("select c from Cart c join c.member m where m.id = :memberId", Cart.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
