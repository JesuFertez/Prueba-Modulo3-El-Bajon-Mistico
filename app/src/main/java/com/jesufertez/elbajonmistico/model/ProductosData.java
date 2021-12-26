package com.jesufertez.elbajonmistico.model;

import com.jesufertez.elbajonmistico.R;

import java.util.ArrayList;
import java.util.List;


public class ProductosData {
    public static List<Productos> productosList() {
        List<Productos> productosList = new ArrayList<>();

        Productos chacarero = new Productos("Chacarero", "Carne, Tomate, Porotos Verdes, Aji, Mayonesa",R.drawable.chacarero, 3500,false);
        Productos barrosLuco = new Productos("Barros Luco", "Carne, Queso", R.drawable.luco, 3800,false);
        Productos italiano = new Productos("Italiano", "Carne, Tomate, Palta, Mayonesa",R.drawable.italiano, 3500,false);
        Productos dinamico = new Productos("Dinámico", "Carne, Tomate, Palta, Salsa Americana, Mayonesa",R.drawable.dinamico, 4000,false);

        productosList.add(chacarero);
        productosList.add(barrosLuco);
        productosList.add(italiano);
        productosList.add(dinamico);

        return productosList;
    }
}
