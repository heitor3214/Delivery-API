# 🚀 Delivery API (Spring Boot)

API REST desenvolvida em Java com Spring Boot para gerenciamento de entregas e clientes.

## 📌 Sobre o projeto

Este projeto foi desenvolvido por mim como parte dos meus estudos em programação backend.
Meu objetivo foi aplicar conceitos reais utilizados no mercado, como:

* Arquitetura em camadas (Controller, Service, Repository)
* Uso de DTOs para transferência de dados
* Validação de dados com Bean Validation
* Relacionamento entre entidades (JPA / Hibernate)
* Regras de negócio aplicadas corretamente

Um exemplo importante implementado foi:
👉 O endereço de origem da entrega é automaticamente obtido a partir do cliente, evitando inconsistência de dados.

---

## 🧠 Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* Lombok
* Maven

---

## 📦 Funcionalidades

### 👤 Cliente

* Criar cliente
* Listar clientes
* Buscar por ID
* Atualizar cliente
* Deletar cliente

### 📦 Entrega

* Criar entrega
* Listar entregas
* Buscar por ID
* Atualizar entrega
* Deletar entrega

---

## 🔥 Exemplo de requisição (POST /Entregas)

```json
{
  "peso": 2.5,
  "preco": 150.75,
  "status": "PENDENTE",
  "enderecoDeDestino": {
    "cep": "20040-020",
    "logradouro": "Av Paulista",
    "numero": "999",
    "complemento": "Andar 10"
  },
  "clienteId": 1
}
```

---

## ⚙️ Como rodar o projeto

```bash
# Clonar repositório
git clone https://github.com/heitor3214/delivery-api.git

# Entrar na pasta
cd delivery-api

# Rodar projeto
./mvnw spring-boot:run
```

A API estará disponível em:
👉 http://localhost:8080

---

## 📚 Aprendizados

Durante o desenvolvimento deste projeto eu aprendi:

* Estruturar uma API REST do zero
* Separar responsabilidades corretamente
* Trabalhar com banco de dados usando JPA
* Aplicar validações e regras de negócio
* Resolver erros e melhorar o código continuamente

---

## 👨‍💻 Sobre mim

Sou um estudante de programação, tenho 14 anos e estou iniciando minha jornada como desenvolvedor backend.

Desenvolvi este projeto com foco em aprendizado prático e evolução constante, estudando documentação, praticando e resolvendo problemas por conta própria.

📍 Barra Bonita - SP
🎯 Buscando oportunidade como Jovem Aprendiz na área de tecnologia

---

## 📬 Contato

* Email: heitorvaralda21@gmail.com
* GitHub: https://github.com/heitor3214

---

## ⭐ Considerações finais

Este é um dos meus primeiros projetos e estou em constante evolução.
Feedbacks são muito bem-vindos!
