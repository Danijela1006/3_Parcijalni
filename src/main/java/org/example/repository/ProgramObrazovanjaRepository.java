package org.example.repository;

import org.example.domain.ProgramObrazovanja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramObrazovanjaRepository extends JpaRepository <ProgramObrazovanja, Long> {
}
