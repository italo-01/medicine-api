# 💊 Medicine API

API REST desenvolvida com **Java** e **Spring Boot** para gerenciamento de medicamentos, implementando autenticação com **JWT**, documentação automática com **Swagger/OpenAPI** e persistência de dados em **MySQL**.

O objetivo deste projeto foi praticar conceitos importantes do ecossistema Spring, como autenticação stateless, arquitetura em camadas, JPA/Hibernate e boas práticas no desenvolvimento de APIs REST.

---

# 🚀 Tecnologias

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT (JSON Web Token)
- MySQL
- Flyway
- Swagger / OpenAPI
- Maven

---

# 📚 Conceitos aplicados

- API REST
- CRUD completo
- Arquitetura em camadas
- DTO Pattern
- Repository Pattern
- Bean Validation
- Autenticação Stateless
- JWT Authentication
- Spring Security
- Filtros personalizados
- SecurityContext
- Versionamento do banco com Flyway
- Documentação da API com Swagger

---

# 📂 Estrutura do Projeto

```
src
 ├── controller
 │     ├── AutenticacaoController
 │     └── RemedioController
 │
 ├── dto
 │     ├── DadosCadastroRemedio
 │     ├── DadosAtualizarRemedio
 │     ├── DadosDetalhamentoRemedio
 │     ├── DadosListagemRemedios
 │     └── DadosDeletarRemedio
 │
 ├── infra
 │     ├── SecurityConfigurations
 │     ├── SecurityFilter
 │     ├── SwaggerConfiguration
 │     ├── TokenService
 │     └── TratamentoDeErros
 │
 ├── remedio
 │     ├── Remedio
 │     ├── Laboratorio
 │     ├── Via
 │     └── RemedioRepository
 │
 └── usuarios
       ├── Usuario
       ├── UsuarioRepository
       └── AutenticacaoService
```

---

# ⚙️ Funcionalidades

### Autenticação

- Login utilizando usuário e senha
- Geração de JWT
- Validação do token
- Proteção das rotas privadas

### Medicamentos

- Cadastrar medicamento
- Listar medicamentos
- Buscar medicamento por ID
- Atualizar medicamento
- Excluir medicamento
- Inativar medicamento
- Ativar medicamento

---

# 🔐 Fluxo de autenticação

1. O usuário realiza login.
2. O Spring autentica usuário e senha.
3. Um JWT é gerado.
4. O cliente envia esse token no Header Authorization.
5. O SecurityFilter valida o token.
6. O usuário é carregado do banco.
7. A autenticação é registrada no SecurityContext.
8. A requisição continua normalmente até o Controller.

Header utilizado:

```http
Authorization: Bearer <token>
```

---

# 🗄️ Banco de Dados

Banco utilizado:

- MySQL

Versionamento do banco:

- Flyway

As migrations ficam em:

```
src/main/resources/db/migration
```

---

# 📖 Documentação

Após iniciar a aplicação, a documentação pode ser acessada em:

```
http://localhost:8080/swagger-ui/index.html
```

---

# 📌 Endpoints

## Autenticação

| Método | Endpoint |
|----------|----------------|
| POST | /login |

---

## Medicamentos

| Método | Endpoint |
|----------|----------------------|
| GET | /remedio |
| GET | /remedio/{id} |
| POST | /remedio |
| PUT | /remedio |
| DELETE | /remedio/{id} |
| DELETE | /remedio/inativar/{id} |
| PUT | /remedio/ativar/{id} |

---

# ▶️ Como executar

Clone o projeto

```bash
git clone https://github.com/SEU-USUARIO/medicine_api.git
```

Entre na pasta

```bash
cd medicine_api
```

Configure as credenciais do MySQL no arquivo:

```
application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/medicine_api
spring.datasource.username=root
spring.datasource.password=sua_senha
```

Execute a aplicação

```bash
mvn spring-boot:run
```

A API ficará disponível em:

```
http://localhost:8080
```

Swagger:

```
http://localhost:8080/swagger-ui/index.html
```

---

# 🧠 Aprendizados

Durante o desenvolvimento deste projeto foram estudados conceitos como:

- Spring Boot
- Spring Security
- JWT
- Cadeia de filtros do Spring Security
- SecurityContext
- Bean Validation
- DTOs
- JPA/Hibernate
- Repository Pattern
- Swagger/OpenAPI
- Flyway
- Tratamento global de exceções
- APIs REST

---

# 👨‍💻 Autor

**Ítalo Costa**

Estudante de Engenharia de Software com foco em desenvolvimento Backend utilizando Java e Spring Boot.

- LinkedIn: https://www.linkedin.com/in/italo-costa-b9b7a12ab/
- GitHub: https://github.com/SEU-USUARIO

