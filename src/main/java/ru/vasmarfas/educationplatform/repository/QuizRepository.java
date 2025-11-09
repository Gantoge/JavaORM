package ru.vasmarfas.educationplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vasmarfas.educationplatform.entity.Quiz;

import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Optional<Quiz> findByCourseModuleId(Long courseModuleId);
}
