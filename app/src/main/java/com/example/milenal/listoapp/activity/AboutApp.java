package com.example.milenal.listoapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.milenal.listoapp.R;

public class AboutApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        TextView aboutApp = findViewById(R.id.txtAbouApp);
        ImageView listo = findViewById(R.id.listo);

        aboutApp.setText("Trabalho de Conclusão de Curso realizado por Milena Lima Lopes." +
                "Orientado pelo Professor Tiago Souza. " +
                "A intenção deste aplicativo foi contribuir com a principal proposta da UEB " +
                "(União dos Escoteiros do Brasil), fazer com que o jovem assuma a própria " +
                "resposábilidade e desenvolvendo assim suas próprias habilidades.");

        listo.setImageResource(R.drawable.listo);


    }
}
