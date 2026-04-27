package com.devops.devops.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DadosDTO {
    private String nome;
    private String sobrenome;
    private String materia;
    private String universidade;
    private Integer periodo;
    private String diaDaConsulta;
}
