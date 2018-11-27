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
        String bookName = getBookRoover(tag);
        openBook(bookName);
    }

    public void openBook(String nameBook){
        book.fromAsset(nameBook).load();
    }

    public String getBookRoover(String tag){
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

    public String getBookSenior(String tag){
        switch(tag){
            case "livro1":
                return "por.pdf";
            case "livro2":
                return "ramo_senior_em_acao.pdf";
            case "livro3":
                return "fluxograma_de_progressao_ramo_senior.pdf";
            default:
                return "por.pdf";
        }
    }

    public String getBookScout(String tag){
        switch(tag){
            case "livro1":
                return "por.pdf";
            case "livro2":
                return "tropa_escoteira_em_acao.pdf";
            case "livro3":
                return "fluxograma_de_progressao_ramo_escoteiro.pdf";
            case "livro4":
                return "rumo_a_lis_de_ouro.pdf";
            default:
                return "por.pdf";
        }
    }

    public String getBookWolf(String tag){
        switch(tag){
            case "livro1":
                return "por.pdf";
            case "livro2":
                return "alcateia_em_acao.pdf";
            case "livro3":
                return "fluxograma_de_progressao_ramo_lobinho.pdf";
            case "livro4":
                return "os_livros_da_selva.pdf";
            default:
                return "por.pdf";
        }
    }
}
