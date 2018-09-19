package com.example.milenal.listoapp.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.milenal.listoapp.R;
import com.example.milenal.listoapp.conection.Conection;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private EditText edtEmail;
    private Button btnResetSenha;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        startComponents();
    }

    private void startComponents() {
        //edtEmail = findViewById(R.id.etdEmail);
        //btnResetSenha = findViewById(R.id.btnReset);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conection.getFirebaseAuth();
    }

    btnResetSenha.setOnClickListener(new View.OnClickListener(){
        public void onClick (View v){
            String email = edtEmail.getText().toString().trim();
            resetPasword(email);
        }
    });

    private void resetPasword(String email) {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(ForgotPassword.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ForgotPassword.this, "Email encaminhado para alterar sua senha.", Toast.LENGTH_SHORT).show();
                            //finish();
                        }else{
                            Toast.makeText(ForgotPassword.this, "Email não cadastrado.", Toast.LENGTH_SHORT).show();
                            //finish();
                        }
                    }
                });
    }
}
