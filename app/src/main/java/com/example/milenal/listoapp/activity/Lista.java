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
            }
        }
        database.getReference().child("users").child(user.getId()).setValue(user);

    }

    public void switchItem(String selectImage) {
        switch (selectImage) {
            case "promessaEscoteiraRoover":
                selectableItems = generateItems();
                break;
            case "rooverComprometimento":
                selectList = listas.compromemetimentoCidadania();
                userList = user.getCompromemetimentoCidadania();
                selectableItems = iterateList(user.getCompromemetimentoCidadania(),
                        listas.compromemetimentoCidadania());
                break;
            case "rooverCidadania":
                selectableItems = listas.compromemetimentoCidadania();
                break;
            case "rooverAprender":
                selectList = listas.insigniaAprenderPioneiro();
                userList = user.getInsigniaAprenderPioneiro();
                selectableItems = iterateList(user.getInsigniaAprenderPioneiro(),
                        listas.insigniaAprenderPioneiro());
                break;
            case "rooverConeSul":
                selectableItems = listas.insigniaConeSulPioneiro();
                break;
            case "rooverLusofonia":
                selectableItems = listas.insigniaLusofoniaPioneiro();
                break;
            case "rooverBP":
                selectableItems = generateItems();
                break;
            default:
                selectableItems = generateItems();
                break;
        }



    }

    public List<Item> generateItems(){
        List<Item> selectableItems = new ArrayList<>();
        selectableItems.add(new Item("cem"));
        selectableItems.add(new Item("sezen"));
        selectableItems.add(new Item("baris"));

        return selectableItems;
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
