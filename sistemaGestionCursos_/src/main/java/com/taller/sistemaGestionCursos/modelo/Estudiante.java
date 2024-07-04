package com.taller.sistemaGestionCursos.modelo;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String nombre;

    @NotNull
    @Column
    private String apellido;

    @NotNull
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
                                                                                         //cascade se usa para propagar las operaciones realizada en una entidad a las entidades relacionadas
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true) //orphanRemoval elimina automáticamente de la base de datos las entidades que no ya no estén referenciadas por la entidad principal
    private List<Matricula> cursos = new ArrayList<>();

    public Estudiante(){
    }

    public Estudiante(Long id, String nombre, String apellido, LocalDate fechaNacimiento, List<Matricula> cursos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public List<Matricula> getCursos() {
        return cursos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

