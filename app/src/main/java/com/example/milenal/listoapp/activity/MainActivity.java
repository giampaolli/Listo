package com.example.milenal.listoapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.milenal.listoapp.conection.Conection;
import com.example.milenal.listoapp.user.Progression;
import com.example.milenal.listoapp.user.ResetSenha;
import com.example.milenal.listoapp.user.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText editEmail, editSenha;
    private Button buttonEntrar;
    private TextView textEmail, textSenha, textEsqueciSenha, textNovoUsuario;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startComponents();
//        clickEvent();
    }

    public void btCadastrar(View view){
        startActivity(new Intent(this, User.class));
    }

    public void btEsqueciSenha(View view){
        startActivity(new Intent(this, EsqueciSenha.class));
    }

//    private void clickEvent() {
//        textNovoUsuario.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),User.class);
//                startActivity(intent);
//            }
//        });
//
//        buttonEntrar.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//               String email = editEmail.getText().toString().trim();
//               String senha = editSenha.getText().toString().trim();
//               login(email, senha);
//            }
//        });
//
//        textEsqueciSenha.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ResetSenha.class);
//                startActivity(intent);
//            }
//        });
//    }

    private void login(String email, String senha) {
        auth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent = new Intent(MainActivity.this, Progression.class);
                            startActivity(intent);
                        }else{
                            alert("Email ou senha inválidos");
                        }
                    }
                });
    }

    private void alert(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conection.getFirebaseAuth();
    }
}
