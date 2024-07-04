package com.taller.sistemaGestionCursos.repositorio;

import com.taller.sistemaGestionCursos.modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {

    @Modifying
    @Query("UPDATE Estudiante e SET e.nombre = :nuevoNombre, e.apellido = :nuevoApellido, e.fechaNacimiento = :nuevaFechaNacimiento WHERE e.id = :id")
    void updateStudent(
            @Param("id") Long id,
            @Param("nuevoNombre") String nuevoNombre,
            @Param("nuevoApellido") String nuevoApellido,
            @Param("nuevaFechaNacimiento")LocalDate nuevaFechaNacimiento
    );
}
