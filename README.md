# 🎬 Filmlog API

API desenvolvida com **Spring Boot + JPA + MariaDB** para gerenciamento de filmes.

---

## 📦 Tecnologias

- Java 21+ (ou superior)
- Spring Boot 3.5
- Spring Data JPA
- MariaDB
- Maven

---

## 🚀 Como rodar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/filmlog-api.git
cd filmlog-api
```

### 2. Configure o banco de dados

Você precisa de um banco MariaDB rodando localmente com um banco chamado `filmlog`.

Crie com o comando:

```sql
CREATE DATABASE filmlog CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

> Ou use um cliente como DBeaver, MySQL Workbench ou o terminal.

---

### 3. Configure o arquivo `application.yml`

O projeto **vem com um arquivo `application-example.yml`** de exemplo.

Copie ele e renomeie para `application.yml`:

```bash
cp src/main/resources/application-example.yml src/main/resources/application.yml
```

Depois, edite com suas credenciais de acesso ao banco:

```yaml
spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/filmlog
    username: seu_usuario
    password: sua_senha
    driver-class-name: org.mariadb.jdbc.Driver
```

---

### 4. Rode a aplicação

Você pode rodar com o Maven:

```bash
./mvnw spring-boot:run
```

Ou diretamente na sua IDE (IntelliJ, VS Code, Eclipse).

---

## 📌 Observações

- A criação de tabelas é automática (`ddl-auto: update`).
- O endpoint principal roda em `http://localhost:8080/movies`.

---

## ✍️ Autor

Desenvolvido por [Mateus Dias Oliveira](https://github.com/mateusnoites)