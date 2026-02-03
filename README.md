# 🎬 MovieFlix API

MovieFlix é uma **API RESTful** desenvolvida em **Java com Spring Boot**, focada no gerenciamento de filmes e usuários, com **autenticação e autorização via JWT**, seguindo boas práticas de arquitetura e organização de código.

O projeto foi criado com fins educacionais e práticos, simulando uma aplicação real de mercado.

---

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot**
* **Spring Web**
* **Spring Security**
* **JWT (JSON Web Token)**
* **Spring Data JPA / Hibernate**
* **Maven**
* **Banco de Dados Relacional** (PostgreSQL)
* **Lombok**
* **Swagger / OpenAPI**

---

## 🧱 Arquitetura do Projeto

O projeto segue uma arquitetura em camadas, visando organização, manutenibilidade e escalabilidade:

```
br.com.movieflix
│
├── controller      # Controllers REST
├── service         # Regras de negócio
├── repository      # Acesso a dados
├── domain          # Entidades JPA / dtos / mappers
├── security        # Configurações de segurança e JWT
├── exception       # Exceções e handlers globais
└── config          # Configurações gerais
```

---

## 🔐 Segurança

A aplicação utiliza **Spring Security com JWT**, garantindo:

* Registro e login de usuários
* Geração de token JWT
* Autenticação stateless
* Filtro de segurança customizado

Fluxo básico:

1. Usuário faz login
2. API retorna um token JWT
3. Token é enviado no header `Authorization`
4. Acesso liberado conforme permissões

---

## 📌 Endpoints Principais

### 🔑 Autenticação

| Método | Endpoint         | Descrição                |
| ------ | ---------------- | ------------------------ |
| POST   | `/auth/register` | Registro de usuário      |
| POST   | `/auth/login`    | Login e geração de token |

### 🎥 Filmes

| Método | Endpoint       | Descrição               |
| ------ | -------------- | ----------------------- |
| GET    | `/movies`      | Listar filmes           |
| GET    | `/movies/{id}` | Buscar filme por ID     |
| POST   | `/movies`      | Criar filme             |
| PUT    | `/movies/{id}` | Atualizar filme         |
| DELETE | `/movies/{id}` | Remover filme           |

---

## 📄 Documentação

A documentação da API pode ser acessada via **Swagger**:

```
http://localhost:8080/swagger-ui.html
```

---

## ▶️ Como Executar o Projeto

### Pré-requisitos

* Java 17+
* Maven
* Banco de dados configurado (Docker)


## 🎯 Objetivos do Projeto

* Implementar autenticação JWT
* Praticar Java e Spring Boot
* Aplicar boas práticas de arquitetura
* Simular um backend profissional

---

## 👨‍💻 Autor

**Leonardo Moreira Guidorizzi**

Sinta-se à vontade para contribuir ou sugerir melhorias 🚀


