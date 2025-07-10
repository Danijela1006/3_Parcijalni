package org.example.controller;

import org.example.dto.AuthRequestDto;
import org.example.dto.JwtResponseDto;
import org.example.dto.PolaznikDto;
import org.example.service.PolaznikService;
import org.junit.jupiter.api.Test;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PolaznikIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PolaznikService polaznikService;

    @Autowired
    private AuthController authController;

    private String accessToken;

    private PolaznikDto polaznikDTO;

    @BeforeEach
    void setUp() throws Exception {
        AuthRequestDto authRequest = new AuthRequestDto();
        authRequest.setUsername("admin");
        authRequest.setPassword("admin");

        JwtResponseDto jwtResponse = authController.authenticateAndGetToken(authRequest);
        accessToken = jwtResponse.getAccessToken();

        polaznikDTO = new PolaznikDto();
        polaznikDTO.setIme("Maja");
        polaznikDTO.setPrezime("Ivić");

        polaznikDTO = new PolaznikDto();
        polaznikDTO.setIme("Ivana");
        polaznikDTO.setPrezime("Jakus");
    }

    @Test
    void testGetAllPolaznici() throws Exception {
        polaznikService.save(polaznikDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/polaznici")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].ime", is("Ante")))
                .andExpect(jsonPath("$[0].prezime", is("Antic")));
    }

    @Test
    void testGetPolaznikById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/polaznici/{id}", 2L)
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ime", is("Ivo")))
                .andExpect(jsonPath("$.prezime", is("Ivic")));
    }
}
