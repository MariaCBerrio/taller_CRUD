package com.taller.sistemaGestionCursos.controlador;

import com.taller.sistemaGestionCursos.modelo.Curso;
import com.taller.sistemaGestionCursos.servicio.CursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/curso")
public class CursoControlador {

    private CursoServicio cursoServicio;

    @Autowired
    public CursoControlador(CursoServicio cursoServicio){
        this.cursoServicio = cursoServicio;
    }

    @PostMapping()
    public ResponseEntity<String> crearCurso(@RequestBody Curso curso){
        this.cursoServicio.crearCurso(curso);
        return ResponseEntity.ok("Se creó el curso correctamente");
    }

    @GetMapping("/{id_curso]")
    public Curso obtenerCursoPorId(@PathVariable("id_curso") Long id){
        return this.cursoServicio.obtenerCursoPorId(id);
    }

    @GetMapping()
    public List<Curso> obtenerCursos(){
        return this.cursoServicio.obtenerCursos();
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable Long id, @RequestBody Curso curso){
        return cursoServicio.actualizarCurso(id, curso);
    }

    @DeleteMapping("/{id]")
    public void eliminarCurso(@PathVariable Long id){
        cursoServicio.eliminarCurso(id);
    }
}
