package io.db.webproject.repository;

import io.db.webproject.entities.goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GoodsRepository extends JpaRepository<goods, Integer> {

    @Query(value = "SELECT goodid, good_name, category_id, count, manufactur_id, price FROM pc_store.goods where category_id = ?1 ORDER BY goodid ASC ",
    nativeQuery = true)
    Iterable<goods> findGoodsByCategory_id(int cat_id);
    @Query(value = "SELECT goodid, good_name, category_id, count, manufactur_id, price FROM pc_store.goods where category_id = ?1 and manufactur_id = ?2 ORDER BY goodid ASC",
            nativeQuery = true)
    Iterable<goods> findgoodsByCategory_idAndManufacturd_id(int category_id, int manufactur_id);

}
