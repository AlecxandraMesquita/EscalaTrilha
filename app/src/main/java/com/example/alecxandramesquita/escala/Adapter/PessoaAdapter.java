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

import com.example.alecxandramesquita.escala.Cadastro.TelaLayoutPessoa;
import com.example.alecxandramesquita.escala.Dao.EquipeDao;
import com.example.alecxandramesquita.escala.Dao.PessoaDao;
import com.example.alecxandramesquita.escala.Holder.PessoaHolder;
import com.example.alecxandramesquita.escala.ListaNomes;
import com.example.alecxandramesquita.escala.Model.Pessoa;
import com.example.alecxandramesquita.escala.R;

import java.util.ArrayList;

public class PessoaAdapter extends RecyclerView.Adapter<PessoaHolder> {

    Context contexto = null;
    ArrayList<Pessoa> lista = null;
    private AlertDialog alerta;
    AdapterListener listener = null;
    PessoaDao vrbancoDados = null;

    public PessoaAdapter(Context contexto, ArrayList<Pessoa> lista, AdapterListener listener) {
        this.contexto = contexto;
        this.lista = lista;
        this.listener = listener;
    }

    @Override
    public PessoaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.item_pessoa, parent, false);
        PessoaHolder item  = new PessoaHolder(celula);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull PessoaHolder holder, final int position) {
        Pessoa item = lista.get(position);

        holder.getVrNome().setText(item.getNome());
        holder.getVrSobrenome().setText(item.getSobrenome());
        holder.getVrTelefone().setText(item.getTelefone());
        holder.getVrEmail().setText(item.getEmail());


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
                builder.setTitle("Tem certeza de suas ações?");
                //Definição da mensagem
                builder.setMessage("Apagar " + lista.get(position).getNome());
                //define um botão como positivo
                builder.setPositiveButton("Apagar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        vrbancoDados = new PessoaDao(contexto);
//                        vrbancoDados = new PessoaDao(contexto);
                        vrbancoDados.removePessoa(lista.get(position));
                        vrbancoDados.listaPessoas();

                        ((Activity)contexto).finish();
                        Intent intencaoVaiParaAtividade = new Intent(contexto, ListaNomes.class);
                        intencaoVaiParaAtividade.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        contexto.startActivity(intencaoVaiParaAtividade);

                        Toast.makeText(contexto, lista.get(position).getNome() +" Apagada", Toast.LENGTH_SHORT).show();
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
