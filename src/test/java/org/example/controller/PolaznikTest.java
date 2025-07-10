package org.example.controller;

import org.example.dto.PolaznikDto;
import org.example.service.PolaznikService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PolaznikTest {
    @Mock
    private PolaznikService polaznikService;

    @InjectMocks
    private PolaznikController polaznikController;

    private MockMvc mockMvc;

    private List<PolaznikDto> polaznici;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(polaznikController).build();

        PolaznikDto article1 = new PolaznikDto("Jere", "Luketa");
        PolaznikDto article2 = new PolaznikDto("Nina", "Horvat");
        polaznici = Arrays.asList(article1, article2);
    }

    @Test
    void testGetAllPolaznici() throws Exception {
        when(polaznikService.getAllPolaznik()).thenReturn(polaznici);

        List<PolaznikDto> result = polaznikController.getAllPolaznici();

        assertEquals(2, result.size());
        verify(polaznikService, times(1)).getAllPolaznik();
    }

    @Test
    void testGetPolaznikById() throws Exception {
        Long polaznikId = 1L;
        PolaznikDto poalznikDto = new PolaznikDto("Bruno", "Podrug");
        when(polaznikService.findById(polaznikId)).thenReturn(Optional.of(poalznikDto));

        PolaznikDto result = polaznikController.getById(polaznikId);

        assertEquals(poalznikDto, result);
        verify(polaznikService, times(1)).findById(polaznikId);
    }
}
