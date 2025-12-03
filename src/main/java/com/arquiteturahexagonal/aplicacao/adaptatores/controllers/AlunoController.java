package com.arquiteturahexagonal.aplicacao.adaptatores.controllers;

import com.arquiteturahexagonal.dominio.dtos.AtualizarCursoDTO;
import com.arquiteturahexagonal.dominio.dtos.AlunoDTO;
import com.arquiteturahexagonal.dominio.portas.interfaces.AlunoServicePort;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoServicePort alunoServicePort;

    public AlunoController(AlunoServicePort alunoServicePort) {
        this.alunoServicePort = alunoServicePort;
    }

    @PostMapping
    void criarAluno(@RequestBody AlunoDTO alunoDTO) {
        alunoServicePort.criarAluno(alunoDTO);
    }

    @GetMapping
    List<AlunoDTO> getAlunos() {
        return alunoServicePort.buscarAlunos();
    }

    @PutMapping(value = "/{matricula}")
    void atualizarCurso(@PathVariable String matricula,
                        @RequestBody AtualizarCursoDTO atualizarCursoDTO) throws NotFoundException {
        alunoServicePort.atualizarCurso(matricula, atualizarCursoDTO);
    }
}
