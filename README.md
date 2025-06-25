# Projeto - Manifestar Intenção de Ministrar Disciplina

Este projeto foi desenvolvido como parte da disciplina **Desenvolvimento Full Stack**.

## Objetivo

Este sistema tem como finalidade permitir que professores (docentes) manifestem sua intenção de ministrar disciplinas no próximo semestre letivo. A ferramenta digitaliza e organiza esse processo, garantindo que as manifestações sejam feitas dentro do prazo, respeitando as restrições de carga horária e evitando conflitos de horário entre turmas.

Por meio do sistema, o docente pode:

- Visualizar todas as turmas disponíveis para o semestre atual
- Selecionar as turmas em que deseja lecionar
- Visualizar o histórico de manifestações realizadas em semestres anteriores
- Ver quem mais demonstrou interesse em determinada turma
- Ordenar turmas por núcleo, horário, status e carga horária

O sistema também implementa regras de negócio importantes, como:

- Impedir que o docente manifeste interesse em duas turmas com choque de horário
- Permitir manifestações apenas dentro do período definido pela gestão acadêmica
- Exibir mensagens de erro se a manifestação ocorrer fora do prazo ou em caso de falha de comunicação com o servidor

A aplicação é dividida em três telas principais:

1. **Distribuição de Turmas** – onde o docente acessa e filtra as turmas disponíveis
2. **Manifestar Interesse** – onde realiza ou retira sua manifestação
3. **Histórico de Manifestações** – onde visualiza intenções registradas em semestres anteriores

## Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL (como SGBD)
- Maven

## Configuração do Banco de Dados

Este projeto utiliza o MySQL com as seguintes configurações no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/manifestar_intencao_db
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true
```

### Requisitos:
- Ter o MySQL instalado e em execução local
- Ter um banco de dados criado com o nome:

```
manifestar_intencao_db
```

- Usuário: `root`
- Sem senha
