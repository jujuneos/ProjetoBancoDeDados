package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaMusicas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        Intent intencao = getIntent();
        String text = intencao.getStringExtra("text");

        //TextView tv =(TextView) findViewById(R.id.TTela2);
        //tv.setText(text);

        ListView lista = (ListView) findViewById(R.id.litsta_p);
        final ArrayList<String> music = preencherDados();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,music);
        lista.setAdapter(arrayAdapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0 ){
                    Intent intencao = new Intent(ListaMusicas.this, Tela3.class);
                    startActivity(intencao);}
                else {
                    Toast.makeText(getApplicationContext(),"Erro não foi possivel acessar a Música: "+music.get(i).toString(),Toast.LENGTH_SHORT).show();
                }
            }

        } );

    }

    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Numb");
        dados.add("Flow");
        dados.add("teste2");
        dados.add("teste3");
        return dados;
    }
}