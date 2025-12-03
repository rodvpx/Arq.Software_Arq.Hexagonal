package com.arquiteturahexagonal.dominio.portas.repositories;

import com.arquiteturahexagonal.dominio.Aluno;

import java.util.List;

public interface AlunoRepositoryPort {

    List<Aluno> buscarTodos();

    Aluno buscarPelaMatricula(String matricula);

    void salvar(Aluno aluno);
}
