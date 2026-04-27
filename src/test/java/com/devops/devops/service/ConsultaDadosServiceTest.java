package com.devops.devops.service;

import com.devops.devops.domain.DadosDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConsultaDadosServiceTest {

    private final ConsultaDadosService consultaDadosService = new ConsultaDadosService();

    @Test
    void testConsultaDadosNotNull() {
        DadosDTO dados = consultaDadosService.consultaDados();
        assertNotNull(dados, "O retorno não deve ser nulo");
    }

    @Test
    void testConsultaDadosNomeCorreto() {
        DadosDTO dados = consultaDadosService.consultaDados();
        assertEquals("José", dados.getNome(), "O nome deve ser José");
    }

    @Test
    void testConsultaDadosUniversidadeCorreta() {
        DadosDTO dados = consultaDadosService.consultaDados();
        assertEquals("Pontificia Universidade Catolica do Paraná - PUC PR", dados.getUniversidade(), "A universidade deve ser a PUC PR");
    }
}
