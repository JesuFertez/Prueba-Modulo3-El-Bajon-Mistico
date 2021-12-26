package com.jesufertez.elbajonmistico.casodeuso;

import android.content.Context;

public class Repository {
    Context context;

    public Repository(Context context) {
    }


    public int opera(int subtotal) {
        int totalDescuento;

        if (subtotal >= 5000 && subtotal < 8000) {
            totalDescuento = subtotal * 5 / 100;

        } else if (subtotal > 8000) {
            totalDescuento = subtotal * 10 / 100;
        } else {
            totalDescuento = 0;
        }
        return totalDescuento;
    }

}


