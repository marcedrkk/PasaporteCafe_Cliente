package com.andres.pasaportecafeovalle.ui.activity.ui.fragment.productos;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andres.pasaportecafeovalle.R;
import com.andres.pasaportecafeovalle.ui.activity.ui.adapter.productos.ProductoAdapter;
import com.andres.pasaportecafeovalle.ui.activity.ui.adapter.sucursales.SucursalAdapter;
import com.andres.pasaportecafeovalle.ui.activity.ui.modelo.Producto;
import com.andres.pasaportecafeovalle.ui.activity.ui.modelo.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class ProductosFragment extends Fragment {
    List<Producto> lista = new ArrayList<>();
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_productos, container, false);

        lista.add(new Producto(R.drawable.torta,"Torta de chocolate", 2500));
        lista.add(new Producto(R.drawable.cafe,"Café Estrella", 3000));
        lista.add(new Producto(R.drawable.cafe,"Café las negras", 1500));
        lista.add(new Producto(R.drawable.galletas,"Galletas de vainilla", 3000));
        lista.add(new Producto(R.drawable.cafe,"Café toras", 2000));
        lista.add(new Producto(R.drawable.te,"Te negro", 1000));

        RecyclerView recyclerView = view.findViewById(R.id.rvProductos);
        ProductoAdapter adapter = new ProductoAdapter(lista, producto -> {
            //aqui se abrira otro fragment con el detalle del producto
            Toast.makeText(getContext(), "producto: " + producto.getNombre(), Toast.LENGTH_SHORT).show();
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }
}
