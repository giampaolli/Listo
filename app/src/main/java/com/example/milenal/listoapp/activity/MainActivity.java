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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText editEmail, editSenha;
    private Button buttonEntrar;
    private User usuario;
    private FirebaseAuth auth;
    private DatabaseReference reference;
    User user = new User();
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void openProgression() {
        try {
            auth = Conection.getFirebaseAuth();
            FirebaseUser currentUser = Conection.getFirebaseUser();
            reference = database.getReference("users").child(currentUser.getUid());

            ValueEventListener userListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    user = dataSnapshot.getValue(User.class);
                    verifyUser(user.getRamo());
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {}
            };
            reference.addListenerForSingleValueEvent(userListener);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void btRegister(View view){ startActivity(new Intent(this, Register.class)); }

    public void btForgotPassword(View view){ startActivity(new Intent(this, ForgotPassword.class)); }

    //Realiza o login
    public void btLogin(View view){
        String email = editEmail.getText().toString().trim();
        String senha = editSenha.getText().toString().trim();

        if(!email.isEmpty()){
            if(!senha.isEmpty()){
                usuario = new User();
                usuario.setEmail(email);
                usuario.setSenha(senha);
            }else{
                Toast.makeText(MainActivity.this, "Preencha a senha", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(MainActivity.this, "Preencha o email", Toast.LENGTH_SHORT).show();
        }
        validateLogin();
    }

    //Faz a validação do login
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
        buttonEntrar = findViewById(R.id.btnEntrar);
    }

    private void verifyUser(String ramo){
        if(ramo != null){
            if(ramo == "Pioneiro" || ramo.equals("Pioneiro")){
                intent = new Intent(this, ProgressionRoover.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }else if(ramo == "Senior" || ramo.equals("Senior")){
                intent = new Intent(this, ProgressionSenior.class);
                startActivity(intent);
            }else if(ramo == "Escoteiro" || ramo.equals("Escoteiro")){
                intent = new Intent(this, ProgressionScout.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }else if(ramo == "Lobinho" || ramo.equals("Lobinho")){
                intent = new Intent(this, ProgressionWolf.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }else{
                intent = new Intent(this, ProgressionRoover.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        }else{
            intent = new Intent(this, ProgressionRoover.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }
    }

}
