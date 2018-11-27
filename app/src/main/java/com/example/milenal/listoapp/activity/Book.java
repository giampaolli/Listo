package com.example.milenal.listoapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;

import com.example.milenal.listoapp.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Book extends AppCompatActivity {

    PDFView book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag");

        book = findViewById(R.id.pdfView);
        String bookName = getBook(tag);
        openBook(bookName);
    }

    public void openBook(String nameBook){
        book.fromAsset(nameBook).load();
    }

    public String getBook(String tag){
        switch(tag){
            case "livro1":
                return "por.pdf";
            case "livro2":
                return "os_primeiros_meses_de_um_novo_cla_pioneiro.pdf";
            case "livro3":
                return "cla_pioneiro_em_acao.pdf";
            case "livro4":
                return "fluxograma_de_progressao_ramo_pioneiro.pdf";
            case "livro5":
                return "caminho_para_o_sucesso.pdf";
            default:
                return "por.pdf";
        }
    }
}
