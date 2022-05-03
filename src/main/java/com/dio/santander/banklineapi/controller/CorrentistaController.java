package com.dio.santander.banklineapi.controller;

import com.dio.santander.banklineapi.dto.CorrentistaPostDTO;
import com.dio.santander.banklineapi.model.Correntista;
import com.dio.santander.banklineapi.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    private final CorrentistaService correntistaService;

    @Autowired
    public CorrentistaController(CorrentistaService correntistaService) {
        this.correntistaService = correntistaService;
    }

    @GetMapping
    public List<Correntista> findAll() {
        return correntistaService.findAll();
    }

    @PostMapping
    public void save(@RequestBody CorrentistaPostDTO correntista) {
        correntistaService.save(correntista);
    }
}
