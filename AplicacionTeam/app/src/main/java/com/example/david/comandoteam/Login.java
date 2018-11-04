package com.example.david.comandoteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.SQLException;

import Control.*;

public class Login extends AppCompatActivity {
    private Facade facade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        facade= Facade.UnicaInstancia();
        Button login = (Button) findViewById(R.id.ButtonIngresar);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText cod = (EditText) findViewById(R.id.TxCodigo);
                int codigo = Integer.parseInt(cod.getText().toString());
                EditText clav= (EditText) findViewById(R.id.TxContrasena);
                String contrasena = clav.getText().toString();
                try {
                    facade.ingresar(codigo,contrasena);
                    startActivity(new Intent(Login.this,Entrada.class));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
