package org.example.modelo;

import jakarta.persistence.*;

// Esta clase representa una tabla en la base de datos
@Entity
@Table(name = "persona") // nombre exacto de la tabla en MySQL
public class Persona {

    @Id // clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremental
    private int id;

    private String nombre;
    private double altura;
    private double peso;
    private String tez;

    // ----- Getters y Setters obligatorios para JPA -----

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public String getTez() {
        return tez;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTez(String tez) {
        this.tez = tez;
    }
}
