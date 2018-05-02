package com.example.alecxandramesquita.escala;

import android.annotation.SuppressLint;
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
import android.widget.EditText;

import java.util.ArrayList;

class Adaptando extends RecyclerView.Adapter<ItemHoldes> {

    Context contexto = null;
    ArrayList<ListaNomes> lista = null;
    Adaptando(Context contexto, ArrayList<ListaNomes> lista){
        this.contexto = contexto;
        this.lista = lista;
    }
    //metodo chamado n vezes para inflar o Xml da celula e retormnar o objeto de layout
    @Override
    public ItemHoldes onCreateViewHolder(ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.lista_nome_voluntarios,parent,false);

        ItemHoldes itens = new ItemHoldes(celula);

        return itens;
    }

    @Override
    public void onBindViewHolder(ItemHoldes holder, int position) {
        ListaNomes itens = lista.get(position);

        holder.nome.setText(itens.Nome);
    }

    @Override
    public int getItemCount() { return (lista != null) ? lista.size(): 0;}
}

public class LayoutTelaVoluntarios extends AppCompatActivity {

    ArrayList<ListaNomes> dataSource = null;
    RecyclerView lista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_tela_voluntarios);

        dataSource = new ArrayList<ListaNomes>();
        dataSource.add(new ListaNomes("Alecxandra"));
        dataSource.add(new ListaNomes("Carol"));
        dataSource.add(new ListaNomes("Maria Amélia"));
        dataSource.add(new ListaNomes("Silvia"));
        dataSource.add(new ListaNomes("Viviane"));
        dataSource.add(new ListaNomes("Gisele"));
        dataSource.add(new ListaNomes("Leide"));
        dataSource.add(new ListaNomes("Luciene"));
        dataSource.add(new ListaNomes("Ludmila"));
        dataSource.add(new ListaNomes("Laura"));
        dataSource.add(new ListaNomes("Deborah C"));
        dataSource.add(new ListaNomes("Debora N"));
        dataSource.add(new ListaNomes("Mikaela"));
        dataSource.add(new ListaNomes("Mikaele"));
        dataSource.add(new ListaNomes("Mauro"));
        dataSource.add(new ListaNomes("Marcelo"));
        dataSource.add(new ListaNomes("Joelson"));
        dataSource.add(new ListaNomes("Nayara"));

        lista = (RecyclerView)findViewById(R.id.Listas);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setItemAnimator(new DefaultItemAnimator());
        lista.setHasFixedSize(true);

        Adaptando adapt = new Adaptando(this, dataSource);
        lista.setAdapter(adapt);


    }

    public void voltar(View botaoSair){
        finish();
    }
    public void sair(View botaoSair){
        //cria o objeto AletDialog e configura icone, titulo mensagem
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setIcon(R.mipmap.ic_launcher);
        alerta.setTitle("Atenção");
        alerta.setMessage("Deseja Realmente sair?");
        //adiciona o botao sim e sueu evento ao alerta
        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent  it = new Intent(getApplicationContext(), LayoutTelaLogin.class);
                it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                it.putExtra("SAIR", true);
                startActivity(it);

                finish();
            }

        });
        //adiciona o botao nao ao alerta
        alerta.setNegativeButton("Não", null);
        //apresenta o alerta na tela
        alerta.create().show();

    }
}
