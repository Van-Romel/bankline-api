package com.dio.santander.banklineapi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "data_hora")
    private LocalDateTime dataHora;
    private String descricao;
    private Double valor;
    @Column(name = "id_conta")
    private Integer idConta;
    @Enumerated(EnumType.STRING)
    private MovimentacaoTipo tipo;

}
