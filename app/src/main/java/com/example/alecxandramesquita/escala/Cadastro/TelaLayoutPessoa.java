package com.example.alecxandramesquita.escala.Cadastro;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.alecxandramesquita.escala.Dao.PessoaDao;
import com.example.alecxandramesquita.escala.ListaNomes;
import com.example.alecxandramesquita.escala.Model.Pessoa;
import com.example.alecxandramesquita.escala.R;

import java.util.ArrayList;

public class TelaLayoutPessoa extends AppCompatActivity {

    PessoaDao vrBancoDeDados = null;
    EditText nome = null;
    EditText sobrenome = null;
    EditText telefone = null;
    EditText email = null;
    EditText senha = null;

    ArrayList<Pessoa> pessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_layout_pessoa);

        nome = (EditText)findViewById(R.id.layoutTelaPessoaNome);
        sobrenome = (EditText)findViewById(R.id.layoutTelaPessoaSobrenome);
        telefone = (EditText)findViewById(R.id.layoutTelaPessoaTelefone);
        email = (EditText)findViewById(R.id.layoutTelaPessoaEmail);
        senha = (EditText)findViewById(R.id.layoutTelaPessoaSenha);

    }

   // @Override
    public void onClick(View v) {
        if (v.getId() == R.id.layoutTelaPessoaBotaoGravar) {
            gravarPessoas(v);
        }
        if (v.getId() == R.id.TelaPerfilbotaoPessoa) {
            pessoaSelect(v);
        }
    }

    public void gravarPessoas(View v){
        vrBancoDeDados = new PessoaDao(this);
        ContentValues dados = new ContentValues();
        dados.put("nome", this.nome.getText().toString());
        dados.put("sobrenome", this.sobrenome.getText().toString());
        dados.put("telefone", this.telefone.getText().toString());
        dados.put("email", this.email.getText().toString());
        dados.put("senha", this.senha.getText().toString());
        vrBancoDeDados.inserePessoa(dados);
        vrBancoDeDados.listaPessoas();
        Intent intencaoVaiParaLista = new Intent(TelaLayoutPessoa.this, ListaNomes.class);
        startActivity(intencaoVaiParaLista);
        finish();
    }

    public void pessoaSelect(View v){
        Intent intencaoVaiParaLista = new Intent(TelaLayoutPessoa.this, ListaNomes.class);
        startActivity(intencaoVaiParaLista);
        finish();
    }

    public void voltar(View botaoSair){
        Intent intencaoVaiParacadastro = new Intent(TelaLayoutPessoa.this, TelaLayoutCadastro.class);
        startActivity(intencaoVaiParacadastro);
//        finish();
    }


}

