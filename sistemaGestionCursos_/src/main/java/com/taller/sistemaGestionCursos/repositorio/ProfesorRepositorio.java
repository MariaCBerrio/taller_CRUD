package com.taller.sistemaGestionCursos.repositorio;

import com.taller.sistemaGestionCursos.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor, Long> {
}
