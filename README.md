# 📝 Sistema de Gerenciamento de Tarefas (To-Do List)

Projeto acadêmico de **Desenvolvimento de Software** construído com **Java e Spring Boot**, focado no gerenciamento de tarefas diárias.

Este projeto segue a metodologia ágil, sendo desenvolvido de forma incremental com entregas de novas funcionalidades a cada Sprint (Atividades Contínuas), integrando sempre Front-end, Back-end e Banco de Dados.

## 🎯 Objetivo do Projeto

Desenvolver uma aplicação web full-stack funcional que permita aos usuários registrar, acompanhar e gerenciar suas atividades, garantindo a persistência das informações em um banco de dados relacional.

## 💻 Tecnologias Utilizadas

* **Linguagem:** Java
* **Framework:** Spring Boot (Spring Web, Spring Data JPA)
* **Front-end:** HTML5, CSS3 e Thymeleaf (Renderização Server-side)
* **Banco de Dados:** MySQL
* **Controle de Versão:** Git e GitHub
* **Gestão Ágil:** Trello

## 🚀 AC1 — Cadastro e Listagem (Core da Aplicação)

A primeira entrega (Sprint 1) estabelece a arquitetura base do sistema e entrega o núcleo do produto operando de ponta a ponta.

### Funcionalidades Implementadas:
* Criação da entidade `Tarefa` no banco de dados.
* Interface gráfica para inserção de novas tarefas (Título e Descrição).
* Rota no Back-end para receber os dados do formulário e persisti-los no MySQL.
* Listagem dinâmica das tarefas salvas diretamente na tela inicial.

### 🎥 Vídeo de Apresentação (AC1)
> [Assistir à demonstração da AC1 no Loom]

## 📋 Gestão do Projeto (Kanban)
O acompanhamento das Sprints, backlogs e tarefas em andamento é feito publicamente através do nosso quadro ágil.
> [Acessar o Trello do Projeto](https://trello.com/b/GCYxq0fc/software-product-analysis-specification-project-implementation-202602-ead-ads-5a)

## ⚙️ Como executar o projeto localmente

1. Clone este repositório: `git clone https://github.com/anjosch/Software-Product.git`
2. Crie um banco de dados no MySQL local chamado `atividade1`.
3. Configure o usuário e senha do banco no arquivo `src/main/resources/application.properties`.
4. Execute a classe principal `MainApplication.java` na sua IDE (IntelliJ/Eclipse).
5. Acesse a aplicação no navegador através do endereço: `http://localhost:8080`

## 🔒 Nota sobre Dados
*Atendendo às diretrizes da disciplina, **nenhum dado real, corporativo ou sensível** é utilizado neste projeto. Todas as tarefas cadastradas nos vídeos de demonstração e nos testes de banco de dados são estritamente fictícias e criadas apenas para fins acadêmicos.*

## 🛣️ Roadmap de Evolução (Sprints)

* [x] **AC1** — Estrutura base, Cadastro e Listagem de Tarefas (Integração Front, Back e BD)
* [ ] **AC2** — Implementação das funções de Edição (Update) e Exclusão (Delete)
* [ ] **AC3** — Sistema de Autenticação e Login (Spring Security)
* [ ] **Prova Final** — Dashboard com métricas e gráficos de tarefas concluídas vs. pendentes

---

## 👨‍💻 Desenvolvedor

**Gabriel Anjos de Brito Chaves**
*Projeto desenvolvido para a disciplina de Software Product: Analysis, Specification, Project & Implementation.*