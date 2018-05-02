package com.example.alecxandramesquita.escala;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

class ItemHoldes extends RecyclerView.ViewHolder{
    TextView nome = null;
    ItemHoldes(View itemView) {
        super(itemView);
        nome = (TextView) itemView.findViewById(R.id.listaNomeVoluntario);
    }
}

public class ListaNomes {

    String Nome =null;
    public ListaNomes(String pNomes) {

        Nome = pNomes;
    }
}
