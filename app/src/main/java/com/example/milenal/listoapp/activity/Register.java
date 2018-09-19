package com.example.milenal.listoapp.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.milenal.listoapp.R;
import com.example.milenal.listoapp.conection.Conection;
import com.example.milenal.listoapp.user.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class Register extends AppCompatActivity {

    private TextView txtEmail, txtNome, txtDataNasc, txtDataInte, txtRamo, txtCargo, txtSenha;
    private EditText edtEmail, edtNome, edtDataNasc, edtDataInte, edtSenha;
    private MultiAutoCompleteTextView autoRamo, autoCargo;
    private Button btnCadastrar;
    private User usuario;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        startComponents();
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.toString().trim();
                String nome = edtNome.toString().trim();
                //String dataNasc = edtDataNasc.toString().trim();
                //String dataInte = edtDataInte.toString().trim();
                //String ramo = autoRamo.toString().trim();
                //String cargo = autoCargo.toString().trim();
                String senha = edtSenha.toString().trim();

                //Validação se os campos estão preenchidos
                if(!email.isEmpty()){
                    if(!nome.isEmpty()){
                        if(!senha.isEmpty()){
                            usuario = new User();
                            usuario.setEmail(email);
                            usuario.setNome(nome);
                            //usuario.setData_nascimento(dataNasc);
                            //usuario.setData_integracao(dataInte);
                            //usuario.setRamo(ramo);
                            //usuario.setCargo(cargo);
                            usuario.setSenha(senha);
                            insertUser();
                        }else{
                            Toast.makeText(Register.this, "Preencha a senha.", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Register.this, "Preencha o nome", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Register.this, "Preencha o email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void insertUser(){
        auth = Conection.getFirebaseAuth();
        auth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                        }else{
                            String exception = "";
                            try{
                                throw task.getException();
                            }catch (FirebaseAuthWeakPasswordException e){
                                exception = "Digite uma senha mais forte";
                            }catch (FirebaseAuthInvalidCredentialsException e){
                                exception = "Digite um email válido";
                            }catch (FirebaseAuthUserCollisionException e){
                                exception = "Esta conta já foi cadastrada";
                            }catch (Exception e){
                                exception = "Erro ao cadastrar usuário:" + e.getMessage();
                            }
                            Toast.makeText(Register.this, exception, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /*public void btRegistrar(View view ){
        FirebaseAuth firebaseAuth =  Conection.getFirebaseAuth();
    }*/

    public void startComponents(){
        txtEmail = findViewById(R.id.txtEmail);
        txtNome = findViewById(R.id.txtNomeCompleto);
        txtDataNasc = findViewById(R.id.txtDataNascimento);
        txtDataInte = findViewById(R.id.txtDataIntegracao);
        txtRamo = findViewById(R.id.txtRamo);
        txtCargo = findViewById(R.id.txtCargo);
        txtSenha = findViewById(R.id.txtSenha);
        edtEmail = findViewById(R.id.edtEmail);
        edtNome = findViewById(R.id.edtNomeCompleto);
        edtDataNasc = findViewById(R.id.edtDataNascimento);
        edtDataInte = findViewById(R.id.edtDataIntegracao);
        edtSenha = findViewById(R.id.edtSenha);
        autoRamo = findViewById(R.id.autocompleteRamo);
        autoCargo = findViewById(R.id.autocompleteCargo);
        btnCadastrar = findViewById(R.id.btnCadastrar);
    }
}
