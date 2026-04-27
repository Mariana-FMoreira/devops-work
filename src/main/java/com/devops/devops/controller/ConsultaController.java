package com.devops.devops.controller;

import com.devops.devops.domain.DadosDTO;
import com.devops.devops.service.ConsultaDadosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaController {

    private final ConsultaDadosService consultaDadosService;

    public ConsultaController(ConsultaDadosService consultaDadosService) {
        this.consultaDadosService = consultaDadosService;
    }

    @GetMapping("/consulta")
    public ResponseEntity<DadosDTO> consultaDados(){
        DadosDTO dados = consultaDadosService.consultaDados();
        if (dados == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(dados);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
