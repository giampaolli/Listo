package com.example.milenal.listoapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.milenal.listoapp.R;

public class Library extends AppCompatActivity {

    //Setar as imagens antes;
    ImageView livro1, livro2, livro3, livro4, livro5;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        livro1 = findViewById(R.id.livro1);
        livro2 = findViewById(R.id.livro2);
        livro3 = findViewById(R.id.livro3);
        livro4 = findViewById(R.id.livro4);
        livro5 = findViewById(R.id.livro5);

        livro1.setImageResource(R.drawable.por);
        livro2.setImageResource(R.drawable.primeiros_meses);
        livro3.setImageResource(R.drawable.cla_pioneiro_em_acao);
        livro4.setImageResource(R.drawable.fluxograma_de_progressao_ramo_pioneiro);
        livro5.setImageResource(R.drawable.caminho_para_o_sucesso);

    }

    public void openBook(View view){
        String tag = view.getTag().toString();
        Intent intent = new Intent(this, Book.class);
        intent.putExtra("tag", tag);
        startActivity(intent);
    }
}
