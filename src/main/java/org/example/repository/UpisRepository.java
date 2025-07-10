package org.example.repository;

import org.example.domain.Upis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpisRepository extends JpaRepository <Upis, Long> {
}
