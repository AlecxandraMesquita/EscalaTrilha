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
import com.example.alecxandramesquita.escala.Adapter.EquipeAdapter;
import com.example.alecxandramesquita.escala.Adapter.PessoaAdapter;
import com.example.alecxandramesquita.escala.Dao.EquipeDao;
import com.example.alecxandramesquita.escala.Model.Equipe;

import java.util.ArrayList;

public class ListaEquipes extends AppCompatActivity {
    private Context contexto;
    EquipeDao vrbancoDados = null;
    RecyclerView lista = null;
    ArrayList<Equipe> equipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_equipes);

        PopulaLista();
    }

    private void PopulaLista() {
        vrbancoDados = new EquipeDao(this);
        lista = findViewById(R.id.listaEquipe);
        equipe = vrbancoDados.listaEquipes();


        RecyclerView listaRecycleView;
        listaRecycleView = (RecyclerView) findViewById(R.id.listaEquipe);
        listaRecycleView.setLayoutManager(new LinearLayoutManager(this));
        listaRecycleView.setItemAnimator(new DefaultItemAnimator());
        listaRecycleView.setHasFixedSize(true);

        EquipeAdapter adapt = new EquipeAdapter(this, equipe, criaListener());
        listaRecycleView.setAdapter(adapt);
    }

    private AdapterListener criaListener(){
        return new AdapterListener(){
            @Override
            public void celulaClicada(View view, int posicao){
                //chama outra tela
                contexto = view.getContext();
                Intent intent = new Intent(contexto, ListaEquipes.class);
                contexto.startActivity(intent);

            }
        };
    }
    public void voltar(View botaoProximo) {
        if (botaoProximo.getId() == R.id.ListaNomeBotaoVoltar) {
            finish();
        }

    }
}
