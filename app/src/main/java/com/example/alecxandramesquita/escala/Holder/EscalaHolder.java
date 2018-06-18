package com.example.alecxandramesquita.escala.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alecxandramesquita.escala.R;

public class EscalaHolder extends RecyclerView.ViewHolder {

    TextView vrEquipe;
    TextView vrData;
    TextView vrNomePessoa;

    public EscalaHolder(View view) {
        super(view);
        vrNomePessoa = (TextView) view.findViewById(R.id.escala_cartao_nomePessoa);
        vrEquipe = (TextView) view.findViewById(R.id.escala_cartao_nomeEquipe);
        vrData = (TextView) view.findViewById(R.id.escala_cartao_data);
    }

    public TextView getVrEquipe() {
        return vrEquipe;
    }

    public void setVrEquipe(TextView vrEquipe) {
        this.vrEquipe = vrEquipe;
    }

    public TextView getVrData() {
        return vrData;
    }

    public void setVrData(TextView vrData) {
        this.vrData = vrData;
    }

    public TextView getVrNomePessoa() {
        return vrNomePessoa;
    }

    public void setVrNomePessoa(TextView vrNomePessoa) {
        this.vrNomePessoa = vrNomePessoa;
    }

}
