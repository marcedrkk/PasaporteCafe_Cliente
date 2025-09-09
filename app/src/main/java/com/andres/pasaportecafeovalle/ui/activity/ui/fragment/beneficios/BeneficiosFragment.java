package com.andres.pasaportecafeovalle.ui.activity.ui.fragment.beneficios;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.andres.pasaportecafeovalle.R;
import com.andres.pasaportecafeovalle.ui.activity.ui.adapter.beneficios.BeneficioAdapter;
import com.andres.pasaportecafeovalle.ui.activity.ui.adapter.productos.ProductoAdapter;
import com.andres.pasaportecafeovalle.ui.activity.ui.modelo.Beneficio;
import com.andres.pasaportecafeovalle.ui.activity.ui.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class BeneficiosFragment extends Fragment {

    List<Beneficio> lista = new ArrayList<>();
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_beneficios, container, false);

        lista.add(new Beneficio("Super cafe", "Descuento", 5, 80, "No alcanzado"));
        lista.add(new Beneficio("Super galleta", "Descuento", 10, 100, "No alcanzado"));
        lista.add(new Beneficio("Super te", "Descuento", 2, 30, "Alcanzado"));
        lista.add(new Beneficio("Super torta", "Producto gratis", 3, 50, "No alcanzado"));
        lista.add(new Beneficio("Super cafe", "Descuento", 7, 80, "No alcanzado"));
        lista.add(new Beneficio("Super premio", "5 producto gratis", 20, 100, "No alcanzado"));


        RecyclerView recyclerView = view.findViewById(R.id.rvBeneficios);
        BeneficioAdapter adapter = new BeneficioAdapter(lista, beneficio -> {

            Toast.makeText(getContext(), "beneficio: " + beneficio.getNombre(), Toast.LENGTH_SHORT).show();
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }
}

