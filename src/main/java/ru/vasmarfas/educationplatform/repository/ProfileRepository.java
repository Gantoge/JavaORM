package ru.vasmarfas.educationplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vasmarfas.educationplatform.entity.UserProfile;

@Repository
public interface ProfileRepository extends JpaRepository<UserProfile, Long> {
}
