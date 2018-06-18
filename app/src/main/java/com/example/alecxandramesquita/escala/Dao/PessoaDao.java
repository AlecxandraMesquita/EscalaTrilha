package com.example.alecxandramesquita.escala.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import com.example.alecxandramesquita.escala.Model.Pessoa;

import java.util.ArrayList;

public class PessoaDao extends SQLiteOpenHelper {

    String [] scriptCriaBanco = {
            "CREATE TABLE Pessoa (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT NOT NULL, " +
                    "sobrenome TEXT NOT NULL, " +
                    "telefone TEXT NOT NULL, " +
                    "email TEXT NOT NULL, " +
                    "senha TEXT NOT NULL);",

            "CREATE TABLE Equipe (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nomeEquipe TEXT NOT NULL);",

            "CREATE TABLE Escala (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nomePessoa TEXT NOT NULL, " +
                    "equipe TEXT NOT NULL, " +
                    "data TEXT NOT NULL);"
    };

    public  final String scriptApagaDB = "DROP TABLE IF EXISTS Pessoa";

    Context vrContexto = null;

//    public PessoaDao(Context contexto,String nome, int versao) {
//        super(contexto, nome, null,versao);
//        vrContexto = contexto;
//    }

    public PessoaDao(Context vrContexto) {
        super(vrContexto, "BDEscala", null, 4);
    }

    @Override
    //CRIAÇAO
    public void onCreate(SQLiteDatabase db) {
        for (int iIndex = 0;iIndex < scriptCriaBanco.length ; iIndex++){
            db.execSQL(scriptCriaBanco[iIndex]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(scriptApagaDB);
    }

    //INSERÇĀO
    public void inserePessoa(ContentValues dados){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Pessoa", null, dados);
       // Toast.makeText(v.getContext(), "Inserçāo realizada com sucesso", Toast.LENGTH_SHORT).show();
    }

    //REMOÇĀO
    public void removePessoa(Pessoa p){
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {Integer.toString(p.get_id())};
        db.delete("Pessoa","_id = ?",params);
    }
    //CONSULTA
    public ArrayList<Pessoa> listaPessoas(){
        ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Pessoa", new String[]{"_id","nome", "sobrenome", "telefone", "email"}, null, null,null, null, null);

        while (cursor.moveToNext()) {

            Pessoa p = new Pessoa();
            p.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
            p.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            p.setSobrenome(cursor.getString(cursor.getColumnIndex("sobrenome")));
            p.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            p.setEmail(cursor.getString(cursor.getColumnIndex("email")));

            lista.add(p);

        }
        return lista;
    }

}