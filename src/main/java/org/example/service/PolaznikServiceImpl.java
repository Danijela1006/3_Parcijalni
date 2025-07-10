package org.example.service;

import org.example.domain.Polaznik;
import org.example.dto.PolaznikDto;
import org.example.mapper.PolaznikMapper;
import org.example.mapper.PolaznikMapperImpl;
import org.example.repository.PolaznikRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PolaznikServiceImpl implements PolaznikService {

    PolaznikRepository polaznikRepository;
    ModelMapper modelMapper;
    PolaznikMapper polaznikMapper;

    public PolaznikServiceImpl(PolaznikRepository polaznikRepository, ModelMapper modelMapper, PolaznikMapperImpl polaznikMapper) {
        this.polaznikRepository = polaznikRepository;
        this.modelMapper = modelMapper;
        this.polaznikMapper = polaznikMapper;
    }

    @Override
    public Optional<PolaznikDto> save(PolaznikDto polaznikDto) {
        Polaznik polaznik = modelMapper.map(polaznikDto, Polaznik.class);
        Polaznik savedPolaznik = polaznikRepository.save(polaznik);

        return Optional.of(modelMapper.map(savedPolaznik, PolaznikDto.class));
    }

    @Override
    public List<PolaznikDto> getAllPolaznik() {
        List<Polaznik> polaznici = polaznikRepository.findAll();
        return polaznici.stream().map(polaznik -> polaznikMapper.mapToPolaznikDto(polaznik)).collect(Collectors.toList());
    }

    @Override
    public Optional<PolaznikDto> findById(Long polaznikID) {
        Polaznik polaznik = polaznikRepository.findById(polaznikID).orElseThrow();
        return Optional.of(polaznikMapper.mapToPolaznikDto(polaznik));
    }

    @Override
    public Optional<PolaznikDto> updatePolaznik(Long polaznikId, PolaznikDto polaznikDto) {
        Optional<Polaznik> polaznik = polaznikRepository.findById(polaznikId);

        if (polaznik.isPresent()) {
            Polaznik polaznikToUpdate = polaznik.get();
            polaznikToUpdate.setIme(polaznikDto.getIme());
            polaznikToUpdate.setPrezime(polaznikDto.getPrezime());

            Polaznik updatedPolaznik = polaznikRepository.save(polaznikToUpdate);
            return Optional.of(polaznikMapper.mapToPolaznikDto(updatedPolaznik));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void deletePolaznik(Long polaznikId) {
        Optional<Polaznik> hardwareOptional = polaznikRepository.findById(polaznikId);
        hardwareOptional.ifPresent(polaznikRepository::delete);
    }
}
