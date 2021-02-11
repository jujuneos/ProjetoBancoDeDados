package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

import Controllers.Urls;
import Models.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaUsuarios extends AppCompatActivity {

    Intent intent = getIntent();
    TextView resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        resultados = (TextView) findViewById(R.id.lista_p);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://deezefy.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Urls request = retrofit.create(Urls.class);
        Call<List<Usuario>> call = request.getUsers();
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                resultados.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }
}