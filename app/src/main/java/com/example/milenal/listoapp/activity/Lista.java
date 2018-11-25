package com.example.milenal.listoapp.activity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.selection_list);
        recyclerView.setLayoutManager(layoutManager);
        List<Item> selectableItems = generateItems();
        adapter = new SelectableAdapter(this,selectableItems,true);
        recyclerView.setAdapter(adapter);
    }

    public List<Item> generateItems(){
        List<Item> selectableItems = new ArrayList<>();
        selectableItems.add(new Item("cem","karaca"));
        selectableItems.add(new Item("sezen","aksu"));
        selectableItems.add(new Item("baris","manco"));

        return selectableItems;
    }

    @Override
    public void onItemSelected(SelectableItem selectableItem) {

        List<Item> selectedItems = adapter.getSelectedItems();
//        Snackbar.make(recyclerView,"Selected item is "+selectableItem.getName()+
//                ", Totally  selectem item count is "+selectedItems.size(),Snackbar.LENGTH_LONG).show();
    }
}
