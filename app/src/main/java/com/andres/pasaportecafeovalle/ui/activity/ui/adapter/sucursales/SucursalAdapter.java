package com.andres.pasaportecafeovalle.ui.activity.ui.adapter.sucursales;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andres.pasaportecafeovalle.R;
import com.andres.pasaportecafeovalle.ui.activity.ui.modelo.Sucursal;

import java.util.List;



public class SucursalAdapter extends RecyclerView.Adapter<SucursalAdapter.SucursalViewHolder> {
    /*
     * La clase SucursalAdapter extiende de RecyclerView.Adapter y se utiliza para
     * mostrar una lista de sucursales dentro de un RecyclerView.
     *
     * 1. Atributos principales:
     *    - listaSucursales: contiene los datos de cada sucursal (nombre, dirección, horario, imagen).
     *    - listener: interfaz para manejar los clics en los elementos de la lista.
     *
     * 2. Interfaz OnItemClickListener:
     *    - Define el metodo onItemClick(Sucursal sucursal) que se ejecuta cuando
     *      el usuario toca una sucursal en la lista.
     *    - Permite comunicar el clic desde el adapter hacia la actividad/fragmento.
     *
     * 3. Constructor:
     *    - Recibe la lista de sucursales y el listener que manejará los clics.
     *
     * 4. Clase interna SucursalViewHolder:
     *    - Representa la vista de un solo elemento (item) de la lista.
     *    - Contiene referencias a los componentes gráficos: imagen, nombre, dirección y horario.
     *    - El metodo bind() se encarga de:
     *        a) Asignar los valores de la sucursal a los TextView e ImageView.
     *        b) Configurar el evento de clic para enviar la sucursal seleccionada al listener.
     *
     * 5. Métodos sobrescritos del Adapter:
     *    - onCreateViewHolder: infla (crea) el layout XML de un item (item_sucursal).
     *    - onBindViewHolder: vincula los datos de una sucursal con su ViewHolder correspondiente.
     *    - getItemCount: devuelve el número total de sucursales en la lista.
     *
     * En resumen:
     * Este adapter toma una lista de objetos "Sucursal", los muestra en un RecyclerView
     * y notifica a la actividad/fragmento cuando el usuario selecciona una sucursal.
     */
    private List<Sucursal> listaSucursales;
    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(Sucursal sucursal);
    }

    public SucursalAdapter(List<Sucursal> listaSucursales, OnItemClickListener listener) {
        this.listaSucursales = listaSucursales;
        this.listener = listener;
    }

    // ViewHolder
    public static class SucursalViewHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView nombre, direccion, horario;

        public SucursalViewHolder(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imgSucursal);
            nombre = itemView.findViewById(R.id.tvNombreSucursal);
            direccion = itemView.findViewById(R.id.tvDireccion);
            horario = itemView.findViewById(R.id.tvHorario);
        }

        public void bind(final Sucursal sucursal, final OnItemClickListener listener) {
            nombre.setText(sucursal.getNombre());
            direccion.setText(sucursal.getDireccion());
            horario.setText(sucursal.getHorario());
            imagen.setImageResource(sucursal.getImagen());

            itemView.setOnClickListener(v -> listener.onItemClick(sucursal));
        }
    }

    @NonNull
    @Override
    public SucursalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sucursal, parent, false);
        return new SucursalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SucursalViewHolder holder, int position) {
        holder.bind(listaSucursales.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return listaSucursales.size();
    }
}