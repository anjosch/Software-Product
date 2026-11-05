package com.atividade.controller;

import com.atividade.model.Tarefa;
import com.atividade.model.Usuario;
import com.atividade.repository.TarefaRepository;
import jakarta.servlet.http.HttpSession;
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

    // Lista só as tarefas do usuário logado
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            return "redirect:/login";
        }
        model.addAttribute("tarefas", repository.findByUsuario(usuarioLogado));
        return "index";
    }

    // Salva ou atualiza a tarefa vinculando ao usuário logado
    @PostMapping("/salvar")
    public String salvar(Tarefa tarefa, HttpSession session) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            return "redirect:/login";
        }
        // Amarra a tarefa ao usuário antes de salvar no MySQL
        tarefa.setUsuario(usuarioLogado);
        repository.save(tarefa);
        return "redirect:/";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        repository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        Tarefa tarefa = repository.findById(id).orElse(null);
        model.addAttribute("tarefa", tarefa);
        return "editar";
    }
}