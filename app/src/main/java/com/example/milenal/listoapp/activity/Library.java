package com.example.milenal.listoapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.milenal.listoapp.R;
import com.example.milenal.listoapp.user.User;

public class Library extends AppCompatActivity {

    ImageView livro1, livro2, livro3, livro4, livro5;
    User user = new User();

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Intent myIntent = getIntent();
        user = (User) myIntent.getSerializableExtra("user");

        livro1 = findViewById(R.id.livro1);
        livro2 = findViewById(R.id.livro2);
        livro3 = findViewById(R.id.livro3);
        livro4 = findViewById(R.id.livro4);
        livro5 = findViewById(R.id.livro5);

        switchBook(user.getRamo());
    }

    public void openBook(View view){
        String tag = view.getTag().toString();
        Intent intent = new Intent(this, Book.class);
        intent.putExtra("tag", tag);
        startActivity(intent);
    }

    public void switchBook(String ramo){
        switch(ramo){
            case "Pioneiro":
                livro1.setImageResource(R.drawable.por);
                livro2.setImageResource(R.drawable.primeiros_meses);
                livro3.setImageResource(R.drawable.cla_pioneiro_em_acao);
                livro4.setImageResource(R.drawable.fluxograma_de_progressao_ramo_pioneiro);
                livro5.setImageResource(R.drawable.caminho_para_o_sucesso);
                break;
            case "Senior":
                livro1.setImageResource(R.drawable.por);
                livro2.setImageResource(R.drawable.ramo_senior_em_acao);
                livro3.setImageResource(R.drawable.fluxograma_de_progressao_ramo_senior);
                break;
            case "Escoteiro":
                livro1.setImageResource(R.drawable.por);
                livro2.setImageResource(R.drawable.tropa_escoteira_em_acao);
                livro3.setImageResource(R.drawable.fluxograma_de_progressao_ramo_escoteiro);
//                livro4.setImageResource(R.drawable.rumo_a_lis_de_ouro);
                break;
            case "Lobinho":
                livro1.setImageResource(R.drawable.por);
                livro2.setImageResource(R.drawable.alcateia_em_acao);
                livro3.setImageResource(R.drawable.fluxograma_de_progressao_ramo_lobinho);
                //livro4.setImageResource(R.drawable.os_livros_da_selva);
                break;
            default:
                livro1.setImageResource(R.drawable.por);
                livro2.setImageResource(R.drawable.primeiros_meses);
                livro3.setImageResource(R.drawable.cla_pioneiro_em_acao);
                livro4.setImageResource(R.drawable.fluxograma_de_progressao_ramo_pioneiro);
                livro5.setImageResource(R.drawable.caminho_para_o_sucesso);
                break;
        }
    }
}
