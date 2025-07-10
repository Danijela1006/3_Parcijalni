package org.example.service;

import org.example.dto.ProgramObrazovanjaDto;
import org.example.repository.ProgramObrazovanjaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramObrazovanjaServiceImpl implements ProgramObrazovanjaService{

    ProgramObrazovanjaRepository programObrazovanjaRepository;
    ModelMapper modelMapper;

    public ProgramObrazovanjaServiceImpl(ProgramObrazovanjaRepository springDataProgramObrazovanjaRepository, ModelMapper modelMapper) {
        this.programObrazovanjaRepository = springDataProgramObrazovanjaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProgramObrazovanjaDto> getAllPorgramObrazovanja() {
        return programObrazovanjaRepository.findAll().stream()
                .map(program -> modelMapper.map(program, ProgramObrazovanjaDto.class))
                .collect(Collectors.toList());
    }
}
