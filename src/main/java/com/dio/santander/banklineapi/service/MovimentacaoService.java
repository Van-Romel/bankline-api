package com.dio.santander.banklineapi.service;

import com.dio.santander.banklineapi.dto.MovimentacaoPostDTO;
import com.dio.santander.banklineapi.model.Movimentacao;
import com.dio.santander.banklineapi.model.MovimentacaoTipo;
import com.dio.santander.banklineapi.repository.CorrentistaRepository;
import com.dio.santander.banklineapi.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;
    private final CorrentistaRepository correntistaRepository;

    @Autowired
    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository, CorrentistaRepository correntistaRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.correntistaRepository = correntistaRepository;
    }

    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    public void save(MovimentacaoPostDTO dto) {

        var valor = dto.getTipo() == MovimentacaoTipo.RECEITA ? dto.getValor() : dto.getValor() * -1;

        var movimentacao = Movimentacao.builder()
                .dataHora(LocalDateTime.now())
                .descricao(dto.getDescricao())
                .idConta(dto.getIdConta())
                .tipo(dto.getTipo())
                .valor(valor).build();
        movimentacao.setDescricao(dto.getDescricao());
        movimentacao.setValor(dto.getValor());

        var correntista = correntistaRepository.findById(dto.getIdConta()).orElse(null);
        if (correntista != null) {
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        movimentacaoRepository.save(movimentacao);
    }
}
