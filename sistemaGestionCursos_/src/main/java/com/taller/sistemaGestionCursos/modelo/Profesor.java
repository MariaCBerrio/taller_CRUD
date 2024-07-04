package com.taller.sistemaGestionCursos.modelo;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String nombre;

    @NotNull
    @Column
    private String apellido;

    @ElementCollection
    private List<String> titulosAcademicos = new ArrayList<>();

    @NotNull
    @Column(name = "fecha_inicio_trabajo")
    private LocalDate fechaInicioTrabajo;

    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos;

    public Profesor(){
    }

    public Profesor(Long id, String nombre, String apellido, List<String> titulosAcademicos, LocalDate fechaInicioTrabajo, List<Curso> cursos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulosAcademicos = titulosAcademicos;
        this.fechaInicioTrabajo = fechaInicioTrabajo;
        this.cursos = cursos;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public List<String> getTitulosAcademicos() {
        return titulosAcademicos;
    }

    public LocalDate getFechaInicioTrabajo() {
        return fechaInicioTrabajo;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTitulosAcademicos(List<String> titulosAcademicos) {
        this.titulosAcademicos = titulosAcademicos;
    }

    public void setFechaInicioTrabajo(LocalDate fechaInicioTrabajo) {
        this.fechaInicioTrabajo = fechaInicioTrabajo;
    }
}
