package com.example.milenal.listoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.milenal.listoapp.R;
import com.example.milenal.listoapp.adapter.SelectableAdapter;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity implements SelectableViewHolder.OnItemSelectedListener{

    RecyclerView recyclerView;
    SelectableAdapter adapter;
    Listas listas = new Listas();
    List<Item> selectableItems = new ArrayList<Item>();
    List<Item> tempList = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        Intent myIntent = getIntent();
        String selectImage = myIntent.getStringExtra("selectImage");
        tempList = getSelectedList(selectImage);
        int count = 0;
        for ( Item i : tempList ){
            i.setSelected(false);
            selectableItems.add(i);
            count++;
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.selection_list);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SelectableAdapter(this,selectableItems,true);
        recyclerView.setAdapter(adapter);
    }

    public List<Item> generateItems(){
        List<Item> selectableItems = new ArrayList<>();
        selectableItems.add(new Item("cem"));
        selectableItems.add(new Item("sezen"));
        selectableItems.add(new Item("baris"));

        return selectableItems;
    }

    @Override
    public void onItemSelected(SelectableItem selectableItem) {

    }

    public List<Item> getSelectedList(String value) {
        switch (value) {
            case "promessaEscoteiraRoover":
                return generateItems();
            case "rooverComprometimento":
                return listas.compromemetimentoCidadania();
            case "rooverCidadania":
                return listas.compromemetimentoCidadania();
            case "rooverAprender":
                return listas.insigniaAprenderPioneiro();
            case "rooverConeSul":
                return listas.insigniaConeSulPioneiro();
            case "rooverLusofonia":
                return listas.insigniaLusofoniaPioneiro();
            case "rooverBP":
                return generateItems();
            default:
                return generateItems();
        }
    }

}
