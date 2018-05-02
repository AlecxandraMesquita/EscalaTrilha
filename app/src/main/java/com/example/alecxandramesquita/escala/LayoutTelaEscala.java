package com.example.alecxandramesquita.escala;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

class Adaptado extends RecyclerView.Adapter<ItemHolde> {


    Context contexto = null;
    ArrayList<ListaData> lista = null;
    Adaptado(Context contexto, ArrayList<ListaData> lista){
        this.contexto = contexto;
        this.lista = lista;
    }
    //metodo chamado n vezes para inflar o Xml da celula e retormnar o objeto de layout
    @Override
    public ItemHolde onCreateViewHolder(ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.activity_layout_escala,parent,false);

        ItemHolde item = new ItemHolde(celula);

        return item;
    }

    @Override
    public void onBindViewHolder(ItemHolde holder, int position) {
        ListaData item = lista.get(position);

        holder.nome.setText(item.Data);
    }

    @Override
    public int getItemCount() { return (lista != null) ? lista.size(): 0;}
}

public class LayoutTelaEscala extends AppCompatActivity {

    Button vrBotaoOK = null;
    ArrayList<ListaData> dataSource = null;
    RecyclerView lista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_tela_escala);

        vrBotaoOK = (Button) findViewById(R.id.layoutescalaData);

        dataSource = new ArrayList<ListaData>();
        dataSource.add(new ListaData("Dia 06-05-2018"));
        dataSource.add(new ListaData("Dia 13-05-2018"));
        dataSource.add(new ListaData("Dia 20-05-2018"));
        dataSource.add(new ListaData("Dia 27-05-2018"));
        dataSource.add(new ListaData("Dia 03-06-2018"));
        dataSource.add(new ListaData("Dia 10-06-2018"));
        dataSource.add(new ListaData("Dia 17-06-2018"));
        dataSource.add(new ListaData("Dia 24-06-2018"));
        dataSource.add(new ListaData("Dia 01-07-2018"));

        lista = (RecyclerView)findViewById(R.id.Listar);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setItemAnimator(new DefaultItemAnimator());
        lista.setHasFixedSize(true);

        Adaptado adapt = new Adaptado(this, dataSource);
        lista.setAdapter(adapt);

//        Intent botao = new Intent(LayoutTelaEscala.this,LayoutTelaVoluntarios.class);
//        botao.putExtras("botao", botao);
//        startActivity(botao);
    }

    public void voltar(View botaoSair){
        finish();
    }
    public void dataEscala(View botaoProximo) {
        if (botaoProximo.getId()== R.id.layoutescalaData){
            Intent intencao = new Intent(LayoutTelaEscala.this,LayoutTelaVoluntarios.class);
            //leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivity(intencao);
        }
    }

}
