package com.example.milenal.listoapp.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.milenal.listoapp.R;
import com.example.milenal.listoapp.conection.Conection;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Date;

public class Progression extends AppCompatActivity {

    private TextView txtAtividadesGuia;

    private String descricao;
    private String item; //Array?
    private String ramo;
    private Date data;

    private FirebaseAuth auth;
    private FirebaseUser user;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressao_ramo_escoteiro);
        startComponents();
    }

    private void startComponents() {
        txtAtividadesGuia = findViewById(R.id.txtAtividadesGuia);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conection.getFirebaseAuth();
        user = Conection.getFirebaseUser();
        verifyUser();
    }

    private void verifyUser() {
        if (user == null){
            finish();
        }/*else{

        }*/
    }

    public Progression() {
    }

    public Progression(String descricao, String item, String ramo, Date data) {
        this.descricao = descricao;
        this.item = item;
        this.ramo = ramo;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getItem() {
        return item;
    }

    public String getRamo() {
        return ramo;
    }

    public Date getData() {
        return data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
