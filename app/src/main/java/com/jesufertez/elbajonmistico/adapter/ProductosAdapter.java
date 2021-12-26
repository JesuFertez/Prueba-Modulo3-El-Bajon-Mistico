package com.jesufertez.elbajonmistico.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jesufertez.elbajonmistico.R;
import com.jesufertez.elbajonmistico.databinding.ItemLayoutBinding;
import com.jesufertez.elbajonmistico.casodeuso.RecyclerClickInterface;
import com.jesufertez.elbajonmistico.model.Productos;

import java.util.ArrayList;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductosViewHolder> {

    private ArrayList<Productos> lista;
    private RecyclerClickInterface recyclerClickInterface;


    public ProductosAdapter(ArrayList<Productos> lista, RecyclerClickInterface recyclerClickInterface) {
        this.lista = lista;
        this.recyclerClickInterface = recyclerClickInterface;

    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosViewHolder holder, int position) {
        holder.bindData(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public class ProductosViewHolder extends RecyclerView.ViewHolder {
        private ItemLayoutBinding binding;
        int total,valor,subTotal;

        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemLayoutBinding.bind(itemView);
            int total;
            int valor;
            int subTotal;
        }

        public void bindData(Productos productos) {
            binding.tvProducto.setText(productos.getProducto());
            binding.tvPrecio.setText("$ " + String.valueOf(productos.getPrecio()));
            binding.tvIngredientes.setText(productos.getIngredientes());
            binding.ivProducto.setImageResource(productos.getImagen());

            itemView.setOnClickListener(view -> {
            recyclerClickInterface.onItemClick(getAdapterPosition(), productos.getPrecio(),productos.isEstado());

            valor=productos.getPrecio();
                if(itemView.isPressed()&&!productos.isEstado()){
                    productos.setEstado(true);
                    notifyItemChanged(getLayoutPosition());
                }else if (itemView.isPressed()&& productos.isEstado()){
                    productos.setEstado(false);
                }
            });
        }
    }
}