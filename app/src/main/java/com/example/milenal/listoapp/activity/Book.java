package com.example.milenal.listoapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.milenal.listoapp.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Book extends AppCompatActivity {

    PDFView book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        book = findViewById(R.id.pdfView);
        openBook("os_primeiros_meses_de_um_novo_cla_pioneiro.pdf");
    }

    public void openBook(String nameBook){
        book.fromAsset(nameBook).load();
    }
}
