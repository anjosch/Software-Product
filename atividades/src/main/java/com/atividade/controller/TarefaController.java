package com.atividade.controller;

import com.atividade.model.Tarefa;
import com.atividade.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    // Rota para mostrar a tela e a lista de tarefas
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tarefas", repository.findAll());
        return "index"; // Aponta para o arquivo index.html
    }

    // Rota para salvar a tarefa recebida do formulário
    @PostMapping("/salvar")
    public String salvar(Tarefa tarefa) {
        repository.save(tarefa);
        return "redirect:/"; // Atualiza a página após salvar
    }

    // Rota para deletar a tarefa pelo ID
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/"; // Volta para a lista após excluir
    }

    // Rota para buscar os dados antigos e abrir a tela de edição
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        // Busca a tarefa no banco de dados. Se não achar, retorna nulo
        Tarefa tarefa = repository.findById(id).orElse(null);
        model.addAttribute("tarefa", tarefa);
        return "editar"; // Vai procurar um arquivo chamado editar.html
    }
}