package com.andres.pasaportecafeovalle.ui.activity.ui.fragment.sucursales;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andres.pasaportecafeovalle.R;
import com.andres.pasaportecafeovalle.ui.activity.ui.adapter.sucursales.SucursalAdapter;
import com.andres.pasaportecafeovalle.ui.activity.ui.modelo.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class SucursalesFragment extends Fragment {
    /*
     * La clase SucursalesFragment extiende de Fragment y se encarga de mostrar
     * una lista de sucursales en un RecyclerView dentro del fragmento.
     *
     * 1. Atributos principales:
     *    - lista: contiene las sucursales que se van a mostrar (se inicializa con ArrayList).
     *    - view: referencia a la vista inflada del fragmento.
     *
     * 2. Metodo onCreateView:
     *    - Infla el layout "fragment_sucursales" para definir la interfaz del fragmento.
     *    - Agrega manualmente objetos Sucursal a la lista (con datos como imagen, nombre, dirección, horario y estado).
     *
     * 3. RecyclerView:
     *    - Se obtiene la referencia desde el layout mediante su ID (rvSucursales).
     *    - Se crea un SucursalAdapter, pasándole la lista y un listener de clics:
     *         a) Cuando el usuario selecciona una sucursal, se muestra un Toast con el nombre.
     *         b) (Comentado en el código) Aquí también podría abrirse un nuevo fragmento
     *            para mostrar el detalle de la sucursal seleccionada.
     *    - Se asigna un LinearLayoutManager al RecyclerView para mostrar la lista de forma vertical.
     *    - Se asocia el adapter al RecyclerView para que cargue los datos.
     *
     * En resumen:
     * Este fragmento construye y muestra una lista de sucursales en pantalla.
     * Permite detectar la selección de una sucursal para mostrar un mensaje o
     * abrir una vista con más detalles.
     */
    List<Sucursal> lista = new ArrayList<>();
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_sucursales, container, false);

        lista.add(new Sucursal(R.drawable.sucursal,"Café Ovalles", "Calle 123, Ovalle", "Lunes a Viernes: 8am - 8pm\nSábado y Domingo: 9am - 6pm", "Abierto"));
        lista.add(new Sucursal(R.drawable.sucursal,"Café Estrella", "Calle 123, Ovalle", "Lunes a Viernes: 8am - 8pm\nSábado y Domingo: 9am - 6pm", "Abierto"));
        lista.add(new Sucursal(R.drawable.sucursal,"Café las negras", "Calle 123, Ovalle", "Lunes a Viernes: 8am - 8pm\nSábado y Domingo: 9am - 6pm", "Abierto"));
        lista.add(new Sucursal(R.drawable.sucursal,"Café casas", "Calle 123, Ovalle", "Lunes a Viernes: 8am - 8pm\nSábado y Domingo: 9am - 6pm", "Abierto"));
        lista.add(new Sucursal(R.drawable.sucursal,"Café toras", "Calle 123, Ovalle", "Lunes a Viernes: 8am - 8pm\nSábado y Domingo: 9am - 6pm", "Abierto"));
        lista.add(new Sucursal(R.drawable.sucursal,"Café las palmas", "Calle 123, Ovalle", "Lunes a Viernes: 8am - 8pm\nSábado y Domingo: 9am - 6pm", "Abierto"));

        RecyclerView recyclerView = view.findViewById(R.id.rvSucursales);
        SucursalAdapter adapter = new SucursalAdapter(lista, sucursal -> {
            //aqui se abrira otro fragment con el detalle de la sucursal
            Toast.makeText(getContext(), "Sucursal: " + sucursal.getNombre(), Toast.LENGTH_SHORT).show();
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }
}
