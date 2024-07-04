package com.taller.sistemaGestionCursos.controlador;

import com.taller.sistemaGestionCursos.modelo.Profesor;
import com.taller.sistemaGestionCursos.servicio.ProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("api/v1/profesores")
public class ProfesorControlador {

    private ProfesorServicio profesorServicio;

    @Autowired
    public ProfesorControlador(ProfesorServicio profesorServicio){
        this.profesorServicio = profesorServicio;
    }

    @PostMapping
    public ResponseEntity<String> crearProfesor(@RequestBody Profesor profesor){
        this.profesorServicio.crearProfesor(profesor);
        return  ResponseEntity.ok("Profesor creado con éxito.");
    }

    @GetMapping("/{id_profesor}")
    public Profesor obtenerProfesorPorId(@PathVariable("id_profesor") Long id){
        return this.profesorServicio.obtenerProfesorPorId(id);
    }

    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerProfesores() {
        List<Profesor> profesores = profesorServicio.obtenerProfesores();
        return ResponseEntity.ok(profesores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProfesorPorId(@PathVariable Long id) {
        profesorServicio.eliminarProfesorPorId(id);
        return ResponseEntity.ok("Eliminado con éxito.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarProfesor(@PathVariable Long id, @RequestBody Profesor profesorActualizado) {
        Profesor profesor = profesorServicio.actualizarProfesor(id, profesorActualizado);
        if (profesor != null) {
            return ResponseEntity.ok("Actualizado con éxito.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
