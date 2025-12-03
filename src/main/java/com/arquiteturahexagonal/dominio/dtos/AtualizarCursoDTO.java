package com.arquiteturahexagonal.dominio.dtos;

public class AtualizarCursoDTO {

    private String novoCurso;

    public AtualizarCursoDTO() {
    }

    public AtualizarCursoDTO(String novoCurso) {
        this.novoCurso = novoCurso;
    }

    public String getNovoCurso() {
        return novoCurso;
    }

    public void setNovoCurso(String novoCurso) {
        this.novoCurso = novoCurso;
    }
}
