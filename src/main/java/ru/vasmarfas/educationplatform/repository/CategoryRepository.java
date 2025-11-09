package ru.vasmarfas.educationplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vasmarfas.educationplatform.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
