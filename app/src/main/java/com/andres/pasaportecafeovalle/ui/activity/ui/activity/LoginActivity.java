package com.andres.pasaportecafeovalle.ui.activity.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.andres.pasaportecafeovalle.R;

public class LoginActivity extends AppCompatActivity {
    Button btnRegistro;
    Button btnLogin;

    EditText txtCorreo;
    EditText txtPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRegistro = findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
            startActivity(intent);
        });

        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(v -> {
            txtCorreo = findViewById(R.id.txtCorreo);
            String correo = txtCorreo.getText().toString();
            if (correo.isEmpty() || (!correo.equals("admin") && !correo.equals("cliente"))) {
                txtCorreo.setError("Ingrese un correo válido (admin o cliente)");
                return;
            }
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();


        });
    }
}
