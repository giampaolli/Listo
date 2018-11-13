package com.example.milenal.listoapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.milenal.listoapp.R;

public class Library extends AppCompatActivity {

    //Setar as imagens antes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
    }

    public void openBook(View view){
        startActivity(new Intent(this, Book.class));
    }
}
