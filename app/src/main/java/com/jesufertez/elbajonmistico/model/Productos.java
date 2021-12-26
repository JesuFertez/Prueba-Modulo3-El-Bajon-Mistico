package com.jesufertez.elbajonmistico.model;

import android.widget.ImageView;

public class Productos {
    String producto;
    String ingredientes;
    int imagen;
    int precio;
    boolean estado =false;

    public Productos(String producto, String ingredientes, int imagen, int precio, boolean estado) {
        this.producto = producto;
        this.ingredientes = ingredientes;
        this.imagen = imagen;
        this.precio = precio;
        this.estado = estado;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "producto='" + producto + '\'' +
                ", ingredientes='" + ingredientes + '\'' +
                ", imagen=" + imagen +
                ", precio=" + precio +
                ", estado=" + estado +
                '}';
    }
}
