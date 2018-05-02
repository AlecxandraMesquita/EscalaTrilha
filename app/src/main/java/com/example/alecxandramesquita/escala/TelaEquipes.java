package com.example.alecxandramesquita.escala;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

class Adaptador extends RecyclerView.Adapter<ItemHolder>{

    Context contexto = null;
    ArrayList<ListaEquipe> lista = null;

    Adaptador(Context contexto, ArrayList<ListaEquipe> lista){
        this.contexto = contexto;
        this.lista = lista;
    }
    //metodo chamado n vezes para inflar o Xml da celula e retormnar o objeto de layout
    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.lista_nomes_equipes,parent,false);

        ItemHolder item = new ItemHolder(celula);

        return item;

    }

    //metodo chamado N x para definir o conteudo que sserá mostrado pela celula
    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        ListaEquipe item = lista.get(position);

        holder.nome.setText(item.nome);
    }
    //Metodo que determina o numero de celulas a serem criadas na lista
    @Override
    public int getItemCount() {
        return (lista != null) ? lista.size(): 0;
    }
}

public class TelaEquipes extends AppCompatActivity {

    ArrayList<ListaEquipe> dataSource = null;
    RecyclerView lista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_equipes);

        dataSource = new ArrayList<ListaEquipe>();
        dataSource.add(new ListaEquipe("Rosa"));
        dataSource.add(new ListaEquipe("Lilás"));
        dataSource.add(new ListaEquipe("Laranja"));
        dataSource.add(new ListaEquipe("Vermelha"));
        dataSource.add(new ListaEquipe("Verde"));
        dataSource.add(new ListaEquipe("Azul"));
        dataSource.add(new ListaEquipe("Amarela"));
        dataSource.add(new ListaEquipe("Preta"));

        lista = (RecyclerView)findViewById(R.id.lista);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setItemAnimator(new DefaultItemAnimator());
        lista.setHasFixedSize(true);

        Adaptador adapt = new Adaptador(this, dataSource);
        lista.setAdapter(adapt);
    }
    public void voltar(View botaoSair){
        finish();
    }
    public void nomeEquipe(View botaoProximo) {
        if (botaoProximo.getId()== R.id.TelaListaNomesEquipes){
            Intent intencao = new Intent(TelaEquipes.this,LayoutTelaEscala.class);
            //leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivityForResult(intencao, 4);
        }
    }

}
