package com.example.alecxandramesquita.escala;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LayoutTelaLogin extends AppCompatActivity implements View.OnClickListener {

    //Atributo da Classe
    Button vrBotaoOK = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_tela_login);

        vrBotaoOK = (Button) findViewById(R.id.TelaLoginbotaoOK);
        //registra a variavel do botao para garantir o tratamento do evento
        // vrBotaoOK.setOnClickListener(this);

    }

    private boolean validaLogin() {
        EditText vrCampoLogin = (EditText) findViewById(R.id.TelaLoginCampoLogin);
        EditText vrCampoSenha = (EditText) findViewById(R.id.TelaLoginCampoSenha);

        String login = vrCampoLogin.getText().toString();
        String senha = vrCampoSenha.getText().toString();

        if (vrCampoLogin.getText().toString().equals("ale") && vrCampoSenha.getText().toString().equals("123")) {
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View vrBotao) {
        if (vrBotao.getId() == R.id.TelaLoginbotaoOK) {
            validaLogin();
        }
    }

    //Metodo Utilizado para capturar eventos do botao
    public void validaLogin(View vrBotao) {
        if (vrBotao.getId() == R.id.TelaLoginbotaoOK) {
            if (validaLogin()) {
                //troca de tela para perfil do usuario
                EditText vrCampoLogin = (EditText) findViewById(R.id.TelaLoginCampoLogin);
                //Cria um dicionario
                Bundle dicionario = new Bundle();
                //o dicionario possui chave e valor
                dicionario.putString("Login", vrCampoLogin.getText().toString());
                dicionario.putInt("idade", 31);
                dicionario.putChar("Sexo", 'F');

                Intent intencao = new Intent(LayoutTelaLogin.this, LayoutTelaPerfil.class);
                //leva para prÃ³xima tela todos os dados adcionados no dicionario
                intencao.putExtras(dicionario);
                startActivityForResult(intencao, 1);

            } else {
                Toast vrToast = Toast.makeText(this, "Login ou senha invalida", Toast.LENGTH_SHORT);
                vrToast.show();
            }
        }
    }

    @Override
    protected void onResume() {
        if(getIntent().getBooleanExtra("SAIR", false)){
            finish();
        }
        super.onResume();
    }
    //metodo que grava as alteraÃ§Ãµes do usuÃ¡rio
//    public void onActivityResult(int codigo, int resultado, Intent intencao) {
//        if (resultado == Activity.RESULT_OK) {
//            if (codigo == 1) {
//                boolean notificacoes = intencao.getExtras().getBoolean("notificacoes");
//                boolean preferencias = intencao.getExtras().getBoolean("preferencias");
//
//                Persistencia.salvaPreferencias(preferencias, notificacoes, this);
//            }
//        }
//
//    }
    public void sobre(View botaoProximo) {
        if (botaoProximo.getId()== R.id.TelaPerfilbotaoSobre){
            Intent intencao = new Intent(LayoutTelaLogin.this, LayoutTelaSobre.class);
            //leva para prÃ³xima tela todos os dados adcionados no dicionario
            startActivityForResult(intencao, 3);
        }
    }
}