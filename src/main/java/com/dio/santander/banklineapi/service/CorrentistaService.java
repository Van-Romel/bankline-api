package com.dio.santander.banklineapi.service;

import com.dio.santander.banklineapi.dto.CorrentistaPostDTO;
import com.dio.santander.banklineapi.model.Conta;
import com.dio.santander.banklineapi.model.Correntista;
import com.dio.santander.banklineapi.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CorrentistaService {

    private final CorrentistaRepository correntistaRepository;

    @Autowired
    public CorrentistaService(CorrentistaRepository correntistaRepository) {
        this.correntistaRepository = correntistaRepository;
    }

    public void save(CorrentistaPostDTO dto) {
        var correntista = Correntista.builder().cpf(dto.getCpf()).nome(dto.getNome()).build();
        var conta = Conta.builder().saldo(0.0).numero(new Date().getTime()).build();
        correntista.setConta(conta);

        correntistaRepository.save(correntista);
    }

    public List<Correntista> findAll() {
        return correntistaRepository.findAll();
    }
}
