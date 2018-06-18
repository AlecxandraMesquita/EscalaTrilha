package com.example.alecxandramesquita.escala;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.alecxandramesquita.escala.Adapter.AdapterListener;
import com.example.alecxandramesquita.escala.Adapter.EscalaAdapter;
import com.example.alecxandramesquita.escala.Dao.EscalaDao;
import com.example.alecxandramesquita.escala.Model.Escala;

import java.util.ArrayList;

public class ListaEscala extends AppCompatActivity {

    private Context contexto;
    EscalaDao vrbancoDados = null;
    RecyclerView lista = null;
    ArrayList<Escala> escala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_escala);

        PopulaLista();

    }


    private void PopulaLista() {
        vrbancoDados = new EscalaDao(this);
        lista = findViewById(R.id.listaEscala);
        escala = vrbancoDados.listaEscalas();


        RecyclerView listaRecycleView;
        listaRecycleView = (RecyclerView) findViewById(R.id.listaEscala);
        listaRecycleView.setLayoutManager(new LinearLayoutManager(this));
        listaRecycleView.setItemAnimator(new DefaultItemAnimator());
        listaRecycleView.setHasFixedSize(true);

        EscalaAdapter adapt = new EscalaAdapter(this, escala, criaListener());
        listaRecycleView.setAdapter(adapt);
    }

    private AdapterListener criaListener(){
        return new AdapterListener(){
            @Override
            public void celulaClicada(View view, int posicao){
                //chama outra tela
                contexto = view.getContext();
                Intent intent = new Intent(contexto, ListaEscala.class);
                contexto.startActivity(intent);

            }
        };
    }
    public void voltar(View botaoProximo) {
        if (botaoProximo.getId() == R.id.ListaEscalaBotaoVoltar) {
            finish();
        }

    }

}
