package com.dio.santander.banklineapi.controller;

import com.dio.santander.banklineapi.dto.MovimentacaoPostDTO;
import com.dio.santander.banklineapi.model.Movimentacao;
import com.dio.santander.banklineapi.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    @Autowired
    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping
    public List<Movimentacao> findAll() {
        return movimentacaoService.findAll();
    }

    @PostMapping
    public void save(@RequestBody MovimentacaoPostDTO dto) {
        movimentacaoService.save(dto);
    }
}
