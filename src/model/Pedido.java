package model;

import java.io.Serializable;

public class Pedido implements Serializable {
    private static final Long serialVersionUID = 303L;
    private int id, clienteid, cantidad;
    private String producto;
    //Constructor vacío
    public Pedido() {
    }
    //Constructor
    public Pedido(int id, int clienteid, String producto, int cantidad) {
        this.id = id;
        this.clienteid = clienteid;
        this.producto = producto;
        this.cantidad = cantidad;
    }
    //Setters Getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    //ToString
    public String toString(){
        return String.format("%d,%d,%s,%s",id,clienteid,producto,cantidad);
    }
}
