package com.arquiteturahexagonal.infraestrutura.adaptadores.repositories;

import com.arquiteturahexagonal.infraestrutura.adaptadores.entidades.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringAlunoRepository extends JpaRepository<AlunoEntity, UUID> {
    Optional<AlunoEntity> findByMatricula(String matricula);
}
