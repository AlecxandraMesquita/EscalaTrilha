package com.example.alecxandramesquita.escala.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alecxandramesquita.escala.R;

public class EquipeHolder extends RecyclerView.ViewHolder {
        TextView vrNome = null;

    public EquipeHolder(View view) {
        super(view);
        vrNome = (TextView) view.findViewById(R.id.equipe_cartao_nome);

    }

    public TextView getVrNome() {
        return vrNome;
    }

    public void setVrNome(TextView vrNome) {
        this.vrNome = vrNome;
    }
}
