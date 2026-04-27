package com.devops.devops.controller;

import com.devops.devops.domain.DadosDTO;
import com.devops.devops.service.ConsultaDadosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ConsultaController.class)
class ConsultaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ConsultaDadosService consultaDadosService;

    @Test
    void testGetConsultaOk() throws Exception {
        DadosDTO mockDados = DadosDTO.builder()
                .nome("José")
                .sobrenome("Ficticio")
                .materia("DEVOPS")
                .universidade("PUC PR")
                .periodo(5)
                .diaDaConsulta("27/04/2026 09:40")
                .build();

        when(consultaDadosService.consultaDados()).thenReturn(mockDados);

        mockMvc.perform(get("/consulta"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("José"))
                .andExpect(jsonPath("$.materia").value("DEVOPS"));
    }

    @Test
    void testGetConsultaNotFound() throws Exception {
        when(consultaDadosService.consultaDados()).thenReturn(null);

        mockMvc.perform(get("/consulta"))
                .andExpect(status().isNotFound());
    }
}
