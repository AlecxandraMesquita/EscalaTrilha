package com.example.alecxandramesquita.escala.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import com.example.alecxandramesquita.escala.Model.Equipe;
import com.example.alecxandramesquita.escala.Model.Pessoa;

import java.util.ArrayList;

public class EquipeDao extends SQLiteOpenHelper {

    public  final String scriptApagaDB = "DROP TABLE IF EXISTS Equipe";

    Context vrContexto = null;

    public EquipeDao(Context vrContexto) {
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
    public void insereEquipe(ContentValues dados){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Equipe", null, dados);
        //Toast.makeText(v.getContext(), "Inserçāo realizada com sucesso", Toast.LENGTH_SHORT).show();
    }

    //REMOÇĀO
    public void removeEquipe(Equipe e){
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {Integer.toString(e.getId())};
        db.delete("Equipe","id = ?",params);
    }
    //CONSULTA
    public ArrayList<Equipe> listaEquipes(){
        ArrayList<Equipe> lista = new ArrayList<Equipe>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Equipe", new String[]{"id","nomeEquipe"},null,null,null,null,null);

        while (cursor.moveToNext()) {

            Equipe e = new Equipe();
            e.setId(cursor.getInt(cursor.getColumnIndex("id")));
            e.setNomeEquipe(cursor.getString(cursor.getColumnIndex("nomeEquipe")));

            lista.add(e);
        }
        return lista;
    }
}
