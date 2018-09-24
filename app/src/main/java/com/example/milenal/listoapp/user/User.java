package com.example.milenal.listoapp.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.milenal.listoapp.R;
import com.example.milenal.listoapp.conection.Conection;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User extends AppCompatActivity {

    private TextView txtEmail, txtNomeCompleto, txtDataNascimento, txtDataIntegracao, txtCargo, txtRamo, txtSenha;
    private EditText edtEmail, edtNomeCompleto, edtDataNascimento, edtDataIntegracao, edtSenha;
    private MultiAutoCompleteTextView autocompleteRamo, autcompleteCargo;
    private Button btnRegistrar;

    private String email;
    private String nome;
    private Date data_nascimento;
    private Date data_integracao;
    private String ramo;
    private String cargo;
    private String senha;

    private FirebaseAuth auth;

    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        startComponents();
        clickEvent();
    }

    private void clickEvent() {
        /*botaoVoltar.setOnClickListener(new View.OnClickListener(){
            public void onClick(){
                finish();
            }
        })*/
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String nome = edtNomeCompleto.getText().toString().trim();
                String data_nasc = edtDataNascimento.getText().toString().trim();
                String data_inte = edtDataIntegracao.getText().toString().trim();
                Date data_nasci = new Date();
                Date data_integ = new Date();
                try {
                    data_nasci = format.parse(data_nasc);
                    data_integ = format.parse(data_inte);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String ramo = autocompleteRamo.getText().toString().trim();
                String cargo = autcompleteCargo.getText().toString().trim();
                String senha = edtSenha.getText().toString().trim();
                createUser(email, nome, data_nasci, data_integ, ramo, cargo, senha);
            }
        });
    }

    private void createUser(String email, String nome, Date data_nasc, Date data_inte, String ramo, String cargo, String senha){
        auth.createUserWithEmailAndPassword(email,senha)
                .addOnCompleteListener(User.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            alert("Cadastro realizado com sucesso");
                            //Intent intent = new Intent(User.this, Progression.class);
                            //startActivity(intent);
                            finish();
                        }else{
                            alert("Erro de cadastro");
                        }
                    }
                });
    }

    private void alert(String msg){
        Toast.makeText(User.this, msg, Toast.LENGTH_SHORT).show();
    }

    private void startComponents(){
        txtEmail = findViewById(R.id.txtEmail2);
        txtNomeCompleto = findViewById(R.id.txtNomeCompleto);
        txtDataNascimento = findViewById(R.id.txtDataNascimento);
        txtDataIntegracao = findViewById(R.id.txtDataIntegracao);
        txtRamo = findViewById(R.id.txtRamo);
        txtCargo = findViewById(R.id.txtCargo);
        txtSenha = findViewById(R.id.txtSenha);
        edtEmail = findViewById(R.id.edtEmail2);
        edtNomeCompleto = findViewById(R.id.edtNomeCompleto);
        edtDataNascimento = findViewById(R.id.edtDataNascimento);
        edtDataIntegracao = findViewById(R.id.edtDataIntegracao);
        edtSenha = findViewById(R.id.edtSenha);
        autocompleteRamo = findViewById(R.id.autocompleteRamo);
        autcompleteCargo = findViewById(R.id.autocompleteCargo);
        btnRegistrar = findViewById(R.id.btnCadastrar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conection.getFirebaseAuth();
    }

    public User() {
    }

    public User(String email, String nome, Date data_nascimento, Date data_integracao, String ramo, String cargo, String senha) {
        this.email = email;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.data_integracao = data_integracao;
        this.ramo = ramo;
        this.cargo = cargo;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Date getData_integracao() {
        return data_integracao;
    }

    public void setData_integracao(Date data_integracao) {
        this.data_integracao = data_integracao;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
