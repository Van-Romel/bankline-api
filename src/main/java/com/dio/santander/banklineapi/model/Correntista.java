package com.dio.santander.banklineapi.model;

import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "correntista")
public class Correntista {

    @Id
    private Long id;
    private String nome;
    private String cpf;

    @Embedded
    private Conta conta;
}
