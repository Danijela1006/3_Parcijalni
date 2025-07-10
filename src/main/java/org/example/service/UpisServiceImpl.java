package org.example.service;

import org.example.dto.UpisDto;
import org.example.repository.UpisRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UpisServiceImpl implements UpisService {
    UpisRepository upisRepository;
    ModelMapper modelMapper;

    public UpisServiceImpl(UpisRepository springDataUpisRepository, ModelMapper modelMapper) {
        this.upisRepository = springDataUpisRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UpisDto> getAllUpisi() {
        return upisRepository.findAll().stream()
                .map(upis -> modelMapper.map(upis, UpisDto.class))
                .collect(Collectors.toList());
    }
}
