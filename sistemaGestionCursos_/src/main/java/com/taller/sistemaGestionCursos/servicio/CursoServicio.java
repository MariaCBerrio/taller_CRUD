package com.taller.sistemaGestionCursos.servicio;

import com.taller.sistemaGestionCursos.modelo.Curso;
import com.taller.sistemaGestionCursos.repositorio.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServicio {
    private CursoRepositorio cursoRepositorio;

    @Autowired
    public CursoServicio(CursoRepositorio cursoRepositorio){
        this.cursoRepositorio = cursoRepositorio;
    }

    public void crearCurso(Curso curso){
        this.cursoRepositorio.save(curso);
    }

    public Curso obtenerCursoPorId(Long idCurso){
        Optional<Curso> cursoOptional = this.cursoRepositorio.findById(idCurso);
        if (cursoOptional.isPresent()){
            return cursoOptional.get();
        }
        return new Curso();
    }

    public List<Curso> obtenerCursos(){
        List<Curso> cursos = this.cursoRepositorio.findAll();
        if (cursos.isEmpty()){
            return new ArrayList<>();
        }
        return cursos;
    }

    public Curso actualizarCurso(Long idCurso, Curso cursoActualizar){
        Optional<Curso> cursoOptional = cursoRepositorio.findById(idCurso);
        if (cursoOptional.isPresent()){
            Curso curso = cursoOptional.get();
            curso.setNombre(cursoActualizar.getNombre());
            curso.setDescripcion(cursoActualizar.getDescripcion());
            curso.setMateria(cursoActualizar.getMateria());
            curso.setProfesor(cursoActualizar.getProfesor());
            curso.setEstudiantes(cursoActualizar.getEstudiantes());
            return cursoRepositorio.save(curso);
        } else {
            throw new RuntimeException("Curso no encontrado con id " + idCurso);
        }
    }

    public void eliminarCurso(Long idCurso){
        if (cursoRepositorio.existsById(idCurso)){
            cursoRepositorio.deleteById(idCurso);
        } else {
            throw new RuntimeException("Curso no encontrado");
        }
    }
}
