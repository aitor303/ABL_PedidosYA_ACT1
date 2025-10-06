package model;

import java.io.Serializable;

public class Cliente implements Serializable {

    private static final Long serialVersionUID = 303L;
    private int id;
    private String nombre, email;

    //Constructor vacío
    public Cliente(){
    }
    //Contructor
    public Cliente(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }
    //setters getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //ToString
    public String toString(){
        return String.format("%d,%s,%s",id,nombre,email);
    }
}
