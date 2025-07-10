package org.example.service;

import org.example.dto.PolaznikDto;

import java.util.List;
import java.util.Optional;

public interface PolaznikService {
    Optional<PolaznikDto> save(PolaznikDto polaznikDto);

    List<PolaznikDto> getAllPolaznik();

    Optional<PolaznikDto> findById(Long polaznikID);

    Optional<PolaznikDto> updatePolaznik(Long polaznikId, PolaznikDto polaznikDto);

    void deletePolaznik(Long polaznikId);
}
