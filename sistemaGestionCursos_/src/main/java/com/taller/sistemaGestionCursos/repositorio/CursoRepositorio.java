package com.taller.sistemaGestionCursos.repositorio;

import com.taller.sistemaGestionCursos.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Long> {
}
