package com.atividade.repository;

import com.atividade.model.Tarefa;
import com.atividade.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByUsuario(Usuario usuario);
}