package com.example.milenal.listoapp.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.milenal.listoapp.R;
import com.example.milenal.listoapp.conection.Conection;
import com.example.milenal.listoapp.user.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.view.View.OnClickListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class MainActivity extends AppCompatActivity {

    private EditText editEmail, editSenha;
    private Button buttonEntrar;
    private TextView textEmail, textSenha, textEsqueciSenha, textNovoUsuario;
    private User usuario;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();
        verifyLoggedUser();
    }

    private void verifyLoggedUser() {
        auth = Conection.getFirebaseAuth();
        if(auth.getCurrentUser() != null){
            openProgression();
        }
    }

    private void openProgression() {
        startActivity(new Intent(this, Progression.class));
        finish();
    }

    public void btRegister(View view){
        startActivity(new Intent(this, User.class));
    }

    public void btForgotPassword(View view){
        startActivity(new Intent(this, ForgotPassword.class));
    }

    buttonEntrar.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            String txtEmail = textEmail.toString().trim();
            String txtSenha = textSenha.toString().trim();

            if (!txtEmail.isEmpty()){
                if(!txtSenha.isEmpty()){
                    usuario = new User();
                    usuario.setEmail();
                    usuario.setSenha();
                    validateLogin();
                }else{
                    Toast.makeText(MainActivity.this, "Preencha a senha", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(MainActivity.this, "Preencha o email", Toast.LENGTH_SHORT).show();
            }
        }
    });

    private void validateLogin() {
        auth = Conection.getFirebaseAuth();
        auth.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            openProgression();
                        }else{
                            String exception = "";
                            try{
                                throw task.getException();
                            }catch (FirebaseAuthInvalidUserException e){
                                exception = "Usuário não cadastrado.";
                            }catch (FirebaseAuthInvalidCredentialsException e){
                                exception = "Email ou senha inválidos.";
                            }catch (Exception e){
                                exception = "Erro ao cadastrar usuário: " + e.getMessage();
                                e.printStackTrace();
                            }

                            Toast.makeText(MainActivity.this, exception, Toast.LENGTH_SHORT).show();
                        }
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
