package org.example.repository;

import org.example.domain.Polaznik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PolaznikRepository extends JpaRepository <Polaznik, Long> {
    Optional<Object> findByCode(String code);
}
