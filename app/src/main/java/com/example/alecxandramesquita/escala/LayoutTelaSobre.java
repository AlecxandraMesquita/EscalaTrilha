package com.example.alecxandramesquita.escala;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LayoutTelaSobre extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_tela_sobre);

    }

    public void voltar(View botaoSair){
        finish();
    }
}
