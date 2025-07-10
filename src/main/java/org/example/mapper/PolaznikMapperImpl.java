package org.example.mapper;

import org.example.domain.Polaznik;
import org.example.dto.PolaznikDto;
import org.springframework.stereotype.Component;

@Component
public class PolaznikMapperImpl implements PolaznikMapper {

    @Override
    public PolaznikDto mapToPolaznikDto(Polaznik polaznik) {
        return new PolaznikDto (
                polaznik.getIme(),
                polaznik.getPrezime()
        );


    }
}
