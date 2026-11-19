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

        java.util.List<Tarefa> tarefasDoUsuario = repository.findByUsuario(usuarioLogado);
        long totalConcluidas = tarefasDoUsuario.stream().filter(Tarefa::isConcluida).count();
        long totalPendentes = tarefasDoUsuario.size() - totalConcluidas;

        model.addAttribute("tarefas", tarefasDoUsuario);
        model.addAttribute("totalTarefas", tarefasDoUsuario.size());
        model.addAttribute("totalConcluidas", totalConcluidas);
        model.addAttribute("totalPendentes", totalPendentes);
        return "index";
    }

    @PostMapping("/salvar")
    public String salvar(Tarefa tarefa, HttpSession session) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            return "redirect:/login";
        }

        // Se for edição de uma tarefa existente, valida posse e mantém o status 'concluida'
        if (tarefa.getId() != null) {
            Tarefa existente = repository.findById(tarefa.getId()).orElse(null);
            if (existente == null || existente.getUsuario() == null
                    || !existente.getUsuario().getId().equals(usuarioLogado.getId())) {
                return "redirect:/";
            }
            tarefa.setConcluida(existente.isConcluida());
        }

        tarefa.setUsuario(usuarioLogado);
        repository.save(tarefa);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, HttpSession session) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            return "redirect:/login";
        }

        Tarefa tarefa = repository.findById(id).orElse(null);
        if (tarefa == null || tarefa.getUsuario() == null
                || !tarefa.getUsuario().getId().equals(usuarioLogado.getId())) {
            return "redirect:/";
        }

        model.addAttribute("tarefa", tarefa);
        return "editar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, HttpSession session) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            return "redirect:/login";
        }

        Tarefa tarefa = repository.findById(id).orElse(null);
        if (tarefa != null && tarefa.getUsuario() != null
                && tarefa.getUsuario().getId().equals(usuarioLogado.getId())) {
            repository.deleteById(id);
        }
        return "redirect:/";
    }
    // Alterna o status da tarefa entre Pendente (false) e Concluída (true)
    @GetMapping("/concluir/{id}")
    public String concluir(@PathVariable Long id, HttpSession session) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            return "redirect:/login";
        }

        Tarefa tarefa = repository.findById(id).orElse(null);
        if (tarefa != null && tarefa.getUsuario() != null
                && tarefa.getUsuario().getId().equals(usuarioLogado.getId())) {
            tarefa.setConcluida(!tarefa.isConcluida());
            repository.save(tarefa);
        }
        return "redirect:/";
    }
}