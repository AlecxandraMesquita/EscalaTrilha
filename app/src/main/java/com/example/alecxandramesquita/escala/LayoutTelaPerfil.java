package com.example.alecxandramesquita.escala;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.alecxandramesquita.escala.Cadastro.TelaLayoutCadastro;

public class LayoutTelaPerfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_tela_perfil);
    }
    //chamada da o botão de listar Equipe
    public void EquipeSelect(View botaoProximo) {
        if (botaoProximo.getId()== R.id.TelaPerfilbotaoEquipe){
            Intent intencaoEquipe = new Intent(LayoutTelaPerfil.this, ListaEquipes.class);
           // leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivity(intencaoEquipe);
        }
    }
    //chamada da o botão de listar Escala
    public void Escalas(View botaoProximo) {
        if (botaoProximo.getId()== R.id.TelaPerfilbotaoEscala){
            Intent intencao = new Intent(LayoutTelaPerfil.this, ListaEscala.class);
//            leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivityForResult(intencao, 3);
        }
    }
    //chamada do botão cadastro
    public void cadastro(View botaoProximo) {
        if (botaoProximo.getId()== R.id.TelaPerfilbotaoCadastrar){
            Intent intencaoCadastrar = new Intent(LayoutTelaPerfil.this, TelaLayoutCadastro.class);
            //leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivity(intencaoCadastrar);
        }
    }
//chamada da o botão de listar pessoa
    public void pessoaSelect(View botaoProximo) {
        if (botaoProximo.getId()== R.id.TelaPerfilbotaoPessoa){
            Intent intencaoListaPessoa = new Intent(LayoutTelaPerfil.this, ListaNomes.class);
            //leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivity(intencaoListaPessoa);
        }
    }
    //chamada da o botão de voltar
    public void voltar(View botaoProximo) {
        if (botaoProximo.getId() == R.id.TelaPerfilbotaoVoltar) {
            Intent intencaoPerfil = new Intent(LayoutTelaPerfil.this, TelaLayoutLogin.class);
            //leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivity(intencaoPerfil);
            finish();
        }
    }


}
