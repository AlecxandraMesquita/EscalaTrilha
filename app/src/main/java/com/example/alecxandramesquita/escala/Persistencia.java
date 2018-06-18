package com.example.alecxandramesquita.escala;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Alecxandra Mesquita on 31/03/2018.
 */

public class Persistencia {
    //base de dados da aplicaÃ§Ã£o
    public static void salvaPreferencias(boolean notificacoes, boolean preferencias, Context contexto){
        SharedPreferences favoritos = contexto.getSharedPreferences("favoritos", Activity.MODE_PRIVATE);
        //cria um editor para escrever no objeto
        SharedPreferences.Editor editor = favoritos.edit();
        //escreve no objeto(chave, valor)
        editor.putBoolean("notificacoes", notificacoes);
        editor.putBoolean("preferencias", preferencias);
        //comita a operaÃ§Ã£o
        editor.commit();
    }
    //metodos da classe
    public static boolean getNotificacoes(Context contexto){
        // abgra a base de dados com o mesmo nome usado na gravaÃ§Ã£o
        SharedPreferences favoritos = contexto.getSharedPreferences("favoritos", Activity.MODE_PRIVATE);
        //verifique se a chave jÃ¡ existe, Busca o valoe e retorna senao retorna padrao
        if(favoritos.contains("notificacoes")){
            //por padrao retorna um valor caso nÃ£o enconte
            return favoritos.getBoolean("notificacoes", false);
        }

        return false;
    }

    public static boolean getPreferencias(Context contexto){
        // abgra a base de dados com o mesmo nome usado na gravaÃ§Ã£o
        SharedPreferences favoritos = contexto.getSharedPreferences("favoritos", Activity.MODE_PRIVATE);
        //verifique se a chave jÃ¡ existe, Busca o valoe e retorna senao retorna padrao
        if(favoritos.contains("preferencias")){
            //por padrao retorna um valor caso nÃ£o enconte
            return favoritos.getBoolean("preferencias", false);
        }

        return false;
    }
}