package com.andres.pasaportecafeovalle.ui.activity.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.andres.pasaportecafeovalle.R;
import com.andres.pasaportecafeovalle.ui.activity.ui.adminfragment.FragmentAdminBeneficios;
import com.andres.pasaportecafeovalle.ui.activity.ui.adminfragment.FragmentAdminClientes;
import com.andres.pasaportecafeovalle.ui.activity.ui.adminfragment.FragmentAdminProductos;
import com.andres.pasaportecafeovalle.ui.activity.ui.adminfragment.FragmentAdminSucursales;
import com.andres.pasaportecafeovalle.ui.activity.ui.adminfragment.FragmentReportes;
import com.andres.pasaportecafeovalle.ui.activity.ui.fragment.beneficios.BeneficiosFragment;
import com.andres.pasaportecafeovalle.ui.activity.ui.fragment.home.HomeFragment;
import com.andres.pasaportecafeovalle.ui.activity.ui.fragment.perfil.PerfilFragment;
import com.andres.pasaportecafeovalle.ui.activity.ui.fragment.productos.ProductosFragment;
import com.andres.pasaportecafeovalle.ui.activity.ui.fragment.sucursales.SucursalesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        String correo = getIntent().getStringExtra("correo");

        if (correo != null) {
            switch (correo){
                case "admin":
                    bottomNavigationView.inflateMenu(R.menu.menu_nav_admin);
                    break;
                case "cliente":
                    bottomNavigationView.inflateMenu(R.menu.menu_nav_icon);
                    break;
            }
        }
        //Los fragment por defecto xd
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                selectedFragment = new HomeFragment();
            } else if (itemId == R.id.nav_beneficios) {
                selectedFragment = new BeneficiosFragment();
            } else if (itemId == R.id.nav_perfil) {
                selectedFragment = new PerfilFragment();
            } else if (itemId == R.id.nav_productos) {
                selectedFragment = new ProductosFragment();
            } else if (itemId == R.id.nav_sucursales) {
                selectedFragment = new SucursalesFragment();
            }

            if (itemId == R.id.nav_adminproductos) {
                selectedFragment = new FragmentAdminProductos();
            } else if (itemId == R.id.nav_adminbeneficios) {
                selectedFragment = new FragmentAdminBeneficios();
            } else if (itemId == R.id.nav_adminclientes) {
                selectedFragment = new FragmentAdminClientes();
            } else if (itemId == R.id.nav_adminreportes) {
                selectedFragment = new FragmentReportes();
            } else if (itemId == R.id.nav_adminsucursales) {
                selectedFragment = new FragmentAdminSucursales();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }
            return true;
        });
    }
}