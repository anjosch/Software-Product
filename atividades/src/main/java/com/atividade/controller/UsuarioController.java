package com.atividade.controller;

import com.atividade.model.Usuario;
import com.atividade.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Abre a tela de login
    @GetMapping("/login")
    public String telaLogin() {
        return "login";
    }

    // Abre a tela de cadastro de novo usuário
    @GetMapping("/cadastro")
    public String telaCadastro() {
        return "cadastro";
    }

    // Salva o novo usuário no banco MySQL
    @PostMapping("/cadastrarUsuario")
    public String cadastrar(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/login?cadastrado=true";
    }

    // Valida o login no banco
    @PostMapping("/efetuarLogin")
    public String efetuarLogin(@RequestParam String email,
                               @RequestParam String senha,
                               HttpSession session,
                               Model model) {
        Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);
        if (usuario != null) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/"; // Vai para a tela de tarefas
        } else {
            model.addAttribute("erro", "E-mail ou senha inválidos!");
            return "login";
        }
    }

    // Faz o logout e limpa a sessão
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}