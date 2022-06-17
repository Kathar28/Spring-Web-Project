package io.db.webproject.repository;

import io.db.webproject.entities.category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<category, Integer> {
}
