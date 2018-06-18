package com.example.alecxandramesquita.escala.Cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.alecxandramesquita.escala.LayoutTelaPerfil;
import com.example.alecxandramesquita.escala.R;

public class TelaLayoutCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_layout_cadastro);
    }
//chamada da tela de cadastro de Pessoa
    public void pessoas(View botaoProximo) {
        if (botaoProximo.getId() == R.id.TelaLayoutCadastroPessoa) {
            Intent intencaoPessoa = new Intent(TelaLayoutCadastro.this, TelaLayoutPessoa.class);
            //leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivity(intencaoPessoa);
        }
    }
    //chamada da tela de cadastro de Equipe
    public void equipe(View botaoProximo) {
        if (botaoProximo.getId() == R.id.TelaLayoutCadastroEquipe) {
            Intent intencaoEquipe = new Intent(TelaLayoutCadastro.this, TelaLayoutEquipe.class);
            //leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivity(intencaoEquipe);
        }

    }

    //chamada da tela de cadastro de Equipe
    public void escala(View botaoProximo) {
        if (botaoProximo.getId() == R.id.TelaLayoutCadastroEscala) {
            Intent intencaoEscala = new Intent(TelaLayoutCadastro.this, TelaLayoutEscala.class);
            //leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivity(intencaoEscala);
        }

    }
    public void voltar(View botaoProximo) {
        if (botaoProximo.getId() == R.id.layoutTelaCadastroBotaoVoltar) {
            Intent intencaoPerfil = new Intent(TelaLayoutCadastro.this, LayoutTelaPerfil.class);
            //leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivity(intencaoPerfil);
            finish();
        }

    }

}
