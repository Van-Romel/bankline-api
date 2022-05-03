package com.dio.santander.banklineapi.dto;

import com.dio.santander.banklineapi.model.MovimentacaoTipo;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoPostDTO {

    private String descricao;
    private Double valor;
    private MovimentacaoTipo tipo;
    private Integer idConta;
}
