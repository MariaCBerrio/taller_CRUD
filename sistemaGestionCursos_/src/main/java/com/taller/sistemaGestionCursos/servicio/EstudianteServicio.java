package com.taller.sistemaGestionCursos.servicio;

import com.taller.sistemaGestionCursos.modelo.Estudiante;
import com.taller.sistemaGestionCursos.repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EstudianteServicio {

    private final EstudianteRepositorio estudianteRepositorio;

    @Autowired
    public EstudianteServicio(EstudianteRepositorio estudianteRepositorio) {
        this.estudianteRepositorio = estudianteRepositorio;
    }

    public void crearEstudiante(Estudiante estudiante) {
        this.estudianteRepositorio.save(estudiante);
    }

    public void verificarSiEstudianteExisteSegunId(Long id) {
        estudianteRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estudiante con id: " + id + " no encontrado"));
    }

    public Estudiante obtenerEstudiantePorId(Long id) {
        return estudianteRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estudiante con id: " + id + " no encontrado"));
    }

    public List<Estudiante> obtenerEstudiantes() {
        return estudianteRepositorio.findAll();
    }

    @Transactional
    public void editarEstudiantePorId(Long id, String nuevoNombre, String nuevoApellido, LocalDate nuevaFechaNacimiento) {
        verificarSiEstudianteExisteSegunId(id);
        estudianteRepositorio.updateStudent(id, nuevoNombre, nuevoApellido, nuevaFechaNacimiento);
    }

    @Transactional
    public void eliminarEstudiantePorId(Long id) {
        verificarSiEstudianteExisteSegunId(id);
        estudianteRepositorio.deleteById(id);
    }
}
