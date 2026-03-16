# 🥗 Marmi — Delivery Fitness

> Plataforma de delivery voltada para o segmento fitness, desenvolvida com arquitetura de microserviços.

---

## 📋 Sobre o Projeto

O **Marmi** é uma aplicação backend de delivery focada no público fitness. O sistema é composto por microserviços independentes que se comunicam via REST, com roteamento centralizado pelo **Spring Cloud Gateway**. Cada serviço possui seu próprio banco de dados e responsabilidade bem definida, seguindo os princípios de **Domain-Driven Design (DDD)**.

---

## 🏗️ Arquitetura

```
                        ┌─────────────────────────┐
                        │   Spring Cloud Gateway   │
                        │     (porta: 8080)        │
                        └────────────┬────────────┘
                                     │
                   ┌─────────────────┴──────────────────┐
                   │                                    │
        ┌──────────▼──────────┐            ┌───────────▼───────────┐
        │  Serviço de Pedidos │            │ Serviço de Pagamentos  │
        │    (porta: 8081)    │            │     (porta: 8082)      │
        └──────────┬──────────┘            └───────────┬────────────┘
                   │                                    │
        ┌──────────▼──────────┐            ┌───────────▼────────────┐
        │   PostgreSQL        │            │      PostgreSQL         │
        │   (pedidos-db)      │            │    (pagamentos-db)      │
        └─────────────────────┘            └────────────────────────┘
```

### Microserviços

| Serviço              | Porta | Responsabilidade                              |
|----------------------|-------|-----------------------------------------------|
| `gateway-service`    | 8080  | Roteamento e entrada única da aplicação       |
| `pedidos-service`    | 8081  | Criação e gerenciamento de pedidos            |
| `pagamentos-service` | 8082  | Processamento e controle de pagamentos        |

---

## 🛠️ Tecnologias

- **Java 17**
- **Spring Boot 3**
- **Spring Cloud Gateway** — roteamento centralizado entre microserviços
- **Spring Cloud** — comunicação e configuração entre serviços
- **PostgreSQL** — banco de dados relacional (um por serviço)
- **Docker / Docker Compose** — containerização de todos os serviços
- **Maven** — gerenciamento de dependências
- **AWS ECS** *(em configuração)* — deploy em nuvem

---

## 📦 Pré-requisitos

- [Java 17+](https://adoptium.net/)
- [Docker](https://www.docker.com/) e Docker Compose
- [Maven](https://maven.apache.org/)

---

## 🚀 Como Rodar o Projeto

### 1. Clone o repositório

```bash
git clone https://github.com/cauacouto/marmi.git
cd marmi
```

### 2. Suba todos os serviços com Docker Compose

```bash
docker-compose up --build
```

Isso irá subir:
- Os 3 microserviços (gateway, pedidos, pagamentos)
- 2 instâncias do PostgreSQL

### 3. Acesse a aplicação

Todos os endpoints são acessados via **Gateway** na porta `8080`:

```
http://localhost:8080
```

---

## 📡 Endpoints

### Pedidos — via Gateway (`/pedidos`)

| Método | Endpoint              | Descrição                  |
|--------|-----------------------|----------------------------|
| `GET`  | `/pedidos`            | Lista todos os pedidos     |
| `GET`  | `/pedidos/{id}`       | Busca pedido por ID        |
| `POST` | `/pedidos`            | Cria um novo pedido        |
| `PUT`  | `/pedidos/{id}`       | Atualiza um pedido         |
| `DELETE` | `/pedidos/{id}`    | Remove um pedido           |

### Pagamentos — via Gateway (`/pagamentos`)

| Método | Endpoint                    | Descrição                       |
|--------|-----------------------------|---------------------------------|
| `GET`  | `/pagamentos`               | Lista todos os pagamentos       |
| `GET`  | `/pagamentos/{id}`          | Busca pagamento por ID          |
| `POST` | `/pagamentos`               | Registra um novo pagamento      |
| `PATCH`| `/pagamentos/{id}/confirmar`| Confirma um pagamento           |
| `PATCH`| `/pagamentos/{id}/cancelar` | Cancela um pagamento            |

---

## 🐳 Docker

Cada microserviço possui seu próprio **Dockerfile** e pode ser buildado e executado de forma independente.

### Build e execução — Gateway

```bash
cd gateway-service
docker build -t marmi-gateway .
docker run -p 8080:8080 marmi-gateway
```

### Build e execução — Pedidos

```bash
cd pedidos-service
docker build -t marmi-pedidos .
docker run -p 8081:8081 marmi-pedidos
```

### Build e execução — Pagamentos

```bash
cd pagamentos-service
docker build -t marmi-pagamentos .
docker run -p 8082:8082 marmi-pagamentos
```

---

## ☁️ Deploy — AWS ECS *(em andamento)*

O projeto está sendo configurado para deploy na AWS utilizando:

- **Amazon ECS** — orquestração dos containers
- **Amazon ECR** — repositório de imagens Docker
- **Amazon RDS** — banco de dados gerenciado em nuvem

---

## 👨‍💻 Autor

**Cauã da Silva Couto**
- GitHub: [@cauacouto](https://github.com/cauacouto)
- LinkedIn: [linkedin.com/in/cauãcouto](https://linkedin.com/in/cauãcouto-2848712b1)
