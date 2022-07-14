package io.db.webproject.repository;

import io.db.webproject.entities.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

    @Query(value = "SELECT m.manufactur_id, m.manufactur_name, m.category_id\n" +
            "FROM pc_store.manufacturer m\n" +
            "JOIN pc_store.goods g on m.manufactur_id = g.manufactur_id and m.category_id = g.category_id\n" +
            "where m.category_id = ?1",
            nativeQuery = true)
    Iterable<Manufacturer> findByCategoryId(int cat_id);

}
