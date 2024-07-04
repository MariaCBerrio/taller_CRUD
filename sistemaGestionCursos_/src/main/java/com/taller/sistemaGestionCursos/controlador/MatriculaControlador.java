package com.taller.sistemaGestionCursos.controlador;

import com.taller.sistemaGestionCursos.modelo.Matricula;
import com.taller.sistemaGestionCursos.servicio.MatriculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/matriculas")
public class MatriculaControlador {

    private MatriculaServicio matriculaServicio;

    @Autowired
    public MatriculaControlador(MatriculaServicio matriculaServicio){
        this.matriculaServicio = matriculaServicio;

    }
    @PostMapping()
    public ResponseEntity<String> crearMatricula(@RequestBody Matricula matricula){
        this.matriculaServicio.crearMatricula(matricula);
        return ResponseEntity.ok("Se creo el autor correctamente");
    }
    @GetMapping("{id}")
    public Matricula obtenerMatriculaPorId(@PathVariable("id") Long id){
        return this.matriculaServicio.obtenerMatriculaPorId(id);
    }
    @GetMapping()
    public List<Matricula> obtenerMatriculas(){
        return this.matriculaServicio.obtenerMatriculas();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarMatricula(@PathVariable("id") Long id) {
        this.matriculaServicio.eliminarMatricula(id);
        return ResponseEntity.ok("Se eliminó la matrícula correctamente");
    }

    @PutMapping("{id}")
    public ResponseEntity<Matricula> actualizarMatricula(@PathVariable("id") Long id, @RequestBody Matricula matricula) {
        matricula.setId(id);
        Matricula matriculaActualizada = this.matriculaServicio.actualizarMatricula(matricula);
        return ResponseEntity.ok(matriculaActualizada);
    }
}

