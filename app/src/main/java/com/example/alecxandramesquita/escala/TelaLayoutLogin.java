package com.example.alecxandramesquita.escala;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaLayoutLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_layout_login);
    }
    @Override
    protected void onResume() {
        if(getIntent().getBooleanExtra("SAIR", false)){
            finish();
        }
        super.onResume();
    }
    public void sobre(View botaoProximo) {
        if (botaoProximo.getId()== R.id.TelaPerfilbotaoSobre){
            Intent intencaoSobre = new Intent(TelaLayoutLogin.this, LayoutTelaSobre.class);
            //leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivity(intencaoSobre);
        }
    }

    public void acessar(View botaoProximo) {
        if (botaoProximo.getId()== R.id.TelaLoginbotaoOK){
            Intent intencao = new Intent(TelaLayoutLogin.this, LayoutTelaPerfil.class);
            //leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivity(intencao);
        }
    }
}
