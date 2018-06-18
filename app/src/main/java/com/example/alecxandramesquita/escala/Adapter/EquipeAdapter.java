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

import com.example.alecxandramesquita.escala.Dao.EquipeDao;
import com.example.alecxandramesquita.escala.Holder.EquipeHolder;
import com.example.alecxandramesquita.escala.ListaEquipes;
import com.example.alecxandramesquita.escala.Model.Equipe;
import com.example.alecxandramesquita.escala.R;

import java.util.ArrayList;

public class EquipeAdapter extends RecyclerView.Adapter<EquipeHolder> {

    Context contexto = null;
    ArrayList<Equipe> lista = null;
    private AlertDialog alerta;
    AdapterListener listener = null;
    EquipeDao vrbancoDados = null;

    public EquipeAdapter(Context contexto, ArrayList<Equipe> lista, AdapterListener listener) {
        this.contexto = contexto;
        this.lista = lista;
        this.listener = listener;
    }

    @Override
    public EquipeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.item_equipe, parent, false);
        EquipeHolder item  = new EquipeHolder(celula);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull EquipeHolder holder, final int position) {
        Equipe item = lista.get(position);

        holder.getVrNome().setText(item.getNomeEquipe());


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
                builder.setTitle("Tem certeza de suas ações?");
                //Definição da mensagem
                builder.setMessage("Apagar " + lista.get(position).getNomeEquipe());
                //define um botão como positivo
                builder.setPositiveButton("Apagar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        vrbancoDados = new EquipeDao(contexto);
                        vrbancoDados.removeEquipe(lista.get(position));
                        vrbancoDados.listaEquipes();

                        ((Activity)contexto).finish();
                        Intent intencaoVaiParaEquipe = new Intent(contexto, ListaEquipes.class);
                        intencaoVaiParaEquipe.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        contexto.startActivity(intencaoVaiParaEquipe);

                        Toast.makeText(contexto, lista.get(position).getNomeEquipe() + " Apagada", Toast.LENGTH_SHORT).show();
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
