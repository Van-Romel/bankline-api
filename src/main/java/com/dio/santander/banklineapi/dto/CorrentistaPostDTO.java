package com.dio.santander.banklineapi.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CorrentistaPostDTO {

    private String nome;
    private String cpf;
}
