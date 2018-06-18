package com.example.alecxandramesquita.escala.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.alecxandramesquita.escala.Model.Escala;

import java.util.ArrayList;

public class EscalaDao extends SQLiteOpenHelper {

        public  final String scriptApagaDB = "DROP TABLE IF EXISTS Escala";

        Context vrContexto = null;

//    public PessoaDao(Context contexto,String nome, int versao) {
//        super(contexto, nome, null,versao);
//        vrContexto = contexto;
//    }

    public EscalaDao(Context vrContexto) {
        super(vrContexto, "BDEscala", null, 4);
    }

    @Override
    //CRIAÇAO
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(scriptApagaDB);
    }

    //INSERÇĀO
    public void insereEscala(ContentValues dados){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Escala", null, dados);
//        Toast.makeText(vrContexto, "Inserçāo realizada com sucesso", Toast.LENGTH_SHORT).show();
    }

    //REMOÇĀO
    public void removeEscala(Escala e){
        SQLiteDatabase db = getWritableDatabase();
        String [] params =  {Integer.toString(e.getId())};
        db.delete("Escala","_id = ?",params);
    }
    //CONSULTA
    public ArrayList<Escala> listaEscalas(){
        ArrayList<Escala> lista = new ArrayList<Escala>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("Escala", new String[]{"_id","nomePessoa", "equipe", "data"}, null, null,null, null, null);

        while (cursor.moveToNext()) {


            Escala es = new Escala();
            es.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            es.setNomePessoa(cursor.getString(cursor.getColumnIndex("nomePessoa")));
            es.setEquipe(cursor.getString(cursor.getColumnIndex("equipe")));
            es.setData(cursor.getString(cursor.getColumnIndex("data")));


            lista.add(es);
        }
        return lista;
    }
}
