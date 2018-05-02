package com.example.alecxandramesquita.escala;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

class ItemHolde extends RecyclerView.ViewHolder{
    Button nome = null;
    ItemHolde(View itemView) {
        super(itemView);
        nome = (Button) itemView.findViewById(R.id.layoutescalaData);
    }
}


public class ListaData {
    String Data =null;
    public ListaData(String pData) {

        Data = pData;
    }
}
