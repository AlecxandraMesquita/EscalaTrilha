package com.example.alecxandramesquita.escala.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alecxandramesquita.escala.R;

public class PessoaHolder extends RecyclerView.ViewHolder {

    TextView vrNome = null;
    TextView vrSobrenome = null;
    TextView vrTelefone = null;
    TextView vrEmail = null;
    TextView vrSenha = null;

    public PessoaHolder(View view) {
        super(view);
        vrNome = (TextView) view.findViewById(R.id.pessoa_cartao_nome);
        vrSobrenome = (TextView) view.findViewById(R.id.pessoa_cartao_sobrenome);
        vrTelefone = (TextView) view.findViewById(R.id.pessoa_cartao_telefone);
        vrEmail = (TextView) view.findViewById(R.id.pessoa_cartao_email);

    }

    public TextView getVrNome() {
        return vrNome;
    }

    public void setVrNome(TextView vrNome) {
        this.vrNome = vrNome;
    }

    public TextView getVrSobrenome() {
        return vrSobrenome;
    }

    public void setVrSobrenome(TextView vrSobrenome) {
        this.vrSobrenome = vrSobrenome;
    }

    public TextView getVrTelefone() {
        return vrTelefone;
    }

    public void setVrTelefone(TextView vrTelefone) {
        this.vrTelefone = vrTelefone;
    }

    public TextView getVrEmail() {
        return vrEmail;
    }

    public void setVrEmail(TextView vrEmail) {
        this.vrEmail = vrEmail;
    }

    public TextView getVrSenha() {
        return vrSenha;
    }

    public void setVrSenha(TextView vrSenha) {
        this.vrSenha = vrSenha;
    }
}
