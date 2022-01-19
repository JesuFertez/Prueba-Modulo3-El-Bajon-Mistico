package com.jesufertez.elbajonmistico.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.airbnb.lottie.LottieAnimationView;
import com.jesufertez.elbajonmistico.R;
import com.jesufertez.elbajonmistico.adapter.ProductosAdapter;
import com.jesufertez.elbajonmistico.databinding.ActivityMainBinding;
import com.jesufertez.elbajonmistico.casodeuso.RecyclerClickInterface;
import com.jesufertez.elbajonmistico.casodeuso.Repository;
import com.jesufertez.elbajonmistico.model.Productos;
import com.jesufertez.elbajonmistico.model.ProductosData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerClickInterface {

    private ActivityMainBinding binding;
    private Repository repo;
    ProductosAdapter adapter;
    int total=0;
    int subtotal=0;
    int totalDescuento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initRecycler();
        initRepo();
        resetCampos();
        initTituloApp();
    }

    private void initTituloApp() {
        getSupportActionBar().setTitle("El Bajón Místico");
    }

    private void resetCampos() {
        binding.btnReset.setOnClickListener(view -> {
             subtotal = 0;
            totalDescuento = 0;
            total = 0;
            binding.tvSubTotalMonto.setText("");
            binding.tvTotalDescuentos.setText("");
            binding.tvTotalMonto.setText("");
            initRecycler();
        });
    }

    private void initRepo() {
        repo = new Repository(this);
    }

    private void initRecycler() {
        adapter = new ProductosAdapter((ArrayList<Productos>) ProductosData.productosList(), this);
        binding.rvProductos.setLayoutManager(new LinearLayoutManager(this));
        binding.rvProductos.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position, int valor, boolean estado) {

        if(!estado){
        subtotal=subtotal+valor;
        binding.tvSubTotalMonto.setText(String.valueOf(subtotal));

        totalDescuento= repo.opera(subtotal);
        binding.tvTotalDescuentos.setText(String.valueOf(totalDescuento));

        total=subtotal-totalDescuento;
        binding.tvTotalMonto.setText(String.valueOf(total));
        }
        if(estado){
            subtotal=subtotal-valor;
            binding.tvSubTotalMonto.setText(String.valueOf(subtotal));

            totalDescuento= repo.opera(subtotal);
            binding.tvTotalDescuentos.setText(String.valueOf(totalDescuento));

            total=subtotal;
            binding.tvTotalMonto.setText(String.valueOf(total));
        }
    }
}