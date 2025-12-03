package com.arquiteturahexagonal.infraestrutura.configuracao;

import com.arquiteturahexagonal.dominio.adaptadores.services.AlunoServiceImp;
import com.arquiteturahexagonal.dominio.portas.interfaces.AlunoServicePort;
import com.arquiteturahexagonal.dominio.portas.repositories.AlunoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {

    @Bean
    AlunoServicePort alunoService(AlunoRepositoryPort alunoRepositoryPort) {
        return new AlunoServiceImp(alunoRepositoryPort);
    }
}
