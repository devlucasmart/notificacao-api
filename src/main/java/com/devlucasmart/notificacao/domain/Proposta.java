package com.devlucasmart.notificacao.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
public class Proposta {

    private Long id;
    private Double valorSolicitado;
    private Integer prazoPagamento;
    private Boolean aprovada;
    private boolean integrada;
    private String observacao;
    private Usuario usuario;
}
