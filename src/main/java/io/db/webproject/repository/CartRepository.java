package io.db.webproject.repository;

import io.db.webproject.entities.cart;
import io.db.webproject.entities.goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CartRepository extends JpaRepository<cart, Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO pc_store.cart (goodid, name , count, price)\n" +
            "SELECT goodid, good_name, 1, price\n" +
            "FROM pc_store.goods\n" +
            "WHERE goodid = ?1 \n" +
            "ON CONFLICT (goodid) DO UPDATE\n" +
            "SET count = pc_store.cart.count + 1",
            nativeQuery = true)
    void addToCart(int goodid);
    @Transactional
    @Modifying
    @Query(value = "UPDATE pc_store.cart SET count = count - 1 WHERE id = ?1", nativeQuery = true)
    void DeleteFromCart(int id);
}
