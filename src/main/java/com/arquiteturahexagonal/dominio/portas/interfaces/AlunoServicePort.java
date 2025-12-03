package com.arquiteturahexagonal.dominio.portas.interfaces;

import com.arquiteturahexagonal.dominio.dtos.AlunoDTO;
import com.arquiteturahexagonal.dominio.dtos.AtualizarCursoDTO;
import javassist.NotFoundException;

import java.util.List;

public interface AlunoServicePort {

    List<AlunoDTO> buscarAlunos();

    void criarAluno(AlunoDTO alunoDTO);

    void atualizarCurso(String matricula, AtualizarCursoDTO atualizarCursoDTO) throws NotFoundException;
}
