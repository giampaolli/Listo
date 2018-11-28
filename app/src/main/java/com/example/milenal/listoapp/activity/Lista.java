package com.example.milenal.listoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.milenal.listoapp.R;
import com.example.milenal.listoapp.adapter.SelectableAdapter;
import com.example.milenal.listoapp.user.User;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity implements SelectableViewHolder.OnItemSelectedListener{

    RecyclerView recyclerView;
    SelectableAdapter adapter;
    List<Item> selectableItems = new ArrayList<Item>();
    List<Item> selectList;
    List<Boolean> userList;
    User user;
    Listas listas = new Listas();
    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);
        Intent myIntent = getIntent();
        user = (User) myIntent.getSerializableExtra("user");

        String selectImage = myIntent.getStringExtra("selectImage");
        switchItem(selectImage);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.selection_list);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SelectableAdapter(this,selectableItems,true);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.getReference().child("users").child(user.getId()).setValue(user);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        database.getReference().child("users").child(user.getId()).setValue(user);
    }

    @Override
    protected void onStop() {
        super.onStop();
        database.getReference().child("users").child(user.getId()).setValue(user);
    }

    @Override
    protected void onPause() {
        super.onPause();
        database.getReference().child("users").child(user.getId()).setValue(user);
    }

    @Override
    public void onItemSelected(SelectableItem selectableItem) {
        int count = 0;
        for(Item item : selectList) {
            if(item.getName().equals(selectableItem.getName())){
                userList.add(count, selectableItem.isSelected());
                break;
            }
            count++;
        }
        database.getReference().child("users").child(user.getId()).setValue(user);

    }

    public void switchItem(String selectImage) {
        switch (selectImage) {
            case "promessaEscoteiraRoover":
                selectList = listas.promessaRoover();
                userList = user.getPromessaRoover();
                break;
            case "rooverComprometimento":
                selectList = listas.compromemetimentoCidadania();
                userList = user.getCompromemetimentoCidadania();
                break;
            case "rooverCidadania":
                selectList = listas.compromemetimentoCidadania();
                userList = user.getCompromemetimentoCidadania();
                break;
            case "rooverAprender":
                selectList = listas.insigniaAprenderPioneiro();
                userList = user.getInsigniaAprenderPioneiro();
                break;
            case "rooverConeSul":
                selectList = listas.insigniaConeSulPioneiro();
                userList = user.getInsigniaConeSulPioneiro();
                break;
            case "rooverLusofonia":
                selectList = listas.insigniaLusofoniaPioneiro();
                userList = user.getInsigniaLusofoniaPioneiro();
                break;
            case "rooverBP":
                selectList = listas.insigniaLusofoniaPioneiro();
                userList = user.getInsigniaLusofoniaPioneiro();
                break;
            case "promessaSenior":
                selectList = listas.promessaEscoteiro();
                userList = user.getPromessaEscoteiro();
                break;
            case "seniorEscalada":
                selectList = listas.escoteiroPistaTrilha();
                userList = user.getEscoteiroPistaTrilha();
                break;
            case "seniorConquista":
                selectList = listas.escoteiroRumoTravessia();
                userList = user.getEscoteiroRumoTravessia();
                break;
            case "seniorAzimute":
                selectList = listas.escoteiroPistaTrilha();
                userList = user.getEscoteiroPistaTrilha();
                break;
            case "seniorAcaoComunitaria":
                selectList = listas.insigniaDesafioComunitarioSenior();
                userList = user.getInsigniaDesafioComunitarioSenior();
                break;
            case "seniorAprender":
                selectList = listas.insigniaAprenderSenior();
                userList = user.getInsigniaAprenderSenior();
                break;
            case "seniorLusofonia":
                selectList = listas.insigniaLusofoniaSenior();
                userList = user.getInsigniaLusofoniaSenior();
                break;
            case "seniorIMMA":
                break;
            case "seniorConeSul":
                selectList = listas.insigniaConeSulSenior();
                userList = user.getInsigniaConeSulSenior();
                break;
            case "seniorEspecHabilidade":
                break;
            case "seniorEspecDesportos":
                break;
            case "seniorEspecCultura":
                break;
            case "seniorEspecServicos":
                break;
            case "seniorEspecCiencias":
                break;
            case "seniorNaval":
                break;
            case "seniorAeronauta":
                break;
            case "seniorMateiro":
                break;
            case "seniorDesafioSenior":
                break;
            case "seniorCordaoDourado":
                break;
            case "seniorEscoteiroPatria":
                break;
            case "promessaLobo":
                selectList = listas.promessaEscoteiro();
                userList = user.getPromessaEscoteiro();
                break;
            case "wolfPataTenra":
                break;
            case "wolfSaltador":
                break;
            case "wolfRastreador":
                break;
            case "wolfCacador":
                break;
            case "wolfAcaoComunitaria":
                selectList = listas.insigniaBoaAcaoLobinho();
                userList = user.getInsigniaBoaAcaoLobinho();
                break;
            case "wolfAprender":
                selectList = listas.insigniaAprenderLobinho();
                userList = user.getInsigniaAprenderLobinho();
                break;
            case "wolfLusofonia":
                selectList = listas.insigniaLusofoniaLobinho();
                userList = user.getInsigniaLusofoniaLobinho();
                break;
            case "wolfConeSul":
                selectList = listas.insigniaConeSulLobinho();
                userList = user.getInsigniaConeSulLobinho();
                break;
            case "wolfIMMA":
                break;
            case "wolfEspecHabilidade":
                break;
            case "wolfEspecDesportos":
                break;
            case "wolfEspecCultura":
                break;
            case "wolfEspecServicos":
                break;
            case "wolfEspecCiencias":
                break;
            case "wolfCruzeiroSul":
                break;
            case "promessaScout":
                selectList = listas.promessaEscoteiro();
                userList = user.getPromessaEscoteiro();
                break;
            case "scoutPista":
                selectList = listas.escoteiroPistaTrilha();
                userList = user.getEscoteiroPistaTrilha();
                break;
            case "scoutTrilha":
                selectList = listas.escoteiroPistaTrilha();
                userList = user.getEscoteiroPistaTrilha();
                break;
            case "scoutRumo":
                selectList = listas.escoteiroRumoTravessia();
                userList = user.getEscoteiroRumoTravessia();
                break;
            case "scoutTravessia":
                selectList = listas.escoteiroRumoTravessia();
                userList = user.getEscoteiroRumoTravessia();
                break;
            case "scoutAcaoComunitaria":
                selectList = listas.insigniaAcaoComunitariaEscoteiro();
                userList = user.getInsigniaAcaoComunitariaEscoteiro();
                break;
            case "scoutAprender":
                selectList = listas.insigniaAprenderEscoteiro();
                userList = user.getInsigniaAprenderEscoteiro();
                break;
            case "scoutLusofonia":
                selectList = listas.insigniaLusofoniaEscoteiro();
                userList = user.getInsigniaLusofoniaEscoteiro();
                break;
            case "scoutIMMA":
                break;
            case "scoutConeSul":
                selectList = listas.insigniaConeSulEscoteiro();
                userList = user.getInsigniaConeSulEscoteiro();
                break;
            case "scoutEspecHabilidade":
                break;
            case "scoutEspecDesportos":
                break;
            case "scoutEspecCultura":
                break;
            case "scoutEspecServicos":
                break;
            case "scoutEspecCiencias":
                break;
            case "scoutGrumete":
                break;
            case "scoutAviador":
                break;
            case "scoutExplorador":
                break;
            case "scoutVerdeAmarelo":
                break;
            case "scoutVermelhoBranco":
                break;
            case "scoutLisOuro":
                break;
            default:
                selectList = listas.insigniaLusofoniaPioneiro();
                userList = user.getInsigniaLusofoniaPioneiro();
                break;
        }
        selectableItems = iterateList(userList,selectList);

    }

    private List<Item> iterateList(List<Boolean> list, List<Item> values){
        List<Item> newList = new ArrayList<>();
        int count = 0;
        Item item;
        for(Item i : values) {
            item = new Item(i.getName());
            item.setSelected(list.get(count));
            count++;
            newList.add(item);
        }

        return newList;
    }

}
