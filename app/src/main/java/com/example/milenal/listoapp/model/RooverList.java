package com.example.milenal.listoapp.model;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.milenal.listoapp.R;
import com.example.milenal.listoapp.adapter.RecyclerAdapter;
import com.example.milenal.listoapp.adapter.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class RooverList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Roover> rooverList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roover_list);

        recyclerView = findViewById(R.id.recyclerView);

        //Lista de pioneiros
        createRooverList();

        //Configurar adapter
        RecyclerAdapter adapter = new RecyclerAdapter(rooverList);

        //Configurar recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //Evento de Click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(),recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener(){
                            @Override
                            public void onItemClick(View view, int position) {
                                Roover roover = rooverList.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item pressionado: " + roover.getItemProgression(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Roover roover = rooverList.get( position );
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click longo: "  + roover.getItemProgression(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        })
        );
    }

    public void createRooverList(){
        Roover roover = new Roover("item 1");
        rooverList.add(roover);

        roover = new Roover("item 2");
        rooverList.add(roover);

        roover = new Roover("item 3");
        rooverList.add(roover);
    }

}
