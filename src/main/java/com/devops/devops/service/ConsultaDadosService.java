package com.devops.devops.service;

import com.devops.devops.domain.DadosDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ConsultaDadosService {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public DadosDTO consultaDados(){
        return DadosDTO.builder()
                .nome("José")
                .sobrenome("Ficticio")
                .materia("DEVOPS")
                .universidade("Pontificia Universidade Catolica do Paraná - PUC PR")
                .periodo(5)
                .diaDaConsulta(LocalDateTime.now().format(formatter))
                .build();
    }
}
