package com.example.alecxandramesquita.escala.Cadastro;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.alecxandramesquita.escala.Dao.EscalaDao;
import com.example.alecxandramesquita.escala.Dao.PessoaDao;
import com.example.alecxandramesquita.escala.ListaEscala;
import com.example.alecxandramesquita.escala.Model.Equipe;
import com.example.alecxandramesquita.escala.Model.Escala;
import com.example.alecxandramesquita.escala.Model.Pessoa;
import com.example.alecxandramesquita.escala.R;

import java.util.ArrayList;
import java.util.Calendar;

public class TelaLayoutEscala extends AppCompatActivity {
    //definição das variáveis
    EscalaDao vrBancoDeDados = null;
    Spinner vrNomePesspa = null;
    Spinner vrNomeEquie = null;
    EditText vrData = null;
    ArrayList<Equipe> equipeList;
    ArrayList<String> listadEquipe;
    ArrayList<Pessoa> pessoaList;
    ArrayList<String> listadPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_layout_escala);


        vrBancoDeDados = new EscalaDao(this);
        SQLiteDatabase db = vrBancoDeDados.getReadableDatabase();
    ///////////////////////////////ListaPessoa///////////////////////////////////////////////////////////////////////////////
        pessoaList = new ArrayList<Pessoa>();
        Cursor cursor = db.query("Pessoa", new String[]{"_id","nome", "sobrenome", "telefone", "email"}, null, null,null, null, null);

        while (cursor.moveToNext()) {
            Pessoa p = new Pessoa();
            p.set_id(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setSobrenome(cursor.getString(2));
            p.setTelefone(cursor.getString(3));
            p.setEmail(cursor.getString(4));


            pessoaList.add(p);
        }

        listadPessoa = new ArrayList<String>();
        listadPessoa.add("Seleccione");

        for(int i=0;i<pessoaList.size();i++){
            listadPessoa.add(pessoaList.get(i).getNome());
        }

        ///////////////////////////////ListaEquipe///////////////////////////////////////////////////////////////////////////////
        equipeList = new ArrayList<Equipe>();
        Cursor curso = db.query("Equipe", new String[]{"id","nomeEquipe"},null,null,null,null,null);

        while (curso.moveToNext()) {
            Equipe e = new Equipe();
            e.setId(curso.getInt(0));
            e.setNomeEquipe(curso.getString(1));

            equipeList.add(e);
        }

        listadEquipe = new ArrayList<String>();
        listadEquipe.add("Seleccione");

        for(int i=0;i<equipeList.size();i++){
            listadEquipe.add(equipeList.get(i).getNomeEquipe());
        }

        vrNomePesspa = (Spinner)findViewById(R.id.layoutTelaEscalaNomePessoa);
        vrNomeEquie = (Spinner)findViewById(R.id.layoutTelaEscalaNomeEquipe);
        vrData = (EditText)findViewById(R.id.layoutTelaEscalaData);

    ///////////////////////////////DataCalendar///////////////////////////////////////////////////////////////////////////////
        vrData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int dia = c.get(Calendar.DAY_OF_MONTH);
                int mes = c.get(Calendar.MONTH);
                int ano = c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(TelaLayoutEscala.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        vrData.setText(dayOfMonth + "/" + (month+1)+ "/" + year);
                    }
                }, ano, mes, dia);
                datePickerDialog.setTitle("Data Evento");
                datePickerDialog.show();
            }
        });
        //Adapter de listagem de pessoa
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listadPessoa);
        vrNomePesspa.setAdapter(adaptador);

        //Adapter de listagem de Equipe
        ArrayAdapter adaptado=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listadEquipe);
        vrNomeEquie.setAdapter(adaptado);
    }

    // @Override //Método Onclique
    public void onClick(View v) {
        if (v.getId() == R.id.layoutTelaEquipeBotaoGravar) {
            gravarEscala(v);
        }
        if (v.getId() == R.id.TelaPerfilbotaoEscala) {
            EscalaSelect(v);
        }
    }
    //Metodo Gravar
    public void gravarEscala(View v){
        vrBancoDeDados = new EscalaDao(this);
        ContentValues dados = new ContentValues();
        dados.put("data", this.vrData.getText().toString());
        dados.put("nomePessoa", this.vrNomePesspa.getSelectedItem().toString());
        dados.put("equipe", this.vrNomeEquie.getSelectedItem().toString());
        vrBancoDeDados.insereEscala(dados);
        vrBancoDeDados.listaEscalas();
        Intent intencaoVaiParaLista = new Intent(TelaLayoutEscala.this, ListaEscala.class);
        startActivity(intencaoVaiParaLista);
        finish();

    }

    public void EscalaSelect(View v){
        Intent intencaoVaiParaListaEq = new Intent(TelaLayoutEscala.this, ListaEscala.class);
        startActivity(intencaoVaiParaListaEq);
        finish();
    }

    public void voltar(View botaoSair) {
        Intent intencaoVaiParacadastro = new Intent(TelaLayoutEscala.this, TelaLayoutCadastro.class);
        startActivity(intencaoVaiParacadastro);
        finish();
    }
}
