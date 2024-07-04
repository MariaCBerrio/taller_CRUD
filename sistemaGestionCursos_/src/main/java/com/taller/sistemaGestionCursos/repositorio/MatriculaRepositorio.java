package com.taller.sistemaGestionCursos.repositorio;

import com.taller.sistemaGestionCursos.modelo.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepositorio extends JpaRepository<Matricula, Long> {
}
