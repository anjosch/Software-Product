package com.atividade1.controller;

import com.atividade1.model.Tarefa;
import com.atividade1.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}