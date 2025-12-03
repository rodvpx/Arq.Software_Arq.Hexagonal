package com.arquiteturahexagonal.dominio;

import com.arquiteturahexagonal.dominio.dtos.AlunoDTO;

import java.util.UUID;

public class Aluno {

    private UUID codigo;
    private String matricula;
    private String nome;
    private String curso;
    private Integer periodo;

    public Aluno() {
    }

    public Aluno(UUID codigo, String matricula, String nome, String curso, Integer periodo) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.periodo = periodo;
    }

    public Aluno(AlunoDTO alunoDTO) {
        this.matricula = alunoDTO.getMatricula();
        this.nome = alunoDTO.getNome();
        this.curso = alunoDTO.getCurso();
        this.periodo = alunoDTO.getPeriodo();
    }

    public UUID getCodigo() {
        return codigo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void atualizarCurso(String novoCurso) {
        this.curso = novoCurso;
    }

    public void atualizarPeriodo(Integer novoPeriodo) {
        this.periodo = novoPeriodo;
    }

    public AlunoDTO toAlunoDTO() {
        return new AlunoDTO(this.matricula, this.nome, this.curso, this.periodo);
    }
}
