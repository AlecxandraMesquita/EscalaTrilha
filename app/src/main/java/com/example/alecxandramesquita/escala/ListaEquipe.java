package com.example.alecxandramesquita.escala;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

/**
 * Created by Alecxandra Mesquita on 18/04/2018.
 */

class ItemHolder extends RecyclerView.ViewHolder{
    Button nome = null;
    ItemHolder(View itemView) {
        super(itemView);
        nome = (Button) itemView.findViewById(R.id.TelaListaNomesEquipes);
    }
}

public class ListaEquipe {
    String nome;
    public ListaEquipe(String pNome) {
        nome = pNome;
    }
}
