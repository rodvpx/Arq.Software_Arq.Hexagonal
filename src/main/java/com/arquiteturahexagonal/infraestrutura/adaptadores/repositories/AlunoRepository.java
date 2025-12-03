package com.arquiteturahexagonal.infraestrutura.adaptadores.repositories;

import com.arquiteturahexagonal.dominio.Aluno;
import com.arquiteturahexagonal.dominio.portas.repositories.AlunoRepositoryPort;
import com.arquiteturahexagonal.infraestrutura.adaptadores.entidades.AlunoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AlunoRepository implements AlunoRepositoryPort {

    private final SpringAlunoRepository springAlunoRepository;

    public AlunoRepository(SpringAlunoRepository springAlunoRepository) {
        this.springAlunoRepository = springAlunoRepository;
    }

    @Override
    public List<Aluno> buscarTodos() {
        List<AlunoEntity> alunoEntities = this.springAlunoRepository.findAll();
        return alunoEntities.stream()
                .map(AlunoEntity::toAluno)
                .collect(Collectors.toList());
    }

    @Override
    public Aluno buscarPelaMatricula(String matricula) {
        Optional<AlunoEntity> alunoEntity = this.springAlunoRepository.findByMatricula(matricula);

        if (alunoEntity.isPresent())
            return alunoEntity.get().toAluno();

        throw new RuntimeException("Aluno não existe");
    }

    @Override
    public void salvar(Aluno aluno) {
        AlunoEntity alunoEntity;
        if (Objects.isNull(aluno.getCodigo())) {
            alunoEntity = new AlunoEntity(aluno);
        } else {
            alunoEntity = this.springAlunoRepository.findById(aluno.getCodigo())
                    .orElseThrow(() -> new RuntimeException("Aluno não existe"));
            alunoEntity.atualizar(aluno);
        }

        this.springAlunoRepository.save(alunoEntity);
    }
}
