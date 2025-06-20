# Projeto - Manifestar Intenção de Ministrar Disciplina

Este projeto foi desenvolvido como parte da disciplina **Desenvolvimento Full Stack**.

## Objetivo

Permitir que professores manifestem interesse em ministrar disciplinas, e que a unidade universitária organize essas intenções de forma adequada, respeitando as cargas horárias.

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
