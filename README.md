# Sistema de Gerenciamento de Tarefas (To-Do List)

Projeto acadêmico desenvolvido para a disciplina **Software Product: Analysis, Specification, Project & Implementation** (Curso de Análise e Desenvolvimento de Sistemas - EAD, Faculdade Impacta).

O sistema foi construído de forma incremental seguindo metodologias ágeis (Kanban no Trello), garantindo integração completa entre **Front-end**, **Back-end** e **Banco de Dados** em todas as entregas.

---

## Tecnologias Utilizadas

* **Linguagem:** Java 17+
* **Back-end:** Spring Boot (Spring Web, Spring Data JPA)
* **Front-end:** HTML5, CSS3, Thymeleaf e Chart.js
* **Banco de Dados:** MySQL
* **Controle de Versão & Gestão Ágil:** Git/GitHub e Trello

---

## Evolução do Produto (Entregas)

### AC1 — Cadastro e Listagem de Tarefas
* Criação da entidade `Tarefa`, repositório JPA (`TarefaRepository`) e controlador (`TarefaController`).
* Implementação do formulário de criação e listagem dinâmica em tela com persistência no MySQL.

### AC2 — Edição e Exclusão de Tarefas
* Implementação das rotas de atualização (`/editar/{id}`) e exclusão (`/excluir/{id}`) com confirmação via interface.
* Persistência de `UPDATE` e `DELETE` refletida em tempo real no banco de dados.

### AC3 — Cadastro, Autenticação e Isolamento Multiusuário
* Criação da entidade `Usuario` e controle de autenticação em sessão via `HttpSession` (`/cadastro`, `/login`, `/logout`).
* Relacionamento `@ManyToOne` entre `Tarefa` e `Usuario` (`usuario_id`), garantindo que cada usuário visualize, crie, edite e exclua exclusivamente suas próprias tarefas.

### Entrega Final — Status de Conclusão e Dashboard de Métricas
* Adição do atributo `concluida` (`boolean`) na entidade `Tarefa` e rota `/concluir/{id}` para alternar tarefas entre **Pendente** e **Concluída**.
* Implementação de **Dashboard dinâmico** na tela principal exibindo cards de resumo (**Total**, **Concluídas** e **Pendentes**) e gráfico interativo (Chart.js) calculados a partir das tarefas do usuário logado.
* Blindagem de autorização nas operações de edição, exclusão e conclusão por proprietário da tarefa.

---

## Estrutura Básica do Projeto

```text
src/main/java/com/atividade/
├── controller/
│   ├── TarefaController.java
│   └── UsuarioController.java
├── model/
│   ├── Tarefa.java
│   └── Usuario.java
└── repository/
    ├── TarefaRepository.java
    └── UsuarioRepository.java

src/main/resources/
├── templates/
│   ├── cadastro.html
│   ├── editar.html
│   ├── index.html
│   └── login.html
└── application.properties
```

---

## Como Executar Localmente

1. Crie um banco de dados no MySQL (ex.: `CREATE DATABASE atividade1;`).
2. Configure suas credenciais locais do MySQL em `src/main/resources/application.properties` (não versionar senhas reais em repositórios públicos).
3. Execute a aplicação Spring Boot pelo IntelliJ IDEA ou via Maven (`./mvnw spring-boot:run`).
4. Acesse no navegador: `http://localhost:8080`.

---

## Links de Gestão e Acompanhamento

* **Quadro Ágil (Trello):** [Acessar Board](https://trello.com/b/GCYxq0fc/software-product-analysis-specification-project-implementation-202602-ead-ads-5a)
* **Repositório (GitHub):** [anjosch/Software-Product](https://github.com/anjosch/Software-Product.git)

---

**Autor:** Gabriel Anjos de Brito Chaves — RA: 2302391