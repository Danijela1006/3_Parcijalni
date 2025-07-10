package org.example.mapper;

import org.example.domain.Polaznik;
import org.example.dto.PolaznikDto;

public interface PolaznikMapper {
    public PolaznikDto mapToPolaznikDto(Polaznik polaznik);
}
