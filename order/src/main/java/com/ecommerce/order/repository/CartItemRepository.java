package com.ecommerce.order.repository;

import com.ecommerce.order.models.CartItem;
//import com.ecommerce.order.models.Product;
//import com.ecommerce.order.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByUserIdAndProductId(String userId , String productId);

    void deleteByUserIdAndProductId(String userId , String productId);

    List<CartItem> findByUserId(String userId);

//    void deleteByUser(User user, Object o);

    void deleteByUserId(String userId);
}
