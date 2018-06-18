package com.example.alecxandramesquita.escala.Cadastro;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.alecxandramesquita.escala.Dao.EquipeDao;
import com.example.alecxandramesquita.escala.ListaEquipes;
import com.example.alecxandramesquita.escala.ListaNomes;
import com.example.alecxandramesquita.escala.Model.Equipe;
import com.example.alecxandramesquita.escala.R;

import java.util.ArrayList;

public class TelaLayoutEquipe extends AppCompatActivity {

        EquipeDao vrBancoDeDados = null;
        EditText nomeEquipe = null;


        ArrayList<Equipe> equipes;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tela_layout_equipe);

            nomeEquipe = (EditText)findViewById(R.id.layoutTelaEquipeNome);

        }

        // @Override
        public void onClick(View v) {
            if (v.getId() == R.id.layoutTelaEquipeBotaoGravar) {
                gravarEquipes(v);
            }
            if (v.getId() == R.id.TelaPerfilbotaoEquipe) {
                EquipeSelect(v);
            }
        }

        public void gravarEquipes(View v){
            vrBancoDeDados = new EquipeDao(this);
            ContentValues dados = new ContentValues();
            dados.put("nomeEquipe", this.nomeEquipe.getText().toString());
            vrBancoDeDados.insereEquipe(dados);
            vrBancoDeDados.listaEquipes();
            Intent intencaoVaiParaLista = new Intent(TelaLayoutEquipe.this, ListaEquipes.class);
            startActivity(intencaoVaiParaLista);
            finish();

        }

        public void EquipeSelect(View v){
            Intent intencaoVaiParaListaEq = new Intent(TelaLayoutEquipe.this, ListaEquipes.class);
            startActivity(intencaoVaiParaListaEq);
            finish();
        }

        public void voltar(View botaoSair){
            Intent intencaoVaiParacadastro = new Intent(TelaLayoutEquipe.this, TelaLayoutCadastro.class);
            startActivity(intencaoVaiParacadastro);
            finish();
        }
}
