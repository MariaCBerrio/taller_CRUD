package com.taller.sistemaGestionCursos.modelo;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String nombre;

    @NotNull
    @Column
    private String descripcion;

    @NotNull
    @Column
    private String materia;

    @ManyToOne()
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @OneToMany(mappedBy = "curso")
    private List<Matricula> estudiantes;

    public Curso(){
    }

    public Curso(Long id, String nombre, String descripcion, String materia, Profesor profesor, List<Matricula> estudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.materia = materia;
        this.profesor = profesor;
        this.estudiantes = estudiantes;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMateria() {
        return materia;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public List<Matricula> getEstudiantes() {
        return estudiantes;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setMateria(String materia){
        this.materia = materia;
    }

    public  void setProfesor(Profesor profesor){
        this.profesor = profesor;
    }

    public void setEstudiantes(List<Matricula> estudiantes){
        this.estudiantes = estudiantes;
    }
}
