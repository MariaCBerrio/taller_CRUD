package com.taller.sistemaGestionCursos.servicio;

import com.taller.sistemaGestionCursos.repositorio.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.taller.sistemaGestionCursos.modelo.Profesor;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServicio {

    private ProfesorRepositorio profesorRepositorio;

    @Autowired
    public ProfesorServicio(ProfesorRepositorio profesorRepositorio){
        this.profesorRepositorio = profesorRepositorio;
    }

    //crear profesor
    public void crearProfesor(Profesor profesor){
        this.profesorRepositorio.save(profesor);
    }

    //obtener profesor por Id
    public Profesor obtenerProfesorPorId(Long id){
        Optional<Profesor> profesorOptional = this.profesorRepositorio.findById(id);
        if (profesorOptional.isPresent()){
            return profesorOptional.get();
        }
        return new Profesor();
    }

    //obtener todos los profesores
    public List<Profesor> obtenerProfesores(){
        return this.profesorRepositorio.findAll();
    }

    //eliminar profesor por ID
    public void eliminarProfesorPorId(Long id){
        profesorRepositorio.deleteById(id);
    }

    //actualizar profesor
    @Transactional
    public Profesor actualizarProfesor(Long id, Profesor profesorActualizado) {
        Optional<Profesor> optionalProfesor = profesorRepositorio.findById(id);

        if (optionalProfesor.isPresent()) {
            Profesor profesorExistente = optionalProfesor.get();

            profesorExistente.setNombre(profesorActualizado.getNombre());
            profesorExistente.setApellido(profesorActualizado.getApellido());
            profesorExistente.setTitulosAcademicos(profesorActualizado.getTitulosAcademicos());
            profesorExistente.setFechaInicioTrabajo(profesorActualizado.getFechaInicioTrabajo());

            return profesorRepositorio.save(profesorExistente);
        }
        return new Profesor();
    }
}
