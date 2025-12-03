# Microsserviço de Alunos – Arquitetura Hexagonal

Este projeto é um microsserviço simples para gerenciamento de alunos, desenvolvido em Java com Spring Boot, seguindo o estilo de Arquitetura Hexagonal (Ports & Adapters).  
Ele foi pensado para uso didático em seminários de Arquitetura de Software, mostrando como desacoplar regras de negócio de detalhes de infraestrutura.

## Objetivo da aplicação

A aplicação permite:

- Cadastrar alunos
- Listar alunos cadastrados
- Atualizar o curso de um aluno a partir da matrícula

O foco não é a complexidade funcional, e sim a organização em camadas independentes e o uso de portas e adaptadores.

## Arquitetura

A estrutura de pacotes segue três grandes áreas:

- `dominio`
    - Contém a entidade de domínio `Aluno`, os DTOs (`AlunoDTO`, `AtualizarCursoDTO`)
    - Portas (interfaces) de entrada/serviço e saída/repositório (`AlunoServicePort`, `AlunoRepositoryPort`)
    - Implementação da regra de negócio em `AlunoServiceImp` (adaptador de serviço)

- `infraestrutura`
    - Entidade de persistência `AlunoEntity` (mapeada com JPA para a tabela `alunos`)
    - Repositórios concretos (`SpringAlunoRepository`, `AlunoRepository`)
    - Classe de configuração de beans (`BeanConfiguracao`) que conecta portas e adaptadores

- `aplicacao`
    - Controlador REST (`AlunoController`) que expõe a API HTTP e conversa apenas com a porta `AlunoServicePort`

Essa organização ilustra a ideia central da arquitetura hexagonal: o domínio depende apenas de abstrações, enquanto HTTP, banco de dados e framework ficam nas bordas, como adaptadores substituíveis.

## Tecnologias utilizadas

- Java 11+
- Spring Boot
- Spring Web
- Spring Data JPA
- Banco de dados H2 (em memória ou arquivo)

## Configuração do banco H2

Arquivo `src/main/resources/application.properties` (exemplo em memória):

```properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2

spring.datasource.url=jdbc:h2:mem:db_aluno
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.driver-class-name=org.h2.Driver

spring.jpa.hibernate.ddl-auto=create-drop
```

- Console H2: `http://localhost:8080/h2`
- JDBC URL: `jdbc:h2:mem:db_aluno`
- User: `root`
- Password: `admin`

## Endpoints principais

Base URL: `http://localhost:8080`

### Criar aluno

- Método: `POST`
- URL: `/alunos`
- Body (JSON):

```json
{
  "matricula": "2025001",
  "nome": "João da Silva",
  "curso": "Engenharia de Software",
  "periodo": 3
}
```

- Resposta: `201/200` sem corpo ou com o aluno criado, dependendo de como o controller estiver implementado.

### Listar alunos

- Método: `GET`
- URL: `/alunos`
- Resposta (exemplo):

```json
[
  {
    "matricula": "2025001",
    "nome": "João da Silva",
    "curso": "Engenharia de Software",
    "periodo": 3
  }
]
```

### Atualizar curso do aluno

- Método: `PUT`
- URL: `/alunos/{matricula}`

Exemplo:

```http
PUT /alunos/2025001
```

Body:

```json
{
  "novoCurso": "Ciência da Computação"
}
```

- Resposta: `204` ou `200`, conforme implementação.

## Como rodar o projeto

1. Clonar o repositório
2. Importar como projeto Maven/Gradle na IDE ou usar a linha de comando
3. Executar a classe principal do Spring Boot (por exemplo, `ArquiteturaHexagonalApplication`)
4. Acessar:
    - API REST via Postman/Insomnia em `http://localhost:8080/alunos`
    - Console H2 em `http://localhost:8080/h2`