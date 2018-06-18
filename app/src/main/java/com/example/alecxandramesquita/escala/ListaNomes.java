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
import com.example.alecxandramesquita.escala.Adapter.PessoaAdapter;
import com.example.alecxandramesquita.escala.Dao.PessoaDao;
import com.example.alecxandramesquita.escala.Model.Pessoa;

import java.util.ArrayList;

public class ListaNomes extends AppCompatActivity {

    private Context contexto;
    PessoaDao vrbancoDados = null;
    RecyclerView lista = null;
    ArrayList<Pessoa> pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_nomes);

        PopulaLista();
    }

    private void PopulaLista() {
        vrbancoDados = new PessoaDao(this);
        lista = findViewById(R.id.listapessoa);
        pessoa = vrbancoDados.listaPessoas();


        RecyclerView listaRecycleView;
        listaRecycleView = (RecyclerView) findViewById(R.id.listapessoa);
        listaRecycleView.setLayoutManager(new LinearLayoutManager(this));
        listaRecycleView.setItemAnimator(new DefaultItemAnimator());
        listaRecycleView.setHasFixedSize(true);

        PessoaAdapter adapt = new PessoaAdapter(this, pessoa, criaListener());
        listaRecycleView.setAdapter(adapt);
    }

    private AdapterListener criaListener(){
        return new AdapterListener(){
            @Override
            public void celulaClicada(View view, int posicao){
                //chama outra tela
                contexto = view.getContext();
                Intent intent = new Intent(contexto, ListaNomes.class);
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