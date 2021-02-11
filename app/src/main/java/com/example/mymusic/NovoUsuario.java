package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Controllers.Urls;
import Models.Usuario;
import Models.UsuarioDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NovoUsuario extends AppCompatActivity {

    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://deezefy.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final EditText email = findViewById(R.id.email);
        final EditText senha = findViewById(R.id.senha);
        Button cadastrar = findViewById(R.id.button);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String novoEmail = email.getText().toString();
                String novaSenha = senha.getText().toString();
                Urls inserir = retrofit.create(Urls.class);
                UsuarioDTO u = new UsuarioDTO();
                u.setEmail(novoEmail);
                u.setSenha(novaSenha);
                Call<Boolean> user = inserir.inserirUsuario(u);

                user.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if(response.isSuccessful()) {
                            if (response.body()) {
                                Toast.makeText(getApplicationContext(), "Inserido com sucesso!", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Falha na inserção.", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "Erro: " + response.code(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro kkkkkk",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}