package com.example.alecxandramesquita.escala;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class LayoutTelaPerfil extends AppCompatActivity {
    //variaveis globais
    TextView usuario = null;
    Switch notificacoes = null;
    Switch preferencias = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_tela_perfil);

        usuario =  (TextView)findViewById(R.id.TelaPerfilNomeUsuario);

        Bundle dicionario = this.getIntent().getExtras();

        usuario.setText(dicionario.getString("Login"));

    }


    public void Equipes(View botaoProximo) {
        if (botaoProximo.getId()== R.id.TelaPerfilbotaoEquipe){
            Intent intencao = new Intent(LayoutTelaPerfil.this, TelaEquipes.class);
            //leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivityForResult(intencao, 3);
        }
    }



}
