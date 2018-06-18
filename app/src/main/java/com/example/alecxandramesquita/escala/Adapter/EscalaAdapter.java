package com.example.alecxandramesquita.escala.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alecxandramesquita.escala.Dao.EscalaDao;
import com.example.alecxandramesquita.escala.Holder.EscalaHolder;
import com.example.alecxandramesquita.escala.ListaEscala;
import com.example.alecxandramesquita.escala.Model.Escala;
import com.example.alecxandramesquita.escala.R;

import java.util.ArrayList;

public class EscalaAdapter extends RecyclerView.Adapter<EscalaHolder> {

    Context contexto = null;
    ArrayList<Escala> lista = null;
    private AlertDialog alerta;
    AdapterListener listener = null;
    EscalaDao vrbancoDados = null;

    public EscalaAdapter(Context contexto, ArrayList<Escala> lista, AdapterListener listener) {
        this.contexto = contexto;
        this.lista = lista;
        this.listener = listener;
    }

    @Override
    public EscalaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.item_escala, parent, false);
        EscalaHolder item  = new EscalaHolder(celula);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull EscalaHolder holder, final int position) {
        Escala item = lista.get(position);

        holder.getVrNomePessoa().setText(item.getNomePessoa());
        holder.getVrEquipe().setText(item.getEquipe());
        holder.getVrData().setText(item.getData());


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
                builder.setTitle("Tem certeza de suas ações?");
                //Definição da mensagem
                builder.setMessage("Apagar " + lista.get(position).getData());
                //define um botão como positivo
                builder.setPositiveButton("Apagar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        vrbancoDados = new EscalaDao(contexto);
                        vrbancoDados.removeEscala(lista.get(position));
                        vrbancoDados.listaEscalas();

                        ((Activity)contexto).finish();
                        Intent intencaoVaiParaEquipe = new Intent(contexto, ListaEscala.class);
                        intencaoVaiParaEquipe.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        contexto.startActivity(intencaoVaiParaEquipe);

                        Toast.makeText(contexto, lista.get(position).getData() + " Apagada", Toast.LENGTH_SHORT).show();
                    }
                });
                //define um botão como negativo.
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });
                //cria o AlertDialog
                alerta = builder.create();
                //Exibe
                alerta.show();
                return true;
            }

        });
    }

    @Override
    public int getItemCount() {
        return (lista != null) ? lista.size() : 0;
    }
}
