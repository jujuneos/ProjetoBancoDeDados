package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = (Button) findViewById(R.id.entra);
        Button bt2 = (Button) findViewById(R.id.novo);
        Button bt3 = (Button) findViewById(R.id.listar);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intencao = new Intent(MainActivity.this, ListaMusicas.class);
                startActivity(intencao);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencao = new Intent(MainActivity.this, NovoUsuario.class);
                startActivity(intencao);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencao = new Intent(MainActivity.this, ListaUsuarios.class);
                startActivity(intencao);
            }
        });

    }
}