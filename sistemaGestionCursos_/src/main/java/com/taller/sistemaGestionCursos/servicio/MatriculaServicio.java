package com.taller.sistemaGestionCursos.servicio;

import com.taller.sistemaGestionCursos.modelo.Matricula;
import com.taller.sistemaGestionCursos.repositorio.MatriculaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServicio {
    private MatriculaRepositorio matriculaRepositorio;

    @Autowired
    public MatriculaServicio(MatriculaRepositorio matriculaRepositorio) {
        this.matriculaRepositorio = matriculaRepositorio;
    }

    public void crearMatricula(Matricula matricula) {
        this.matriculaRepositorio.save(matricula);
    }

    public Matricula obtenerMatriculaPorId(Long id) {
        Optional<Matricula> matriculaOptional = this.matriculaRepositorio.findById(id);
        if (matriculaOptional.isPresent()) {
            return matriculaOptional.get();
        }
        return new Matricula();
    }

    public List<Matricula> obtenerMatriculas() {
        return this.matriculaRepositorio.findAll();
    }

    public void eliminarMatricula(Long id){
        this.matriculaRepositorio.deleteById(id);
    }

    public Matricula actualizarMatricula(Matricula matricula) {
        Optional<Matricula> matriculaOptional = this.matriculaRepositorio.findById(matricula.getId());
        if (matriculaOptional.isPresent()) {
            Matricula matriculaExistente = matriculaOptional.get();
            matriculaExistente.setFechaMatricula(matricula.getFechaMatricula());
            matriculaExistente.setFechaCancelacion(matricula.getFechaCancelacion());
            matriculaExistente.setEstudiante(matricula.getEstudiante());
            matriculaExistente.setCurso(matricula.getCurso());
            return this.matriculaRepositorio.save(matriculaExistente);
        }
        return new Matricula();
    }

}
