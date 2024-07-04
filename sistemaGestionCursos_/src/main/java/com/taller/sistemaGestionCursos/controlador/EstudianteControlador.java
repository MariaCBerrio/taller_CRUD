package com.taller.sistemaGestionCursos.controlador;

import com.taller.sistemaGestionCursos.modelo.Estudiante;
import com.taller.sistemaGestionCursos.servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/estudiantes")
public class EstudianteControlador {

    private final EstudianteServicio estudianteServicio;

    @Autowired
    public EstudianteControlador(EstudianteServicio estudianteServicio) {
        this.estudianteServicio = estudianteServicio;
    }

    @PostMapping
    public ResponseEntity<String> crearEstudiante(@RequestBody Estudiante estudiante) {
        estudianteServicio.crearEstudiante(estudiante);
        return ResponseEntity.ok("El registro del estudiante ha sido exitoso");
    }

    @GetMapping("/{id}/verificar")
    public ResponseEntity<String> verificarSiEstudianteExisteSegunId(@PathVariable("id") Long id) {
        estudianteServicio.verificarSiEstudianteExisteSegunId(id);
        return ResponseEntity.ok("El estudiante con id: " + id + " sí existe en los registros");
    }

    @GetMapping("/{id}")
    public Estudiante obtenerEstudiantePorId(@PathVariable("id") Long id) {
        return estudianteServicio.obtenerEstudiantePorId(id);
    }

    @GetMapping
    public List<Estudiante> obtenerEstudiantes() {
        return estudianteServicio.obtenerEstudiantes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarEstudiante(@PathVariable("id") Long id, @RequestParam String nuevoNombre, @RequestParam String nuevoApellido, @RequestParam LocalDate nuevaFechaNacimiento) {
        estudianteServicio.editarEstudiantePorId(id, nuevoNombre, nuevoApellido, nuevaFechaNacimiento);
        return ResponseEntity.ok("El estudiante ha sido editado con éxito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEstudiantePorId(@PathVariable("id") Long id) {
        estudianteServicio.eliminarEstudiantePorId(id);
        return ResponseEntity.ok("El estudiante con id: " + id + " ha sido eliminado con éxito");
    }
}
