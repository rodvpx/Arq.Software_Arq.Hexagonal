package com.arquiteturahexagonal.dominio.dtos;

public class AlunoDTO {

    private String matricula;
    private String nome;
    private String curso;
    private Integer periodo;

    public AlunoDTO(String matricula, String nome, String curso, Integer periodo) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.periodo = periodo;
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
}
