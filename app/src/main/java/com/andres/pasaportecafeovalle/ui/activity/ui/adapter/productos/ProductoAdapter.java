package com.andres.pasaportecafeovalle.ui.activity.ui.adapter.productos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andres.pasaportecafeovalle.R;
import com.andres.pasaportecafeovalle.ui.activity.ui.adapter.sucursales.SucursalAdapter;
import com.andres.pasaportecafeovalle.ui.activity.ui.modelo.Producto;
import com.andres.pasaportecafeovalle.ui.activity.ui.modelo.Sucursal;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>{
    private List<Producto> listaProductos;
    private ProductoAdapter.OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(Producto producto);
    }

    public ProductoAdapter(List<Producto> listaProductos, ProductoAdapter.OnItemClickListener listener) {
        this.listaProductos = listaProductos;
        this.listener = listener;
    }

    // ViewHolder
    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView nombre, precio;

        public ProductoViewHolder(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imgProducto);
            nombre = itemView.findViewById(R.id.tvNombreProducto);
            precio = itemView.findViewById(R.id.tvPrecioProducto);

        }

        public void bind(final Producto producto, final ProductoAdapter.OnItemClickListener listener) {
            nombre.setText(producto.getNombre());
            precio.setText(String.valueOf("Precio: $" + producto.getPrecio()));
            imagen.setImageResource(producto.getImage());

            itemView.setOnClickListener(v -> listener.onItemClick(producto));
        }
    }

    @NonNull
    @Override
    public ProductoAdapter.ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);
        return new ProductoAdapter.ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ProductoViewHolder holder, int position) {
        holder.bind(listaProductos.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

}
