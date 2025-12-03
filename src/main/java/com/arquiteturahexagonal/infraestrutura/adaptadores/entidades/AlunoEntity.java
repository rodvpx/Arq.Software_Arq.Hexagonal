package com.arquiteturahexagonal.infraestrutura.adaptadores.entidades;

import com.arquiteturahexagonal.dominio.Aluno;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "alunos")
public class AlunoEntity {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codigo;

    private String matricula;
    private String nome;
    private String curso;
    private Integer periodo;

    public AlunoEntity() {
    }

    public AlunoEntity(Aluno aluno) {
        this.codigo = aluno.getCodigo();
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.curso = aluno.getCurso();
        this.periodo = aluno.getPeriodo();
    }

    public void atualizar(Aluno aluno) {
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.curso = aluno.getCurso();
        this.periodo = aluno.getPeriodo();
    }

    public Aluno toAluno() {
        return new Aluno(this.codigo, this.matricula, this.nome, this.curso, this.periodo);
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

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
}
