package com.example.milenal.listoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.milenal.listoapp.user.User;

public class MainActivity extends AppCompatActivity {

    private EditText editEmail, editSenha;
    private Button buttonEntrar;
    private TextView textEmail, textSenha, textEsqueciSenha, textNovoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startComponents();
        clickEvent();
    }

    private void clickEvent() {
        textNovoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),User.class);
                startActivity(intent);
            }
        });
    }

    private void startComponents(){
        editEmail = findViewById(R.id.edEmail);
        editSenha = findViewById(R.id.edSenha);
        textEmail = findViewById(R.id.txtEmail);
        textSenha = findViewById(R.id.txtSenha);
        textEsqueciSenha = findViewById(R.id.txtEsqueciSenha);
        textNovoUsuario = findViewById(R.id.txtNovoUsuario);
        buttonEntrar = findViewById(R.id.btnEntrar);
    }
}
